package com.mc.josaahelper;

public class CollegeDetails {
    private String collegename;
    private String branch;
    private String category;
    private String exam;
    private String gender,quota;
    private int openrank,closerank;

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public CollegeDetails() {

    }

    public CollegeDetails(String collegename,String branch,String category,String exam,String gender,int openrank,int closerank,String quota) {
        this.collegename = collegename;
        this.branch = branch;
        this.category = category;
        this.exam = exam;
        this.openrank=openrank;
        this.closerank = closerank;
        this.gender = gender;
        this.quota = quota;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getOpenrank() {
        return openrank;
    }

    public void setOpenrank(int openrank) {
        this.openrank = openrank;
    }

    public int getCloserank() {
        return closerank;
    }

    public void setCloserank(int closerank) {
        this.closerank = closerank;
    }
}
