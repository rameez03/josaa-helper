package com.mc.josaahelper;

public class CollegeModel {
    String sNo, instituteCodeAndName;

    public CollegeModel(){}

    public CollegeModel(String sNo, String instituteCodeAndName){
        this.sNo = sNo;
        this.instituteCodeAndName = instituteCodeAndName;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getInstituteCodeAndName() {
        return instituteCodeAndName;
    }

    public void setInstituteCodeAndName(String instituteCodeAndName) {
        this.instituteCodeAndName = instituteCodeAndName;
    }
}
