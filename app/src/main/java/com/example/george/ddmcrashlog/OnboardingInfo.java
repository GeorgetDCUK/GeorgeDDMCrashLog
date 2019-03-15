package com.example.george.ddmcrashlog;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;


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

        // Declare backgrounds being used (ImageViews)
        final ImageView backgroundOne = findViewById(R.id.background_one);
        final ImageView backgroundTwo = findViewById(R.id.background_two);

        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f); // Float points to start and end
        animator.setRepeatCount(0); // Repeat count to 0, set it inside of interpolator
        animator.setInterpolator(new CycleInterpolator(1)); // cyclic interpolator type, set amount of times to 1
        animator.setDuration(4000L); // Duration long value
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float height = backgroundOne.getHeight(); // attain height of background to then use this to attach my animation
                final float translationY = height * progress;
                backgroundOne.setTranslationY(translationY); // Sets it to vertical
                backgroundTwo.setTranslationY(translationY - height);
            }
        });
        animator.start(); // Starts animation when layout is created -> activity start will prompt it

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

