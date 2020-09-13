package com.sbtechnologies.organicfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    String str_getName, str_getEmail, str_getMobile, str_getLocation;

    TextView named, mobile_no, email_id, profileTitle, emailTitle, userLocation;

    MaterialRippleLayout logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, HomeNavigationActivity.class));
                finish();
            }
        });

        str_getName = Splash_Activity.sharedPreferences.getString("name", null);
        str_getEmail = Splash_Activity.sharedPreferences.getString("email", null);
        str_getMobile = Splash_Activity.sharedPreferences.getString("mobile", null);
        str_getLocation = Splash_Activity.sharedPreferences.getString("location",null);


        named = (TextView) findViewById(R.id.name);
        mobile_no = (TextView) findViewById(R.id.mobile);
        email_id  = (TextView) findViewById(R.id.email_ID);
        profileTitle = (TextView) findViewById(R.id.profile_title);
        emailTitle = (TextView) findViewById(R.id.email_title);
        logout = (MaterialRippleLayout) findViewById(R.id.btnLogout);
        userLocation = (TextView) findViewById(R.id.location);

        /* set fetch data to textview, textview show the user complete profile */
        named.setText(str_getName);
        profileTitle.setText(str_getName);
        email_id.setText(str_getEmail);
        emailTitle.setText(str_getEmail);
        mobile_no.setText(str_getMobile);
        userLocation.setText(str_getLocation);


        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "You have successfully logout",
                Toast.LENGTH_LONG).show();
        Splash_Activity.editor.remove("loginTest");
        Splash_Activity.editor.commit();
        Intent sendToLoginandRegistration = new Intent(getApplicationContext(),
                LoginRegistrationActivity.class);
        startActivity(sendToLoginandRegistration);
    }
}
