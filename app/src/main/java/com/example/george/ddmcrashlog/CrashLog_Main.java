package com.example.george.ddmcrashlog;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.Timer;
import java.util.concurrent.DelayQueue;

public class CrashLog_Main extends AppCompatActivity {


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

        StartSmartAnimation.startAnimation( findViewById(R.id.text_field) ,
                AnimationType.Pulse , 400 , 0 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.apple_button) ,
                AnimationType.Pulse , 400 , 100 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.android_button) ,
                AnimationType.Pulse , 400 , 300 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.grad_divider) ,
                AnimationType.Pulse , 400 , 400 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.grad_circle) ,
                AnimationType.Pulse , 400 , 500 , true );

//        ImageView gradCircle = findViewById(R.id.grad_circle);
//        gradCircle.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    // Start Android Platform chooser - Start to track bugs and connect to sql local to store in db
    public void StartAndroidPlatformChooser(View view) {

        ImageButton androidButton = findViewById(R.id.android_button);

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(1, 2000);
        myAnim.setInterpolator(interpolator);
        androidButton.startAnimation(myAnim);

        ImageView androidImage = findViewById(R.id.android_image);
        androidImage.setVisibility(View.VISIBLE);
        ImageView appleImage = findViewById((R.id.apple_image));
        appleImage.setVisibility(View.INVISIBLE);
        Button continueButton = findViewById(R.id.continue_button);
        continueButton.setVisibility(View.VISIBLE);
        StartSmartAnimation.startAnimation( findViewById(R.id.continue_button) ,
                AnimationType.FadeInRight, 1500 , 500 , true , 1300);
        StartSmartAnimation.startAnimation( findViewById(R.id.android_image) ,
                AnimationType.Pulse , 350 , 0 , true );
        ImageView gradCircle = findViewById(R.id.grad_circle);
        gradCircle.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));

        //        Intent intent = new Intent(this, Android_Platform_Choice.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.down_in, R.anim.down_out);
    }


    public void NextActivity(View view) {

        ImageView apple = findViewById(R.id.apple_image);
        ImageView android = findViewById(R.id.android_image);

        if (apple.isShown()) {
            Intent intent = new Intent(this, Apple_Platform_Choice.class);
            startActivity(intent);
            overridePendingTransition(R.anim.down_in, R.anim.down_out);
        }

        else if (android.isShown()) {
            Intent intent = new Intent(this, Android_Platform_Choice.class);
            startActivity(intent);
            overridePendingTransition(R.anim.down_in, R.anim.down_out);
        }
    }

    // Starts apple app platform chooser
    public void StartApplePlatformChooser(View view) {

        ImageButton appleButton = findViewById(R.id.apple_button);

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(1, 2000);
        myAnim.setInterpolator(interpolator);
        appleButton.startAnimation(myAnim);

        ImageView appleImage = findViewById(R.id.apple_image);
        appleImage.setVisibility(View.VISIBLE);
        ImageView androidImage = findViewById((R.id.android_image));
        androidImage.setVisibility(View.INVISIBLE);
        Button continueButton = findViewById(R.id.continue_button);
        continueButton.setVisibility(View.VISIBLE);
        StartSmartAnimation.startAnimation( findViewById(R.id.continue_button) ,
                AnimationType.FadeInLeft, 1500 , 500 , true , 1300);
        StartSmartAnimation.startAnimation( findViewById(R.id.apple_image) ,
                AnimationType.Pulse , 350 , 0 , true );
        ImageView gradCircle = findViewById(R.id.grad_circle);
        gradCircle.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 3000f);
//            animator.setDuration(400);
//            animator.start();
//        }
//        Intent intent = new Intent(this, Apple_Platform_Choice.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.down_in, R.anim.down_out);
    }
}