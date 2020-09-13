package com.sbtechnologies.organicfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class Splash_Activity extends AppCompatActivity {
    public static String str_login_test;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        // here initializing the shared preference
        sharedPreferences = getSharedPreferences("myprefe", 0);
        editor = sharedPreferences.edit();

        // check here if user is login or not
        str_login_test = sharedPreferences.getString("loginTest", null);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
            return;
        }

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                /*
                 * if user login test is true on oncreate then redirect the user
                 * to result page
                 */

                if (str_login_test != null
                        && !str_login_test.toString().trim().equals("")) {
                    Intent send = new Intent(getApplicationContext(),
                            ProfileActivity.class);
                    startActivity(send);
                }
                /*
                 * if user login test is false on oncreate then redirect the
                 * user to login & registration page
                 */
                else {

                    Intent send = new Intent(getApplicationContext(),
                            LoginRegistrationActivity.class);
                    startActivity(send);

                }
            }

        }, 10);

    }

}
