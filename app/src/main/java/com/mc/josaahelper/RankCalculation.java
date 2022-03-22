package com.mc.josaahelper;
import java.lang.Math;

public class RankCalculation{
    double Rank;
    double lowest_rank = 991222;
    double Marks_constant = 27;
    double Actual_Marks;
    /*
     * Equation use here:
     * Rank = (Rank at 0 mark)* exp(- (markes get by the student)/(Marks constant))
     *
     * */
    public int calculated_Rank(int actual_Marks){
        Actual_Marks = actual_Marks;
        double constant = Actual_Marks / Marks_constant;
        double expo = 2.718281828;
        int newconstant = (int) constant; //Type casting;
        for(int i = 0; i<newconstant - 1; i++){
            expo = 2.718281828 * expo;
        }
        expo = 1/expo;
        Rank =  lowest_rank * expo;
        int value = (int) Rank; //Type casting;
        return value;
    }

}
