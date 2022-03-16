package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mRankButton, mCollegeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRankButton = findViewById(R.id.button);
        mCollegeButton = findViewById(R.id.button2);

        mRankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RankInputsActivity.class);
                //i.putExtra("username", mUsername);
                startActivity(i);
            }
        });

        mCollegeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CollegeInputsActivity.class);
                startActivity(i);
            }
        });
    }
}