package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rankButton = findViewById(R.id.button);
        Button collegeButton = findViewById(R.id.button2);
        Button profileButton = findViewById(R.id.button3);

        rankButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, RankInputsActivity.class);
            startActivity(i);
        });

        collegeButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, CollegeInputsActivity.class);
            startActivity(i);
        });

        profileButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, CollegeProfileActivity.class);
            startActivity(i);
        });
    }
}