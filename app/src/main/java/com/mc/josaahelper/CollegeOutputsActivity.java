package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollegeOutputsActivity extends AppCompatActivity {
    private TextView rank,branch,gender,exam;
    private RecyclerView recyclerView;
    private ArrayList<CollegeDetails>coDetails = new ArrayList<>();
    private CollegeAdapter collegeAdapter;
    private Bundle bundle;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_outputs);

        rank = findViewById(R.id.enteredRank1);
        branch = findViewById(R.id.selectedBranch1);
        gender = findViewById(R.id.selectedGender1);
        exam = findViewById(R.id.selectedExam1);

        bundle = getIntent().getExtras();
        //Bundle bundle = getIntent().getExtras();
        rank.setText(bundle.getString("Rank"));
        branch.setText(bundle.getString("Branch"));
        gender.setText(bundle.getString("Gender"));
        exam.setText(bundle.getString("Exam"));

        Log.d("OnCreate","On Create");
        recyclerView = findViewById(R.id.collegeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        getData();
        collegeAdapter = new CollegeAdapter(coDetails);
        recyclerView.setAdapter(collegeAdapter);
    }

    public void getData()
    {
        //CollegeDetails details;// = new CollegeDetails();
        /*int openrank = 0;
        int closerank = 100;
        String college = "A";
        String branch = "CSE";

        for(int i=0;i<20;i++)
        {
            CollegeDetails details = new CollegeDetails();
            details.setBranch(branch);
            details.setCollegename(college);
            college = "A"+Integer.toString(i);
            details.setCloserank(closerank);
            closerank += 10;
            details.setOpenrank(openrank);
            openrank += closerank + 1;
            coDetails.add(details);
        }*/

        ArrayList<CollegeDetails>details = counsellingDetails();
        //coDetails = counsellingDetails();
        Log.i("Details Size",Integer.toString(details.size()));
        Log.i("Category",bundle.getString("Category"));
        Log.i("Quota",bundle.getString("Quota"));
        for(int i=0;i<details.size();i++)
        {
            if((details.get(i).getBranch().equals((String)branch.getText())) && (details.get(i).getExam().equals((String)exam.getText())) && (details.get(i).getGender().equals((String)gender.getText()))
                    && (details.get(i).getCategory().equals(bundle.getString("Category")))
                    && (details.get(i).getQuota().equals(bundle.getString("Quota"))) && details.get(i).getCloserank()>= Integer.parseInt((String) rank.getText()))
            {
                coDetails.add(details.get(i));
            }
        }
        Collections.sort(coDetails, new Comparator<CollegeDetails>() {
            @Override
            public int compare(CollegeDetails a, CollegeDetails b) {
                if (a.getCloserank()<= b.getCloserank()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        Log.d("GetData","Get Data");
    }

    public ArrayList<CollegeDetails> counsellingDetails()
    {
        ArrayList<CollegeDetails>collegeDetails = new ArrayList<>();
        CollegeDetails details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),8471,10302,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),16750,17412,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),1420,1603,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),3536,3536,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),3044,3846,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),6138,7788,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),1754,2199,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female),3093,3110,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),656,698,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),909,909,getString(R.string.ai));
        collegeDetails.add(details);
// CSE IIT Bhubaneswar
        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),1621,2176,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),3221,5005,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),257,292,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),685,685,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),443,731,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),1244,2120,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),240,415,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female), 850,910,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),144,259,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),462,462,getString(R.string.ai));
        collegeDetails.add(details);

        // Electronics and Communication IIT Bhubaneshwar

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ece),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),2918,3917,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ece),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),6811,7917,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ece),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),471,499,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ece),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),1101,1101,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ece),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),1085,1458,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ece),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),3079,3173,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ece),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),762,1021,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ece),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female),1499,1640,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ece),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),335,476,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ece),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),680,680,getString(R.string.ai));
        collegeDetails.add(details);
// Electrical Engineering IIT Bhubaneswar
        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ee),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),4438,5230,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ee),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),8253,10520,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ee),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),587,851,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ee),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),1648,1648,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ee),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),1721,2146,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ee),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),4845,5064,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ee),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),1061,1375,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ee),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female), 1348,1833,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ee),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),539,655,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar",getString(R.string.ee),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),999,999,getString(R.string.ai));
        collegeDetails.add(details);

        // IIT Bombay

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),2017,3216,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),5341,7597,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),359,652,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),1451,1775,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),759,1623,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),2814,3910,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),272,875,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female),975,1547,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),40,149,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),142,617,getString(R.string.ai));
        collegeDetails.add(details);
// CSE IIT IIT Bombay
        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),1,66,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),107,361,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),4,19,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),52,62,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),5,50,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),56,166,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),1,25,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female), 27,107,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),1,11,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),27,87,getString(R.string.ai));
        collegeDetails.add(details);

        // Electrical Engineering IIT Bombay
        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ee),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),95,420,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ee),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),454,916,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ee),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),39,117,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ee),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),208,217,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ee),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),105,268,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ee),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),368,706,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ee),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),51,128,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ee),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female), 332,642,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ee),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),23,80,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay",getString(R.string.ee),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),21,21,getString(R.string.ai));
        collegeDetails.add(details);

        // IIT Delhi

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),523,3607,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),6382,8280,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),433,668,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),1337,1543,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),836,1620,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),2332,4418,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),211,727,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female),1564,1570,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),32,130,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),157,209,getString(R.string.ai));
        collegeDetails.add(details);
// CSE IIT Delhi
        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),3,99,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),98,432,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),7,30,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),96,105,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),30,83,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),275,340,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),3,33,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female), 154,185,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),9,17,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),30,53,getString(R.string.ai));
        collegeDetails.add(details);

// Electrical Engineering IIT Delhi
        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ee),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),364,543,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ee),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),996,1586,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ee),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),119,148,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ee),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),442,450,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ee),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),136,355,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ee),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),694,1190,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ee),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),42,162,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ee),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female), 112,712,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ee),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),12,112,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi",getString(R.string.ee),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),123,155,getString(R.string.ai));
        collegeDetails.add(details);

        // IIT Kanpur
        details =  new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),3684,5093,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),9665,11657,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),691,806,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),1821,2406,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),1655,2265,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),5099,5613,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),235,1211,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female),1747,2470,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),199,428,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),805,839,getString(R.string.ai));
        collegeDetails.add(details);
// CSE IIT Kanpur
        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),100,213,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),487,777,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),32,48,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),112,185,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),90,141,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),364,479,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),38,85,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female), 284,350,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),20,47,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),189,236,getString(R.string.ai));
        collegeDetails.add(details);

// Electrical Engineering IIT Kanpur
        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ee),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.neutral),685,1256,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ee),getString(R.string.open),
                getString(R.string.jeeadvance),getString(R.string.female),1985,3409,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ee),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.neutral),106,233,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ee),getString(R.string.ews),
                getString(R.string.jeeadvance),getString(R.string.female),561,761,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ee),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.neutral),360,659,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ee),getString(R.string.obcncl),
                getString(R.string.jeeadvance),getString(R.string.female),1758,2374,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ee),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.neutral),164,442,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ee),getString(R.string.sc),
                getString(R.string.jeeadvance),getString(R.string.female), 918,1265,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ee),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.neutral),103,262,getString(R.string.ai));
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur",getString(R.string.ee),getString(R.string.st),
                getString(R.string.jeeadvance),getString(R.string.female),203,475,getString(R.string.ai));
        collegeDetails.add(details);

        // NITs and Jee Mains

        // NIT Tiruchinapalli
        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.neutral),15979,27144,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.female),25852,30136,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.neutral),18899,38919,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.female),6892,6892,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.neutral),6388,8618,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.female),8267,10303,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.neutral),3961,5978,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.female), 4904,5696,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.neutral),5929,7407,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.female),5193,5193,getString(R.string.hs));
        collegeDetails.add(details);
// Other State
        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.neutral),386,13212,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.female),16015,19201,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.neutral),1833,2305,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.female),4163,4163,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.neutral),3282,4739,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.female),5960,8990,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.neutral),1294,2230,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.female), 3062,3629,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.neutral),280,478,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.female),658,658,getString(R.string.os));
        collegeDetails.add(details);

        // CSE NIT Tiruchinapalli
        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.neutral),2243,5432,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.female),4133,37464,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.neutral),1532,3305,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.female),2250,2250,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.neutral),967,1510,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.female),1579,2598,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.neutral),384,1171,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.female), 531,790,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.neutral),508,2028,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.female),277,277,getString(R.string.hs));
        collegeDetails.add(details);
// Other State
        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.neutral),1,386,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.female),138,342,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.neutral),37,100,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.female),221,221,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.neutral),94,204,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.female),174,332,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.neutral),8,142,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.female), 85,168,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.neutral),38,47,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.female),59,59,getString(R.string.os));
        collegeDetails.add(details);

        // NIT Warangal

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.neutral),17196,25457,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.female),29569,32251,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.neutral),3745,3883,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.female),5069,5069,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.neutral),6666,7789,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.female),8352,9435,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.neutral),2348,3790,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.female), 3640,3908,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.neutral),515,698,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.female),558,558,getString(R.string.hs));
        collegeDetails.add(details);
// Other State
        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.neutral),11597,17370,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.female),20991,27465,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.neutral),2480,2816,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.female),4947,4947,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.neutral),4371,6009,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.female),8688,9245,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.neutral),2134,2904,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.female), 3660,3897,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.neutral),496,798,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.ce),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.female),1010,1010,getString(R.string.os));
        collegeDetails.add(details);

        // CSE NIT Warangal
        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.neutral),703,2622,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.female),980,3149,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.neutral),265,535,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.female),403,403,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.neutral),469,987,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.female),550,770,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.neutral),245,436,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.female), 636,972,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.neutral),27,94,getString(R.string.hs));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.female),205,205,getString(R.string.hs));
        collegeDetails.add(details);
// Other State
        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.neutral),453,1082,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.open),
                getString(R.string.jeemains),getString(R.string.female),719,1751,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.neutral),138,164,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.ews),
                getString(R.string.jeemains),getString(R.string.female),306,306,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.neutral),189,394,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.obcncl),
                getString(R.string.jeemains),getString(R.string.female),759,950,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.neutral),23,367,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.sc),
                getString(R.string.jeemains),getString(R.string.female), 588,673,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.neutral),88,119,getString(R.string.os));
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal",getString(R.string.cse),getString(R.string.st),
                getString(R.string.jeemains),getString(R.string.female),292,292,getString(R.string.os));
        collegeDetails.add(details);

        return collegeDetails;
    }
}