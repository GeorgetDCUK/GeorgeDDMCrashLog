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

public class CrashLog_Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Making tool bar/status bar disappear so i can put in custom one of my own
        // Detecting the sdk version allows to remove status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        // On create method to set layout view to crash log splash screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_log_splash);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
       // overridePendingTransition(android.R.anim.bounce_interpolator, android.R.anim.bounce_interpolator);

        StartSmartAnimation.startAnimation( findViewById(R.id.ddm_logo) ,
                AnimationType.RubberBand , 1000 , 0 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.textView5) ,
                AnimationType.RubberBand , 1000 , 0 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.continue_button) ,
                AnimationType.RubberBand , 1000 , 0 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.info_button) ,
                AnimationType.RubberBand , 1000 , 0 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.swipe_up_text) ,
                AnimationType.RubberBand , 1000 , 0 , true );


        // Use onswipe touch listener to allow user to swipe up from the bottom to get the onboarding screen
        // Starts activity of onboarding screen
        // With correct transition to come up from the bottom (anim down_in and down_out)
        findViewById(R.id.splash_constraint).setOnTouchListener(new OnSwipeTouchListener(CrashLog_Splash.this) {
            public void onSwipeBottom() {
                Intent intent2 = new Intent(CrashLog_Splash.this, OnboardingInfo.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.down_in, R.anim.down_out);
            }
        });
    }
    // Continue button to go to login screen
    public void splashButtonClick(View view) {
        Intent intent = new Intent(this, CrashLog_LogIn.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
    // If user does not want to swipe up for onboarding, they can press the icon
    public void infoOnboardingView(View view) {
        Intent intent = new Intent(this, OnboardingInfo.class);
        startActivity(intent);
        overridePendingTransition(R.anim.down_in, R.anim.down_out);
    }
}
