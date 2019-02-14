package com.example.george.ddmcrashlog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class android_bug_tracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_bug_tracker);
    }
    // Starts next activity android_bug_tracker2
    public void AndroidScreen2(View view) {
        Intent intent = new Intent(this, android_bug_tracker2.class);
        startActivity(intent);
    }
    // Go back to Main Screen
    public void BackArrowToMain(View view) {
        Intent intent = new Intent(this, CrashLog_Main.class);
        startActivity(intent);
    }
}
