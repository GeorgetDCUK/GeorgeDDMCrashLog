package com.example.george.ddmcrashlog;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class OnboardingInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Making tool bar/status bar disappear so i can put in custom one of my own
        // Detecting the sdk version allows to remove status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        // On create method to set layout view to onboarding screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_info);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        // User can swipe screen down to go back to splash
        // Will start splash screen activity
        // Using appropriate transition (anim up_in and up_out)
        findViewById(R.id.onboarding_constraint).setOnTouchListener(new OnSwipeTouchListener(OnboardingInfo.this) {
            public void onSwipeTop() {
                Intent intent2 = new Intent(OnboardingInfo.this, CrashLog_Splash.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.up_in, R.anim.up_out);
            }
        });
    }
    // If user does not want to swipe they can hit the drop down button to go back to splash
    // Uses appropriate transition
    public void BackToSplashFromPopUp(View view) {
        Intent intent = new Intent(this, CrashLog_Splash.class);
        startActivity(intent);
        overridePendingTransition(R.anim.up_in, R.anim.up_out);
    }
}

