package com.example.george.ddmcrashlog;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.CycleInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

public class CrashLog_LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_log_login);

        // Making tool bar/status bar disappear so i can put in custom one of my own
        // Detecting the sdk version allows to remove status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        StartSmartAnimation.startAnimation( findViewById(R.id.ddm_logo) ,
                AnimationType.Pulse , 1000 , 100 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.welcome) ,
                AnimationType.Pulse , 1000 , 200 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.email_address_label) ,
                AnimationType.Pulse , 1000 , 300 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.email_field) ,
                AnimationType.Pulse , 1000 , 400 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.password_label) ,
                AnimationType.Pulse , 1000 , 500 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.password_field) ,
                AnimationType.Pulse , 1000 , 600 , true );
        StartSmartAnimation.startAnimation( findViewById(R.id.sign_in) ,
                AnimationType.Pulse , 1000 , 1000 , true );
    }

    // Detect the edit text fields to validate inputs
    // Checking user credentials entered are valid to proceed in app
    // If one or the other are empty -> Toast and blocked from proceeding
    // Add custom anim transition to go to next screen
    public void LogInValidation(View view) {
        EditText email = findViewById(R.id.email_field);
        EditText password = findViewById(R.id.password_field);

        if (email == null || email.getText().toString().isEmpty() ||
                password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please fill in your email and password to log in",
                    Toast.LENGTH_SHORT).show();
            email.setError("Please fill in your email");
            password.setError("Please fill in your password");
            email.setBackgroundResource(R.drawable.errorbackground);
            password.setBackgroundResource(R.drawable.errorbackground);
        } else if (!(email.getText().toString().matches("georget@ddm.health") &&
                password.getText().toString().matches("George"))) {
            Toast.makeText(this, "Credentials are invalid, please try again",
                    Toast.LENGTH_SHORT).show();
            email.setError("Email is Incorrect");
            password.setError("Password is Incorrect");
            email.setBackgroundResource(R.drawable.errorbackground);
            password.setBackgroundResource(R.drawable.errorbackground);
        } else {
            email.setBackgroundResource(R.drawable.successbackground);
            password.setBackgroundResource(R.drawable.successbackground);
            email.setError(null);
            password.setError(null);
            Intent intent = new Intent(this, CrashLog_Main.class);
            startActivity(intent);
            Button button = findViewById(R.id.sign_in);
            button.setText("LOADING...");
            ProgressBar progressBar = findViewById(R.id.progressbar);
            progressBar.setVisibility(View.VISIBLE);
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
    }

    public void ShortCut(View view) {
        Intent intent = new Intent(this, CrashLog_Main.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }

    // Back arrow functionality to go back to the splash screen
    public void BackArrow(View view) {
        Intent intent = new Intent(this, CrashLog_Splash.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
}
