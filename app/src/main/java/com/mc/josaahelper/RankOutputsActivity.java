package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RankOutputsActivity extends AppCompatActivity {
    private String mExamType, mCategory;
    private int mMarks;
    private TextView mExamTV, mCategoryTV, mMarksTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_outputs);

        Bundle extras = getIntent().getExtras();
        mExamType = extras.getString("examtype");
        mCategory = extras.getString("category");
        mMarks = extras.getInt("marks");

        mExamTV = findViewById(R.id.textView11);
        mCategoryTV = findViewById(R.id.textView12);
        mMarksTV = findViewById(R.id.textView13);

        mExamTV.setText(mExamType);
        mCategoryTV.setText(mCategory);
        mMarksTV.setText(String.valueOf(mMarks));
    }
}