package com.example.george.ddmcrashlog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CrashLog_Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_log_splash);
    }

    public void splashButtonClick(View view) {
        Intent intent = new Intent(this, CrashLog_LogIn.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }

    public void infoOnboardingView(View view) {
        Intent intent = new Intent(this, OnboardingInfo.class);
        startActivity(intent);
        overridePendingTransition(R.anim.down_in, R.anim.down_out);
    }
}
