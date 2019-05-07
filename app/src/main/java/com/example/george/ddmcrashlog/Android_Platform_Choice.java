package com.example.george.ddmcrashlog;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

public class Android_Platform_Choice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_platform_choice);

//        StartSmartAnimation.startAnimation( findViewById(R.id.lcp_linear) ,
//                AnimationType.Pulse , 1000 , 100 , true );
//        StartSmartAnimation.startAnimation( findViewById(R.id.hypo_linear) ,
//                AnimationType.Pulse , 1000 , 200 , true );
//        StartSmartAnimation.startAnimation( findViewById(R.id.gro_linear) ,
//                AnimationType.Pulse , 1000 , 300 , true );
//        StartSmartAnimation.startAnimation( findViewById(R.id.back_arrow) ,
//                AnimationType.RotateIn , 1000 , 300 , true );
//        StartSmartAnimation.startAnimation( findViewById(R.id.log_out) ,
//                AnimationType.RotateIn , 1000 , 300 , true );

        // Making tool bar/status bar disappear so i can put in custom one of my own
        // Detecting the sdk version allows to remove status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    public void StartAndroidBugTracker(View view) {
        Intent intent = new Intent(this, Android_Bug_Tracker.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }

    public void BackToMain(View view) {
        Intent intent = new Intent(this, CrashLog_Main.class);
        startActivity(intent);
        overridePendingTransition(R.anim.up_in, R.anim.up_out);
    }

    public void LogOut(View view) {
        Intent intent = new Intent(this, CrashLog_LogIn.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
}
