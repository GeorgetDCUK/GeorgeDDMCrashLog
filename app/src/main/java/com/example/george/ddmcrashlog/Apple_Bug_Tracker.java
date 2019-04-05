package com.example.george.ddmcrashlog;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class Apple_Bug_Tracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple_bug_tracker);

        // Making tool bar/status bar disappear so i can put in custom one of my own
        // Detecting the sdk version allows to remove status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    // Go back to Main Screen
    public void BackArrowToMain(View view) {
        Intent intent = new Intent(this, Apple_Platform_Choice.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        onBackPressed();
    }

    // Log user out functionality
    public void LogOut(View view) {
        Intent intent = new Intent(this, CrashLog_LogIn.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    // Find edit text id's to validate input for
    // Compare the fields, if empty -> error toasts
    // error messages
    // change text field backgrounds when error/correct credentials
    // Red for error and don't match, and green for successful
    // If all fields filled, next screen
    public void AppleTrackerValidation(View view) {

        EditText editTextID = findViewById(R.id.crash_id);
        EditText editTextLocation = findViewById(R.id.location_field);
        EditText editTextDescription = findViewById(R.id.description_field);

        try {
            if (editTextDescription == null || editTextID == null || editTextLocation == null ||
                    editTextID.getText().toString().isEmpty() ||
                    editTextLocation.getText().toString().isEmpty() ||
                    editTextDescription.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please fill in the required fields",
                        Toast.LENGTH_SHORT).show();
                editTextID.setError("Please fill in the crash ID number");
                editTextLocation.setError("Please fill in the crash location");
                editTextDescription.setError("Please provide a description or steps of the crash");
                editTextID.setBackgroundResource(R.drawable.errorbackground);
                editTextLocation.setBackgroundResource(R.drawable.errorbackground);
                editTextDescription.setBackgroundResource(R.drawable.errorbackground);
                throw new IllegalStateException();
            } else {
                editTextID.setError(null);
                editTextLocation.setError(null);
                editTextDescription.setError(null);
                editTextID.setBackgroundResource(R.drawable.successbackground);
                editTextLocation.setBackgroundResource(R.drawable.successbackground);
                editTextDescription.setBackgroundResource(R.drawable.successbackground);

                // If success - take user to next screen with overriden transition
                Intent intent = new Intent(this, Apple_Bug_Tracker2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
            }
        } catch (IllegalStateException d) {
            d.printStackTrace();
        }
    }
}




