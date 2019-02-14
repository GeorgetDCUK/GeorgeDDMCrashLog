package com.example.george.ddmcrashlog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CrashLog_LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_log_login);
    }

   public void SignInClick(View view) {
        Intent intent = new Intent(this, CrashLog_Main.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }

    // Back arrow functionality
    public void BackArrow(View view) {
        Intent intent = new Intent(this, CrashLog_Splash.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
}
