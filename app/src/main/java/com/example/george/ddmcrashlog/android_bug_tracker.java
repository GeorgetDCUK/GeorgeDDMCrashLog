package com.example.george.ddmcrashlog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Android_Bug_Tracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_bug_tracker);
    }
    // Starts next activity Android_Bug_Tracker2
    public void AndroidScreen2(View view) {
        Intent intent = new Intent(this, Android_Bug_Tracker2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
    // Go back to Main Screen
    public void BackArrowToMain(View view) {
        Intent intent = new Intent(this, Android_Platform_Choice.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        onBackPressed();
    }

    public void LogOut(View view) {
        Intent intent = new Intent(this, CrashLog_LogIn.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
}
