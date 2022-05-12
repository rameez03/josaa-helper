package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RankOutputsActivity extends AppCompatActivity {
    private String mExamType, mCategory;
    private int mMarks, mintcategory;
    private TextView mExamTV, mCategoryTV, mMarksTV, mOpenMarksTV, mCategoryMarksTV;
    private int mObcRank, mScRank, mSTRank, mEwsRank;
    Button sharebtn;
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
        mCategoryMarksTV = findViewById(R.id.textView18);
        sharebtn=findViewById(R.id.sharebtn);

        mExamTV.setText(mExamType);
        mCategoryTV.setText(mCategory);
        mMarksTV.setText(String.valueOf(mMarks));
        /*
         * Here in the below code we are calling the RankCalculation class.
         * In the RankCalculation class we have use the formula Rank = Ae^-x to calculate the Rank.
         * In the RankCalculation we are calling the calculated_Rank() method where we have done all the calculation.
         * For More information you can visite the RankCalculation class.
         * Here we are calculating the open category Rank.
         *
         * */
        RankCalculation myrank = new RankCalculation();
        int MYRANK = myrank.calculated_Rank(mMarks);
        mOpenMarksTV = findViewById(R.id.textView17);
        mOpenMarksTV.setText(String.valueOf(MYRANK));
        if(mCategory.equals("OPEN")){
            mCategoryMarksTV.setText("-");
        }
        CategoryRankCalculation rankCalculation = new CategoryRankCalculation();
        if(mCategory.equals("OBC-NCL")){
            mObcRank = rankCalculation.calculateObcRank(MYRANK);
            mCategoryMarksTV.setText(String.valueOf(mObcRank));
        }
        else if(mCategory.equals("SC")){

            mScRank = rankCalculation.calculateSCRank(MYRANK);
            mCategoryMarksTV.setText(String.valueOf(mScRank));

        }
        else if(mCategory.equals("ST")){

            mSTRank = rankCalculation.calculateStRank(MYRANK);
            mCategoryMarksTV.setText(String.valueOf(mSTRank));

        }
        else if(mCategory.equals("EWS")){

            mEwsRank = rankCalculation.calculateEwsRank(MYRANK);
            mCategoryMarksTV.setText(String.valueOf(mEwsRank));

        }
        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message="COfC RANK PREDICTOR : \nHere are your predictions:\n    Exam type : "+mExamType+
                        "\n    Category : "+ mCategory + "\n   Expected Marks : " + mMarks+"\n    Your expected Rank : " + MYRANK;
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,message);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Share to"));

            }
        });
    }





}