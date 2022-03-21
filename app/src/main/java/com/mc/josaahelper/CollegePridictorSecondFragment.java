package com.mc.josaahelper;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class CollegePridictorSecondFragment extends Fragment{// implements AdapterView.OnItemSelectedListener{
    private Spinner branch,quota,gender;
    private Button proceedbtn;
    private String mquota,mbranch,mgender;
    private Bundle bundle = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_college_pridictor_second, container, false);

        proceedbtn = (Button)view.findViewById(R.id.fragmentsecondnextbtn);
        branch = (Spinner) view.findViewById(R.id.branchSpinner);
        quota = (Spinner) view.findViewById(R.id.quotaSpinner);
        gender = (Spinner) view.findViewById(R.id.genderSpinner);

        // Adapter for branch
        ArrayAdapter<CharSequence> branchAdapter = ArrayAdapter.createFromResource(getContext(),R.array.branch,android.R.layout.simple_spinner_item);
        branchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch.setAdapter(branchAdapter);
        branch.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getContext());

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
        ArrayAdapter<CharSequence> quotaAdapter = ArrayAdapter.createFromResource(getContext(),R.array.quota,android.R.layout.simple_spinner_item);
        quotaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quota.setAdapter(quotaAdapter);
        quota.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getContext());
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
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(getContext(),R.array.Gender,android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genderAdapter);
        gender.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getContext());

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
//        branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                selectedgender = adapterView.getItemAtPosition(i).toString();
//                Log.i("Branch", selectedgender);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        proceedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mbranch!="Select" && mgender != "Select") {
                    try {
                        Intent intent = new Intent(getActivity(), CollegeOutputsActivity.class);
                        //Log.i("Branch", mbranch);
                        bundle.putString("Branch", mbranch);
                        bundle.putString("Quota", mquota);
                        bundle.putString("Gender", mgender);
                        bundle.putString("Exam", getArguments().getString("Exam"));
                        bundle.putString("Rank", getArguments().getString("Rank"));
                        bundle.putString("Category", getArguments().getString("Category"));
                        intent.putExtras(bundle);
                        startActivity(intent);
                    } catch (NullPointerException e) {
                        Log.d("Catch", "Null Pointer Exception");
                        e.printStackTrace();
                    }
                }
                else
                {
                    if(mbranch == "Select")
                        Toast.makeText(getContext(), "Please select your branch...", Toast.LENGTH_SHORT).show();
                    if(mgender=="Select")
                        Toast.makeText(getContext(), "Please select your gender...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        int v = view.getId();
//        //String branch,quota,gender;
//        if(v==R.id.branchSpinner) {
//            //mbranch = adapterView.getItemAtPosition(i).toString();
//            mbranch = branch.getSelectedItem().toString();
//            Log.i("Branch", mbranch);
//        }
//        if(v == R.id.quotaSpinner)
//        {
//            //mquota = adapterView.getItemAtPosition(i).toString();
//            mquota = quota.getSelectedItem().toString();
//            Log.i("Quota",mquota);
//        }
//        if(v == R.id.genderSpinner)
//        {
//            //mgender = adapterView.getItemAtPosition(i).toString();
//            mgender = gender.getSelectedItem().toString();
//            Log.i("Gender",mgender);
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
}