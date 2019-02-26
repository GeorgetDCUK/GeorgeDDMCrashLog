package com.example.george.ddmcrashlog;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class Apple_Bug_Tracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple_bug_tracker);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    // Go back to Main Screen
    public void BackArrowToMain(View view) {
        Intent intent = new Intent(this,Apple_Platform_Choice.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        onBackPressed();
    }

    public void LogOut(View view) {
        Intent intent = new Intent(this, CrashLog_LogIn.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void BugTrackerScreen2(View view) {

        EditText editTextID = (EditText) findViewById(R.id.crash_id);
        EditText editTextLocation = (EditText) findViewById(R.id.location_field);
        EditText editTextDescription = (EditText) findViewById(R.id.description_field);
        Drawable errorBackground = getApplicationContext().getResources().getDrawable(R.drawable.errorbackground);

        if (editTextID.getText().toString().isEmpty() || editTextLocation.getText().toString().isEmpty() || editTextDescription.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please fill in the required fields", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, Apple_Bug_Tracker2.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
    }
}
