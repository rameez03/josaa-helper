package com.mc.josaahelper;

public class CollegeModel {
    String InstituteID, InstituteName;

    public CollegeModel(){}

    public CollegeModel(String InstituteID, String InstituteName){
        this.InstituteID = InstituteID;
        this.InstituteName = InstituteName;
    }

    public String getInstituteID() {
        return InstituteID;
    }

    public void setInstituteID(String instituteID) {
        InstituteID = instituteID;
    }

    public String getInstituteName() {
        return InstituteName;
    }

    public void setInstituteName(String instituteName) {
        InstituteName = instituteName;
    }
}
