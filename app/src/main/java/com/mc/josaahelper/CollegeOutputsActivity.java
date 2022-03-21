package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CollegeOutputsActivity extends AppCompatActivity {
    private TextView rank,branch,gender,exam;
    private RecyclerView recyclerView;
    private ArrayList<CollegeDetails>coDetails = new ArrayList<>();
    private CollegeAdapter collegeAdapter;
    private Bundle bundle;
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
            //CollegeDetails obj = details.get(i);
            Log.i("College Details",details.get(i).getBranch());
            Log.i("Branch", (String) branch.getText());
            //Log.i("")
            if((details.get(i).getBranch()== (String)branch.getText()) && (details.get(i).getExam()==(String)exam.getText()) && (details.get(i).getGender() == (String)gender.getText())
                    && (details.get(i).getCategory() == bundle.getString("Category"))
            && (details.get(i).getQuota() == bundle.getString("Quota")));// && obj.getCloserank()>= Integer.parseInt((String) rank.getText()))
            {
                coDetails.add(details.get(i));
            }
        }
        Log.d("GetData","Get Data");
    }

    public ArrayList<CollegeDetails> counsellingDetails()
    {
        ArrayList<CollegeDetails>collegeDetails = new ArrayList<>();
        CollegeDetails details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Civil Engineering","OPEN",
                "Jee Advance","Neutral",8471,10302,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Civil Engineering","OPEN",
                "Jee Advance","Female",16750,17412,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Civil Engineering","EWS",
                "Jee Advance","Neutral",1420,1603,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Civil Engineering","EWS",
                "Jee Advance","Female",3536,3536,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Civil Engineering","OBC-NCL",
                "Jee Advance","Neutral",3044,3846,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Civil Engineering","OBC-NCL",
                "Jee Advance","Female",6138,7788,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Civil Engineering","SC",
                "Jee Advance","Neutral",1754,2199,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Civil Engineering","SC",
                "Jee Advance","Female",3093,3110,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Civil Engineering","ST",
                "Jee Advance","Neutral",656,698,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Civil Engineering","ST",
                "Jee Advance","Female",909,909,"AI");
        collegeDetails.add(details);
// CSE IIT Bhubaneswar
        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Computer Science and Engineering","OPEN",
                "Jee Advance","Neutral",1621,2176,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Computer Science and Engineering","OPEN",
                "Jee Advance","Female",3221,5005,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Computer Science and Engineering","EWS",
                "Jee Advance","Neutral",257,292,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Computer Science and Engineering","EWS",
                "Jee Advance","Female",685,685,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Computer Science and Engineering","OBC-NCL",
                "Jee Advance","Neutral",443,731,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Computer Science and Engineering","OBC-NCL",
                "Jee Advance","Female",1244,2120,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Computer Science and Engineering","SC",
                "Jee Advance","Neutral",240,415,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Computer Science and Engineering","SC",
                "Jee Advance","Female", 850,910,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Computer Science and Engineering","ST",
                "Jee Advance","Neutral",144,259,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Computer Science and Engineering","ST",
                "Jee Advance","Female",462,462,"AI");
        collegeDetails.add(details);

        // Electronics and Communication IIT Bhubaneshwar

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electronics and Communication Engineering","OPEN",
                "Jee Advance","Neutral",2918,3917,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electronics and Communication Engineering","OPEN",
                "Jee Advance","Female",6811,7917,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electronics and Communication Engineering","EWS",
                "Jee Advance","Neutral",471,499,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electronics and Communication Engineering","EWS",
                "Jee Advance","Female",1101,1101,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electronics and Communication Engineering","OBC-NCL",
                "Jee Advance","Neutral",1085,1458,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electronics and Communication Engineering","OBC-NCL",
                "Jee Advance","Female",3079,3173,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electronics and Communication Engineering","SC",
                "Jee Advance","Neutral",762,1021,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electronics and Communication Engineering","SC",
                "Jee Advance","Female",1499,1640,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electronics and Communication Engineering","ST",
                "Jee Advance","Neutral",335,476,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electronics and Communication Engineering","ST",
                "Jee Advance","Female",680,680,"AI");
        collegeDetails.add(details);
// Electrical Engineering IIT Bhubaneswar
        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electrical Engineering","OPEN",
                "Jee Advance","Neutral",4438,5230,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electrical Engineering","OPEN",
                "Jee Advance","Female",8253,10520,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electrical Engineering","EWS",
                "Jee Advance","Neutral",587,851,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electrical Engineering","EWS",
                "Jee Advance","Female",1648,1648,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electrical Engineering","OBC-NCL",
                "Jee Advance","Neutral",1721,2146,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electrical Engineering","OBC-NCL",
                "Jee Advance","Female",4845,5064,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electrical Engineering","SC",
                "Jee Advance","Neutral",1061,1375,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electrical Engineering","SC",
                "Jee Advance","Female", 1348,1833,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electrical Engineering","ST",
                "Jee Advance","Neutral",539,655,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bhubaneswar","Electrical Engineering","ST",
                "Jee Advance","Female",999,999,"AI");
        collegeDetails.add(details);

        // IIT Bombay

        details = new CollegeDetails("Indian Institute of Technology Bombay","Civil Engineering","OPEN",
                "Jee Advance","Neutral",2017,3216,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Civil Engineering","OPEN",
                "Jee Advance","Female",5341,7597,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Civil Engineering","EWS",
                "Jee Advance","Neutral",359,652,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Civil Engineering","EWS",
                "Jee Advance","Female",1451,1775,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Civil Engineering","OBC-NCL",
                "Jee Advance","Neutral",759,1623,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Civil Engineering","OBC-NCL",
                "Jee Advance","Female",2814,3910,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Civil Engineering","SC",
                "Jee Advance","Neutral",272,875,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Civil Engineering","SC",
                "Jee Advance","Female",975,1547,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Civil Engineering","ST",
                "Jee Advance","Neutral",40,149,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Civil Engineering","ST",
                "Jee Advance","Female",142,617,"AI");
        collegeDetails.add(details);
// CSE IIT IIT Bombay
        details = new CollegeDetails("Indian Institute of Technology Bombay","Computer Science and Engineering","OPEN",
                "Jee Advance","Neutral",1,66,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Computer Science and Engineering","OPEN",
                "Jee Advance","Female",107,361,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Computer Science and Engineering","EWS",
                "Jee Advance","Neutral",4,19,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Computer Science and Engineering","EWS",
                "Jee Advance","Female",52,62,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Computer Science and Engineering","OBC-NCL",
                "Jee Advance","Neutral",5,50,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Computer Science and Engineering","OBC-NCL",
                "Jee Advance","Female",56,166,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Computer Science and Engineering","SC",
                "Jee Advance","Neutral",1,25,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Computer Science and Engineering","SC",
                "Jee Advance","Female", 27,107,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Computer Science and Engineering","ST",
                "Jee Advance","Neutral",1,11,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Computer Science and Engineering","ST",
                "Jee Advance","Female",27,87,"AI");
        collegeDetails.add(details);

//        // Electronics and Communication IIT Bombay
//
//        details = new CollegeDetails("Indian Institute of Technology Bombay","Electronics and Communication Engineering","OPEN",
//                "Jee Advance","Neutral",2918,3917);
//        collegeDetails.add(details);
//
//        details = new CollegeDetails("Indian Institute of Technology Bombay","Electronics and Communication Engineering","OPEN",
//                "Jee Advance","Female",6811,7917);
//        collegeDetails.add(details);
//
//        details = new CollegeDetails("Indian Institute of Technology Bombay","Electronics and Communication Engineering","EWS",
//                "Jee Advance","Neutral",471,499);
//        collegeDetails.add(details);
//
//        details = new CollegeDetails("Indian Institute of Technology Bombay","Electronics and Communication Engineering","EWS",
//                "Jee Advance","Female",1101,1101);
//        collegeDetails.add(details);
//
//        details = new CollegeDetails("Indian Institute of Technology Bombay","Electronics and Communication Engineering","OBC-NCL",
//                "Jee Advance","Neutral",1085,1458);
//        collegeDetails.add(details);
//
//        details = new CollegeDetails("Indian Institute of Technology Bombay","Electronics and Communication Engineering","OBC-NCL",
//                "Jee Advance","Female",3079,3173);
//        collegeDetails.add(details);
//
//        details = new CollegeDetails("Indian Institute of Technology Bombay","Electronics and Communication Engineering","SC",
//                "Jee Advance","Neutral",762,1021);
//        collegeDetails.add(details);
//
//        details = new CollegeDetails("Indian Institute of Technology Bombay","Electronics and Communication Engineering","SC",
//                "Jee Advance","Female",1499,1640);
//        collegeDetails.add(details);
//
//        details = new CollegeDetails("Indian Institute of Technology Bombay","Electronics and Communication Engineering","ST",
//                "Jee Advance","Neutral",335,476);
//        collegeDetails.add(details);
//
//        details = new CollegeDetails("Indian Institute of Technology Bombay","Electronics and Communication Engineering","ST",
//                "Jee Advance","Female",680,680);
//        collegeDetails.add(details);
// Electrical Engineering IIT Bombay
        // Electrical Engineering IIT Bombay
        details = new CollegeDetails("Indian Institute of Technology Bombay","Electrical Engineering","OPEN",
                "Jee Advance","Neutral",95,420,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Electrical Engineering","OPEN",
                "Jee Advance","Female",454,916,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Electrical Engineering","EWS",
                "Jee Advance","Neutral",39,117,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Electrical Engineering","EWS",
                "Jee Advance","Female",208,217,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Electrical Engineering","OBC-NCL",
                "Jee Advance","Neutral",105,268,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Electrical Engineering","OBC-NCL",
                "Jee Advance","Female",368,706,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Electrical Engineering","SC",
                "Jee Advance","Neutral",51,128,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Electrical Engineering","SC",
                "Jee Advance","Female", 332,642,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Electrical Engineering","ST",
                "Jee Advance","Neutral",23,80,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Bombay","Electrical Engineering","ST",
                "Jee Advance","Female",21,21,"AI");
        collegeDetails.add(details);

        // IIT Delhi

        details = new CollegeDetails("Indian Institute of Technology Delhi","Civil Engineering","OPEN",
                "Jee Advance","Neutral",523,3607,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Civil Engineering","OPEN",
                "Jee Advance","Female",6382,8280,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Civil Engineering","EWS",
                "Jee Advance","Neutral",433,668,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Civil Engineering","EWS",
                "Jee Advance","Female",1337,1543,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Civil Engineering","OBC-NCL",
                "Jee Advance","Neutral",836,1620,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Civil Engineering","OBC-NCL",
                "Jee Advance","Female",2332,4418,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Civil Engineering","SC",
                "Jee Advance","Neutral",211,727,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Civil Engineering","SC",
                "Jee Advance","Female",1564,1570,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Civil Engineering","ST",
                "Jee Advance","Neutral",32,130,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Civil Engineering","ST",
                "Jee Advance","Female",157,209,"AI");
        collegeDetails.add(details);
// CSE IIT Delhi
        details = new CollegeDetails("Indian Institute of Technology Delhi","Computer Science and Engineering","OPEN",
                "Jee Advance","Neutral",3,99,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Computer Science and Engineering","OPEN",
                "Jee Advance","Female",98,432,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Computer Science and Engineering","EWS",
                "Jee Advance","Neutral",7,30,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Computer Science and Engineering","EWS",
                "Jee Advance","Female",96,105,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Computer Science and Engineering","OBC-NCL",
                "Jee Advance","Neutral",30,83,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Computer Science and Engineering","OBC-NCL",
                "Jee Advance","Female",275,340,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Computer Science and Engineering","SC",
                "Jee Advance","Neutral",3,33,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Computer Science and Engineering","SC",
                "Jee Advance","Female", 154,185,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Computer Science and Engineering","ST",
                "Jee Advance","Neutral",9,17,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Computer Science and Engineering","ST",
                "Jee Advance","Female",30,53,"AI");
        collegeDetails.add(details);

// Electrical Engineering IIT Delhi
        details = new CollegeDetails("Indian Institute of Technology Delhi","Electrical Engineering","OPEN",
                "Jee Advance","Neutral",364,543,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Electrical Engineering","OPEN",
                "Jee Advance","Female",996,1586,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Electrical Engineering","EWS",
                "Jee Advance","Neutral",119,148,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Electrical Engineering","EWS",
                "Jee Advance","Female",442,450,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Electrical Engineering","OBC-NCL",
                "Jee Advance","Neutral",136,355,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Electrical Engineering","OBC-NCL",
                "Jee Advance","Female",694,1190,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Electrical Engineering","SC",
                "Jee Advance","Neutral",42,162,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Electrical Engineering","SC",
                "Jee Advance","Female", 112,712,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Electrical Engineering","ST",
                "Jee Advance","Neutral",12,112,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Delhi","Electrical Engineering","ST",
                "Jee Advance","Female",123,155,"AI");
        collegeDetails.add(details);

        // IIT Kanpur
       details =  new CollegeDetails("Indian Institute of Technology Kanpur","Civil Engineering","OPEN",
                "Jee Advance","Neutral",3684,5093,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Civil Engineering","OPEN",
                "Jee Advance","Female",9665,11657,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Civil Engineering","EWS",
                "Jee Advance","Neutral",691,806,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Civil Engineering","EWS",
                "Jee Advance","Female",1821,2406,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Civil Engineering","OBC-NCL",
                "Jee Advance","Neutral",1655,2265,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Civil Engineering","OBC-NCL",
                "Jee Advance","Female",5099,5613,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Civil Engineering","SC",
                "Jee Advance","Neutral",235,1211,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Civil Engineering","SC",
                "Jee Advance","Female",1747,2470,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Civil Engineering","ST",
                "Jee Advance","Neutral",199,428,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Civil Engineering","ST",
                "Jee Advance","Female",805,839,"AI");
        collegeDetails.add(details);
// CSE IIT Kanpur
        details = new CollegeDetails("Indian Institute of Technology Kanpur","Computer Science and Engineering","OPEN",
                "Jee Advance","Neutral",100,213,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Computer Science and Engineering","OPEN",
                "Jee Advance","Female",487,777,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Computer Science and Engineering","EWS",
                "Jee Advance","Neutral",32,48,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Computer Science and Engineering","EWS",
                "Jee Advance","Female",112,185,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Computer Science and Engineering","OBC-NCL",
                "Jee Advance","Neutral",90,141,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Computer Science and Engineering","OBC-NCL",
                "Jee Advance","Female",364,479,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Computer Science and Engineering","SC",
                "Jee Advance","Neutral",38,85,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Computer Science and Engineering","SC",
                "Jee Advance","Female", 284,350,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Computer Science and Engineering","ST",
                "Jee Advance","Neutral",20,47,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Computer Science and Engineering","ST",
                "Jee Advance","Female",189,236,"AI");
        collegeDetails.add(details);

// Electrical Engineering IIT Kanpur
        details = new CollegeDetails("Indian Institute of Technology Kanpur","Electrical Engineering","OPEN",
                "Jee Advance","Neutral",685,1256,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Electrical Engineering","OPEN",
                "Jee Advance","Female",1985,3409,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Electrical Engineering","EWS",
                "Jee Advance","Neutral",106,233,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Electrical Engineering","EWS",
                "Jee Advance","Female",561,761,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Electrical Engineering","OBC-NCL",
                "Jee Advance","Neutral",360,659,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Electrical Engineering","OBC-NCL",
                "Jee Advance","Female",1758,2374,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Electrical Engineering","SC",
                "Jee Advance","Neutral",164,442,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Electrical Engineering","SC",
                "Jee Advance","Female", 918,1265,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Electrical Engineering","ST",
                "Jee Advance","Neutral",103,262,"AI");
        collegeDetails.add(details);

        details = new CollegeDetails("Indian Institute of Technology Kanpur","Electrical Engineering","ST",
                "Jee Advance","Female",203,475,"AI");
        collegeDetails.add(details);

    // NITs and Jee Mains

        // NIT Tiruchinapalli
        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","OPEN",
                "Jee Mains","Neutral",15979,27144,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","OPEN",
                "Jee Mains","Female",25852,30136,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","EWS",
                "Jee Mains","Neutral",18899,38919,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","EWS",
                "Jee Mains","Female",6892,6892,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","OBC-NCL",
                "Jee Mains","Neutral",6388,8618,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","OBC-NCL",
                "Jee Mains","Female",8267,10303,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","SC",
                "Jee Mains","Neutral",3961,5978,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","SC",
                "Jee Mains","Female", 4904,5696,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","ST",
                "Jee Mains","Neutral",5929,7407,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","ST",
                "Jee Mains","Female",5193,5193,"HS");
        collegeDetails.add(details);
// Other State
        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","OPEN",
                "Jee Mains","Neutral",386,13212,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","OPEN",
                "Jee Mains","Female",16015,19201,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","EWS",
                "Jee Mains","Neutral",1833,2305,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","EWS",
                "Jee Mains","Female",4163,4163,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","OBC-NCL",
                "Jee Mains","Neutral",3282,4739,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","OBC-NCL",
                "Jee Mains","Female",5960,8990,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","SC",
                "Jee Mains","Neutral",1294,2230,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","SC",
                "Jee Mains","Female", 3062,3629,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","ST",
                "Jee Mains","Neutral",280,478,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Civil Engineering","ST",
                "Jee Mains","Female",658,658,"OS");
        collegeDetails.add(details);

        // CSE NIT Tiruchinapalli
        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","OPEN",
                "Jee Mains","Neutral",2243,5432,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","OPEN",
                "Jee Mains","Female",4133,37464,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","EWS",
                "Jee Mains","Neutral",1532,3305,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","EWS",
                "Jee Mains","Female",2250,2250,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","OBC-NCL",
                "Jee Mains","Neutral",967,1510,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","OBC-NCL",
                "Jee Mains","Female",1579,2598,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","SC",
                "Jee Mains","Neutral",384,1171,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","SC",
                "Jee Mains","Female", 531,790,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","ST",
                "Jee Mains","Neutral",508,2028,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","ST",
                "Jee Mains","Female",277,277,"HS");
        collegeDetails.add(details);
// Other State
        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","OPEN",
                "Jee Mains","Neutral",1,386,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","OPEN",
                "Jee Mains","Female",138,342,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","EWS",
                "Jee Mains","Neutral",37,100,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","EWS",
                "Jee Mains","Female",221,221,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","OBC-NCL",
                "Jee Mains","Neutral",94,204,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","OBC-NCL",
                "Jee Mains","Female",174,332,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","SC",
                "Jee Mains","Neutral",8,142,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","SC",
                "Jee Mains","Female", 85,168,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","ST",
                "Jee Mains","Neutral",38,47,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Tiruchirappalli","Computer Science and Engineering","ST",
                "Jee Mains","Female",59,59,"OS");
        collegeDetails.add(details);

        // NIT Warangal

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","OPEN",
                "Jee Mains","Neutral",17196,25457,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","OPEN",
                "Jee Mains","Female",29569,32251,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","EWS",
                "Jee Mains","Neutral",3745,3883,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","EWS",
                "Jee Mains","Female",5069,5069,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","OBC-NCL",
                "Jee Mains","Neutral",6666,7789,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","OBC-NCL",
                "Jee Mains","Female",8352,9435,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","SC",
                "Jee Mains","Neutral",2348,3790,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","SC",
                "Jee Mains","Female", 3640,3908,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","ST",
                "Jee Mains","Neutral",515,698,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","ST",
                "Jee Mains","Female",558,558,"HS");
        collegeDetails.add(details);
// Other State
        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","OPEN",
                "Jee Mains","Neutral",11597,17370,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","OPEN",
                "Jee Mains","Female",20991,27465,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","EWS",
                "Jee Mains","Neutral",2480,2816,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","EWS",
                "Jee Mains","Female",4947,4947,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","OBC-NCL",
                "Jee Mains","Neutral",4371,6009,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","OBC-NCL",
                "Jee Mains","Female",8688,9245,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","SC",
                "Jee Mains","Neutral",2134,2904,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","SC",
                "Jee Mains","Female", 3660,3897,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","ST",
                "Jee Mains","Neutral",496,798,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Civil Engineering","ST",
                "Jee Mains","Female",1010,1010,"OS");
        collegeDetails.add(details);

        // CSE NIT Warangal
        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","OPEN",
                "Jee Mains","Neutral",703,2622,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","OPEN",
                "Jee Mains","Female",980,3149,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","EWS",
                "Jee Mains","Neutral",265,535,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","EWS",
                "Jee Mains","Female",403,403,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","OBC-NCL",
                "Jee Mains","Neutral",469,987,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","OBC-NCL",
                "Jee Mains","Female",550,770,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","SC",
                "Jee Mains","Neutral",245,436,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","SC",
                "Jee Mains","Female", 636,972,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","ST",
                "Jee Mains","Neutral",27,94,"HS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","ST",
                "Jee Mains","Female",205,205,"HS");
        collegeDetails.add(details);
// Other State
        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","OPEN",
                "Jee Mains","Neutral",453,1082,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","OPEN",
                "Jee Mains","Female",719,1751,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","EWS",
                "Jee Mains","Neutral",138,164,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","EWS",
                "Jee Mains","Female",306,306,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","OBC-NCL",
                "Jee Mains","Neutral",189,394,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","OBC-NCL",
                "Jee Mains","Female",759,950,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","SC",
                "Jee Mains","Neutral",23,367,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","SC",
                "Jee Mains","Female", 588,673,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","ST",
                "Jee Mains","Neutral",88,119,"OS");
        collegeDetails.add(details);

        details = new CollegeDetails("National Institute of Technology, Warangal","Computer Science and Engineering","ST",
                "Jee Mains","Female",292,292,"OS");
        collegeDetails.add(details);

        return collegeDetails;
    }
}