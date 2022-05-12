package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


public class CollegeInputsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Button nextBtn;
    private EditText ranktext;
    private Spinner spinner;
    private boolean radiobtn = false;
    private String mexam,mcategory,mrank;
    public Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_inputs);

        ranktext = findViewById(R.id.editTextRank);
        nextBtn = findViewById(R.id.firstnextbtn);

        spinner = findViewById(R.id.categoryspinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,R.array.categories,android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

        nextBtn.setOnClickListener(view -> {
            mrank = ranktext.getText().toString();
            if(view.getId()==R.id.firstnextbtn && radiobtn && !ranktext.getText().toString().equals(""))
            {
                Intent intent = new Intent(CollegeInputsActivity.this,CollegeInputSecond.class);
                bundle.putString("Exam",mexam);
                bundle.putString("Rank",ranktext.getText().toString());
                bundle.putString("Category",mcategory);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(CollegeInputsActivity.this, "You have not selected exam type or not entered rank!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onRadioBtnClicked(View v)
    {
        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId())
        {
            case R.id.jeemainsbtn:
                if (checked)
                {
                    radiobtn = true;
                    mexam = "Jee Mains";
                }
                Log.i("Exam Type","Jee Mains");
                break;
            case R.id.jeeadvancedbnt:
                if (checked)
                {
                    mexam = "Jee Advance";
                    radiobtn = true;
                }
                Log.i("Exam Type","Jee Advance");
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String category = adapterView.getItemAtPosition(i).toString();
        mcategory = spinner.getSelectedItem().toString();
        Log.i("Category",mcategory);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}