package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class CollegeOutputsActivity extends AppCompatActivity {

    private Spinner mBranchSpinner;
    private Spinner mQuotaSpinner;
    private Spinner mGenderSpinner;
    private Button mPredict;
    private String mBranch;
    private String mQuota;
    private String mGender;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_outputs);

        mBranchSpinner = findViewById(R.id.spinner);
        mQuotaSpinner = findViewById(R.id.spinner2);
        mGenderSpinner = findViewById(R.id.spinner3);
        mPredict = findViewById(R.id.button3);

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.branch, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mBranchSpinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 =ArrayAdapter.createFromResource(this, R.array.quota, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mQuotaSpinner.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 =ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mGenderSpinner.setAdapter(adapter2);

        mPredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBranchSpinner.getSelectedItemId() == -1){
                    Toast.makeText(CollegeOutputsActivity.this, "Choose a branch", Toast.LENGTH_SHORT).show();
                }
                else if(mQuotaSpinner.getSelectedItemId() == -1){
                    Toast.makeText(CollegeOutputsActivity.this, "Choose a Quota", Toast.LENGTH_SHORT).show();
                }
                else if (mGenderSpinner.getSelectedItemId() == -1){
                    Toast.makeText(CollegeOutputsActivity.this, "Choose a gender", Toast.LENGTH_SHORT).show();
                }
                else {

                    mBranch = mBranchSpinner.getSelectedItem().toString();
                    mQuota = mQuotaSpinner.getSelectedItem().toString();
                    mGender = mGenderSpinner.getSelectedItem().toString();

                    //Moving to the next activity
                    Intent i = new Intent(CollegeOutputsActivity.this, CollegeOutputsActivityFinal.class);
                    i.putExtra("examtype", getIntent().getStringExtra("examtype"));
                    i.putExtra("category", getIntent().getStringExtra("category"));
                    i.putExtra("marks", getIntent().getStringExtra("marks"));
                    i.putExtra("branch", mBranch);
                    i.putExtra("quota", mQuota);
                    i.putExtra("gender", mGender);

                    startActivity(i);

                }
            }
        });
    }
}