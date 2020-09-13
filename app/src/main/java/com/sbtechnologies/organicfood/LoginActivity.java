package com.sbtechnologies.organicfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    String str_UserName, str_Password, str_getID, str_getPass;
    EditText edt_UName, edt_Password;
    TextView register;
    MaterialRippleLayout login_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("LoginActivity", "------------------onCreate");


        str_getID = Splash_Activity.sharedPreferences.getString("name", null);
        str_getPass = Splash_Activity.sharedPreferences.getString("password", null);
        login_layout = (MaterialRippleLayout) findViewById(R.id.btn_login);
        edt_UName = (EditText) findViewById(R.id.edt_userName);
        edt_Password = (EditText) findViewById(R.id.edt_password);
        register = (TextView) findViewById(R.id.link_register);

        login_layout.setOnClickListener((View.OnClickListener) this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(login);
            }
        });
    }

    @Override
    public void onClick(View v) {
        str_UserName = edt_UName.getText().toString();
        str_Password = edt_Password.getText().toString();

        /* make edittext condition for empty, input etc match */

        if (str_UserName.length() == 0 & str_Password.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your login User Name and Password",
                    Toast.LENGTH_LONG).show();
        } else if (str_UserName.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your User Name", Toast.LENGTH_LONG).show();
        } else if (str_Password.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your Password", Toast.LENGTH_LONG).show();
        }

        else if (str_getID.matches("") && str_getPass.matches("")) {
            Toast.makeText(getApplicationContext(),
                    "Details does not belongs to any account",
                    Toast.LENGTH_LONG).show();
        }

        else if (!(str_UserName.matches(str_getID))) {
            Toast.makeText(getApplicationContext(),
                    "Either login/password is incorrect", Toast.LENGTH_LONG)
                    .show();
        }

        else if (!(str_getPass.matches(str_Password))) {
            Toast.makeText(getApplicationContext(),
                    "Either login/password is incorrect", Toast.LENGTH_LONG)
                    .show();
        }

        else if ((str_getID.matches(str_UserName))
                && (str_getPass.matches(str_Password))) {
            Splash_Activity.editor.putString("loginTest", "true");
            Splash_Activity.editor.commit();

            Toast.makeText(getApplicationContext(),
                    "You have successfuly login", Toast.LENGTH_LONG).show();
            Intent profileActivity = new Intent(getApplicationContext(),
                    HomeNavigationActivity.class);
            startActivity(profileActivity);
        }
    }
}
