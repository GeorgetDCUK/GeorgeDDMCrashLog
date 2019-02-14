package com.example.george.ddmcrashlog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class android_bug_tracker2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_bug_tracker2);
    }

    // Go back to Android bug tracker screen 1
    public void BackArrowToAndroid1(View view) {
        Intent intent = new Intent(this, android_bug_tracker.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        onBackPressed();
    }
}
