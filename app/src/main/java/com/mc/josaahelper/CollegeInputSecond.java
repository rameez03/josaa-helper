package com.mc.josaahelper;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CollegeInputSecond extends AppCompatActivity {
    private Spinner branch,quota,gender;
    private String mquota,mbranch,mgender;
    private Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_input_second);

        Button proceedbtn = (Button) findViewById(R.id.fragmentsecondnextbtn);
        branch = (Spinner)findViewById(R.id.branchSpinner);
        quota = (Spinner)findViewById(R.id.quotaSpinner);
        gender = (Spinner)findViewById(R.id.genderSpinner);

        ArrayAdapter<CharSequence> branchAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.branch,android.R.layout.simple_spinner_item);
        branchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch.setAdapter(branchAdapter);
        branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mbranch = branch.getSelectedItem().toString();
                Log.i("Branch", mbranch);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

// Adapter for quota
        ArrayAdapter<CharSequence> quotaAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.quota,android.R.layout.simple_spinner_item);
        quotaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quota.setAdapter(quotaAdapter);
        quota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mquota = quota.getSelectedItem().toString();
                Log.i("Quota", mquota);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

// Adapter for gender spinner
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Gender,android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genderAdapter);
// Set on click listener for gender
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //selectedquota = adapterView.getItemAtPosition(i).toString();
                mgender = gender.getSelectedItem().toString();
                Log.i("Gender", mgender);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        proceedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mbranch.equals("Select") && !mgender.equals("Select")) {
                    try {
                        Intent intent = getIntent();
                        Intent intent1 = new Intent(CollegeInputSecond.this, CollegeOutputsActivity.class);
                        //Log.i("Branch", mbranch);
                        bundle.putString("Branch", mbranch);
                        Log.i("College second input",mbranch+" "+intent.getStringExtra("Exam"));
                        bundle.putString("Quota", mquota);
                        bundle.putString("Gender", mgender);
                        bundle.putString("Exam", intent.getStringExtra("Exam"));
                        bundle.putString("Rank", intent.getStringExtra("Rank"));
                        bundle.putString("Category", intent.getStringExtra("Category"));
                        intent1.putExtras(bundle);
                        startActivity(intent1);
                    } catch (NullPointerException e) {
                        Log.d("Catch", "Null Pointer Exception");
                        e.printStackTrace();
                    }
                }
                else
                {
                    if(mbranch.equals("Select"))
                        Toast.makeText(getApplicationContext(), "Please select your branch...", Toast.LENGTH_SHORT).show();
                    if(mgender.equals("Select"))
                        Toast.makeText(getApplicationContext(), "Please select your gender...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}