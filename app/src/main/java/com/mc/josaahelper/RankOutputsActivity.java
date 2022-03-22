package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RankOutputsActivity extends AppCompatActivity {
    private String mExamType, mCategory;
    private int mMarks, mintcategory;
    private TextView mExamTV, mCategoryTV, mMarksTV, mOpenMarksTV, mObcMarksTV, mSCMarksTV, mSTMarksTV, mEWSMarksTV;
    private int mObcRank, mScRank, mSTRank, mEwsRank;
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
        CategoryRankCalculation rankCalculation = new CategoryRankCalculation();
        if(mCategory.equals("OBC-NCL")){
            mObcRank = rankCalculation.calculateObcRank(MYRANK);
            mObcMarksTV = findViewById(R.id.textView18);
            mObcMarksTV.setText(String.valueOf(mObcRank));
        }
        else if(mCategory.equals("SC")){

            mScRank = rankCalculation.calculateSCRank(MYRANK);
            mSCMarksTV = findViewById(R.id.textView18);
            mSCMarksTV.setText(String.valueOf(mScRank));

        }
        else if(mCategory.equals("ST")){

            mSTRank = rankCalculation.calculateStRank(MYRANK);
            mSTMarksTV = findViewById(R.id.textView18);
            mSTMarksTV.setText(String.valueOf(mSTRank));

        }
        else if(mCategory.equals("EWS")){

            mEwsRank = rankCalculation.calculateEwsRank(MYRANK);
            mEWSMarksTV = findViewById(R.id.textView18);
            mEWSMarksTV.setText(String.valueOf(mEwsRank));

        }
    }


}