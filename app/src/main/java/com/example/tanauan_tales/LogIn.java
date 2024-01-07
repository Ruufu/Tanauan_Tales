package com.example.tanauan_tales;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        Button btn_signup = findViewById(R.id.signup_btn);
        Button btn_login = findViewById(R.id.login_btn);
        EditText emailText = findViewById(R.id.email);
        EditText passwordText = findViewById(R.id.password);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(signupIntent);
            }
        });

        //TODO: LOGIN PARAMETERS
        //TODO: Email and Password EditText Usage
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
