package com.example.tanauan_tales;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        txt_Name = findViewById(R.id.txt_Name);
        txt_Email = findViewById(R.id.txt_Email);
        txt_Pass = findViewById(R.id.txt_Password);
        register_btn = findViewById(R.id.register_btn);
        back_btn = findViewById(R.id.backBtn);
        dbms = new DatabaseManager(this);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToLogin();
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDetails(view);
            }
        });
    }

    DatabaseManager dbms;
    private EditText txt_Name, txt_Email, txt_Pass;
    Button register_btn;
    ImageButton back_btn;

    private void saveDetails(View view)
    {
        String contentA = txt_Name.getText().toString().trim();
        String contentB = txt_Email.getText().toString().trim();
        String contentC = txt_Pass.getText().toString().trim();
        String[][] contents = dbms.getData();

        if (contentA.equals("") || contentB.equals("") || contentC.equals(""))
        {
            for(int i = 0; i < contents.length; i++)
            {
                String emailID = contents[i][0];
                String passwordID = contents[i][1];
            }
            Toast.makeText(this,"No Input Detected", Toast.LENGTH_LONG).show();
            return;
        }
        dbms.setData(contentA, contentB, contentC);
        Toast.makeText(this,"Registration Complete", Toast.LENGTH_LONG).show();
        returnToLogin();
    }

    private void returnToLogin()
    {
        Intent loginIntent = new Intent(getApplicationContext(), LogIn.class);
        startActivity(loginIntent);
    }
}
