package com.mc.josaahelper;

public class CategoryRankCalculation {
    private int mObcRank, mScRank, mSTRank, mEwsRank, mOpenRank;
    int calculateObcRank(int openrank){
        mOpenRank = openrank;
        mObcRank = mOpenRank/3;
        return mObcRank;
    }
    int calculateSCRank(int openrank){
        mOpenRank = openrank;
        mScRank = mOpenRank/5;
        return mScRank;
    }

    int calculateStRank(int openrank){
        mOpenRank = openrank;
        mSTRank = mOpenRank/6;
        return mSTRank;
    }
    int calculateEwsRank(int openrank){
        mOpenRank = openrank;
        mEwsRank = mOpenRank/2;
        return mEwsRank;
    }

}
