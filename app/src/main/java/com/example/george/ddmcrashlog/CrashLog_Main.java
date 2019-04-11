package com.example.george.ddmcrashlog;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

import java.util.Timer;
import java.util.concurrent.DelayQueue;

public class CrashLog_Main extends AppCompatActivity {

    ImageButton androidButton;
    ImageButton appleButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Making tool bar/status bar disappear so i can put in custom one of my own
        // Detecting the sdk version allows to remove status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_log_main);

        androidButton = findViewById(R.id.android_button);
        appleButton = findViewById(R.id.apple_button);

//        StartSmartAnimation.startAnimation( findViewById(R.id.ddm_logo) ,
//                AnimationType.ShakeBand , 2000 , 0 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.android_button) ,
                AnimationType.Pulse , 1000 , 100 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.apple_button) ,
                AnimationType.Pulse , 1000 , 300 , true );
//        StartSmartAnimation.startAnimation( findViewById(R.id.textView11) ,
//                AnimationType.BounceIn , 1000 , 10 , true );

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    // Start Android Platform chooser - Start to track bugs and connect to sql local to store in db
    public void StartAndroidPlatformChooser(View view) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(1, 2000);
        myAnim.setInterpolator(interpolator);
        androidButton.startAnimation(myAnim);

        Intent intent = new Intent(this, Android_Platform_Choice.class);
        startActivity(intent);
        overridePendingTransition(R.anim.down_in, R.anim.down_out);
    }
    // Starts apple app platform chooser
    public void StartApplePlatformChooser(View view) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(1, 2000);
        myAnim.setInterpolator(interpolator);
        appleButton.startAnimation(myAnim);


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 3000f);
//            animator.setDuration(400);
//            animator.start();
//        }
        Intent intent = new Intent(this, Apple_Platform_Choice.class);
        startActivity(intent);
        overridePendingTransition(R.anim.down_in, R.anim.down_out);
    }
    // Log user out functionality
    public void LogOut(View view) {
        Intent intent = new Intent(this, CrashLog_LogIn.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
}