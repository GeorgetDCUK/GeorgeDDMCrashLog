package com.example.george.ddmcrashlog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CrashLog_Main extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_log_main);
    }

    // Start Android Bug tracker activity - Start to track bugs and connect to sql local to store in db
    public void StartAndroidBugTracker(View view) {
        Intent intent = new Intent(this, android_bug_tracker.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
}