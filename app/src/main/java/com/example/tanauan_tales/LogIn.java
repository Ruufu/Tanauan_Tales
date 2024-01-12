package com.example.tanauan_tales;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class LogIn extends AppCompatActivity {

    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        dbManager = new DatabaseManager(this);

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

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailText.getText().toString().trim();
                String password = passwordText.getText().toString().trim();

                if (dbManager.checkLoginCredentials(email, password)) {
                    String userName = dbManager.getUserNameByEmail(email);

                    Intent loginIntent = new Intent(getApplicationContext(), HomePage.class);
                    loginIntent.putExtra("USERNAME", userName);
                    emailText.setText("");
                    passwordText.setText("");
                    startActivity(loginIntent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
