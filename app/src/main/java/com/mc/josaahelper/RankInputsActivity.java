package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RankInputsActivity extends AppCompatActivity {
    private RadioGroup mExamRadioGroup;
    private RadioButton mExamRadioButton;
    private Spinner mCategorySpinner;
    private EditText mMarksEditText;
    private Button mPredictButton;
    private String mExamType, mCategory;
    private int mMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_inputs);

        mCategorySpinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mCategorySpinner.setAdapter(adapter);

        mExamRadioGroup = findViewById(R.id.radioGroup);
        mMarksEditText = findViewById(R.id.editTextNumber);
        mPredictButton = findViewById(R.id.button3);

        mPredictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mExamRadioGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(RankInputsActivity.this, "Choose an Exam Type", Toast.LENGTH_SHORT).show();
                }
                else if(mCategorySpinner.getSelectedItemId() == -1){
                    Toast.makeText(RankInputsActivity.this, "Choose a Category", Toast.LENGTH_SHORT).show();
                }
                else if (mMarksEditText.getText().toString().trim().length() == 0){
                    Toast.makeText(RankInputsActivity.this, "Enter Marks", Toast.LENGTH_SHORT).show();
                }
                else {
                    mExamRadioButton = (RadioButton) findViewById(mExamRadioGroup.getCheckedRadioButtonId());
                    mExamType = mExamRadioButton.getText().toString();
                    mCategory = mCategorySpinner.getSelectedItem().toString();
                    mMarks = Integer.parseInt(mMarksEditText.getText().toString());

                    if (mExamRadioGroup.getCheckedRadioButtonId() == R.id.radioButton && (mMarks < 0 || mMarks > 300)){
                        Toast.makeText(RankInputsActivity.this, "For Jee Mains: Enter marks in range 0 to 300", Toast.LENGTH_SHORT).show();
                    }
                    else if (mExamRadioGroup.getCheckedRadioButtonId() == R.id.radioButton2 && (mMarks < 0 || mMarks > 366)){
                        Toast.makeText(RankInputsActivity.this, "For Jee Advanced: Enter marks in range 0 to 366", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent i = new Intent(RankInputsActivity.this, RankOutputsActivity.class);
                        i.putExtra("examtype", mExamType);
                        i.putExtra("category", mCategory);
                        i.putExtra("marks", mMarks);
                        startActivity(i);
                    }
                }
            }
        });
    }
}