package com.mc.josaahelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CollegeOutputsActivityFinal extends AppCompatActivity {
    private String mExamType, mCategory,mBranch;
    //private int mMarks;
    private TextView mExamTV, mCategoryTV, mBranchTV,mPredictedRankTV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_outputs_final);

        Bundle extras = getIntent().getExtras();
        mExamType = extras.getString("examtype");
        mCategory = extras.getString("category");
        mBranch = extras.getString("branch");

        mExamTV = findViewById(R.id.examtypetext);
        mCategoryTV = findViewById(R.id.categorytext);
        mBranchTV = findViewById(R.id.branchtypetext);
        mPredictedRankTV=findViewById(R.id.predictedranktext);


        mExamTV.setText(mExamType);
        mCategoryTV.setText(mCategory);
        mBranchTV.setText(mBranch);
        mPredictedRankTV.setText("300");


    }
}