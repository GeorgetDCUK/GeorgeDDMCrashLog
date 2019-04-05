package com.example.george.ddmcrashlog;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Objects;

public class Android_Bug_Tracker2 extends AppCompatActivity {

    private Dialog mEditBottomSheetDialog;
    private View mEditBottomsheetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Making tool bar/status bar disappear so i can put in custom one of my own
        // Detecting the sdk version allows to remove status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        // On create method to set view for android bug tracker screen 2 layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_bug_tracker2);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    // Go back to Android bug tracker screen 1
    public void BackArrowToAndroid1(View view) {
        Intent intent = new Intent(this, Android_Bug_Tracker.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        onBackPressed();
    }
    // Log user out functionality
    public void LogOut(View view) {
        Intent intent = new Intent(this, CrashLog_LogIn.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    // Saves the android crash data inputted
    public void SaveAndroidCrashData(View view) {
        if (mEditBottomSheetDialog == null) {
            mEditBottomSheetDialog = new Dialog(this, R.style.MaterialDialogSheet);
        }
            mEditBottomSheetDialog.setCancelable(false);
        if (mEditBottomsheetView == null) {
            mEditBottomsheetView = this.getLayoutInflater().inflate(R.layout.drawer_component,
                    null);
        }

        mEditBottomSheetDialog.setContentView(mEditBottomsheetView);
        Objects.requireNonNull(mEditBottomSheetDialog.getWindow())
                .setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        mEditBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
        mEditBottomSheetDialog.show();
    }

    public void ExitToMain(View view) {
        Intent intent = new Intent(this, CrashLog_Main.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
}