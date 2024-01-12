package com.example.tanauan_tales;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ImageButton logoutButton = findViewById(R.id.logout_btn);
        CardView card1 = findViewById(R.id.card1);
        CardView card2 = findViewById(R.id.card2);
        CardView card3 = findViewById(R.id.card3);
        CardView card4 = findViewById(R.id.card4);
        CardView card5 = findViewById(R.id.card5);
        CardView card6 = findViewById(R.id.card6);
        CardView card7 = findViewById(R.id.card7);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseManager dbManager = new DatabaseManager(getApplicationContext());
                dbManager.logoutUser();
                returnToLogin();
            }
        });

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startContentActivity(1);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startContentActivity(2);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startContentActivity(3);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startContentActivity(4);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startContentActivity(5);
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startContentActivity(6);
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startContentActivity(7);
            }
        });

        String userName = getIntent().getStringExtra("USERNAME");
        if (userName != null) {
            TextView nameTextView = findViewById(R.id.name_hmpg);
            nameTextView.setText(userName);
        }
    }

    private void startContentActivity(int cardNumber) {
        Intent contentIntent = new Intent(getApplicationContext(), Content.class);
        contentIntent.putExtra("Count", cardNumber);
        startActivity(contentIntent);
    }

    private void returnToLogin() {
        Intent loginIntent = new Intent(getApplicationContext(), LogIn.class);
        Toast.makeText(this, "Logout Successfully", Toast.LENGTH_LONG).show();
        startActivity(loginIntent);
        finish();
    }
}
