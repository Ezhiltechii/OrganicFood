package com.sbtechnologies.organicfood;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    MaterialRippleLayout register;
    String url;

    String str_Name, str_Password, str_RePassword, str_Email, str_Mobile,
            random, str_Location;

    EditText edt_Name, edt_Password, edt_RePassword, edt_Email, edt_Mobile, edt_Gender, edt_Location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Log.d("SignUpActivity", "-----------onCreate");

        initComponent();

        register = (MaterialRippleLayout) findViewById(R.id.btn_register);
        edt_Name = (EditText) findViewById(R.id.edt_Rname);
        edt_Password = (EditText) findViewById(R.id.edt_Rpassword);
        edt_RePassword = (EditText) findViewById(R.id.edt_RRepassword);
        edt_Mobile = (EditText) findViewById(R.id.edt_Rmobile);
        edt_Email = (EditText) findViewById(R.id.edt_email);
        edt_Location = (EditText) findViewById(R.id.edt_location);
        edt_Gender = (EditText) findViewById(R.id.edt_gender);

        register.setOnClickListener(this);

    }

    private void initComponent() {
        (findViewById(R.id.edt_gender)).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                showGenderDialog(v);
            }
        });
        (findViewById(R.id.edt_location)).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                showLocationDialog(v);
            }
        });
    }

    @Override
    public void onClick(View v) {
        str_Name = edt_Name.getText().toString();
        str_Password = edt_Password.getText().toString();
        str_RePassword = edt_RePassword.getText().toString();
        str_Mobile = edt_Mobile.getText().toString();
        str_Email = edt_Email.getText().toString();
        str_Location = edt_Location.getText().toString();


        if (str_Name.length() == 0 & str_Password.length() == 0
                & str_RePassword.length() == 0 & str_Mobile.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "All fields are mandatory to fill", Toast.LENGTH_LONG)
                    .show();
        } else if (str_Name.length() == 0) {
            Toast.makeText(getApplicationContext(), "Please enter your Name",
                    Toast.LENGTH_LONG).show();
        } else if (str_Password.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your Password", Toast.LENGTH_LONG).show();
        } else if (str_RePassword.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please Re-enter your Password", Toast.LENGTH_LONG).show();
        }

        else if (str_Email.length() == 0) {
            Toast.makeText(getApplicationContext(),
                    "Please enter your Email Id", Toast.LENGTH_LONG).show();
        }

        else if (str_Password.contains(str_RePassword) != str_RePassword
                .contains(str_Password)) {
            Toast.makeText(getApplicationContext(),
                    "Confirm Password does not match", Toast.LENGTH_LONG)
                    .show();
        } else if (str_Mobile.length() == 0) {

            Toast.makeText(getApplicationContext(),
                    "Please enter your mobile number", Toast.LENGTH_LONG)
                    .show();
        } else if (str_Location.length() == 0) {

            Toast.makeText(getApplicationContext(),
                    "Please enter your Current Location", Toast.LENGTH_LONG)
                    .show();
        }

        else {
            Splash_Activity.editor.putString("name", str_Name);
            Splash_Activity.editor.putString("password", str_RePassword);
            Splash_Activity.editor.putString("email", str_Email);
            Splash_Activity.editor.putString("mobile", str_Mobile);
            Splash_Activity.editor.putString("location", str_Location);

            Splash_Activity.editor.commit();

            Intent sendToLogin = new Intent(getApplicationContext(),
                    LoginRegistrationActivity.class);

            Toast.makeText(getApplicationContext(),
                    "You have successfully registered", Toast.LENGTH_LONG)
                    .show();

            startActivity(sendToLogin);

        }
    }

    private void showGenderDialog(final View v) {
        final String[] array = new String[]{
                "Male", "Female", "Other"
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Age");
        builder.setSingleChoiceItems(array, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((EditText) v).setText(array[i]);
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void showLocationDialog(final View v) {
        final String[] array = new String[]{
                "Tambaram East","Tambaram West","Chromepet","Pallavaram","Meenambakkam","Thirisulam","St.Thomas Mount"
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Location");
        builder.setSingleChoiceItems(array, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((EditText) v).setText(array[i]);
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
