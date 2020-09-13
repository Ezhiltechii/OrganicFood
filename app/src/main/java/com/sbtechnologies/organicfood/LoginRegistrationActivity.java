package com.sbtechnologies.organicfood;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

public class LoginRegistrationActivity extends AppCompatActivity {

    MaterialRippleLayout login, register;
    TextView linkSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registraion);
        login = (MaterialRippleLayout) findViewById(R.id.btn_login);
        register = (MaterialRippleLayout) findViewById(R.id.btn_register);
        linkSkip = (TextView) findViewById(R.id.btn_skipLogin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(register);
            }
        });
        linkSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skip = new Intent(getApplicationContext(), HomeNavigationActivity.class);
                startActivity(skip);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}