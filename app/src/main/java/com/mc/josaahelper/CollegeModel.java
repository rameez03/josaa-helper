package com.mc.josaahelper;

public class CollegeModel {
    String id;
    String address;
    String contactinfo;
    String emailid;
    String instituteCodeName;
    String phoneFax;
    String Sno;
    String viewDetails;

    public CollegeModel(String Sno){
//        this.id=id;
        this.Sno=Sno;
    }
    public CollegeModel(String id,String address,String contactinfo,
                 String emailid,
                 String instituteCodeName,
                 String phoneFax,
                 String Sno,
                 String viewDetails){
        this.id=id;
        this.address=address;
        this.contactinfo=contactinfo;
        this.emailid=emailid;
        this.instituteCodeName=instituteCodeName;
        this.Sno=Sno;
        this.phoneFax=phoneFax;
        this.viewDetails=viewDetails;
    }
    public CollegeModel(String address,String contactinfo,
                 String emailid,
                 String instituteCodeName,
                 String phoneFax,
                 String Sno
    ){
        this.address=address;
        this.contactinfo=contactinfo;
        this.emailid=emailid;
        this.instituteCodeName=instituteCodeName;
        this.Sno=Sno;
        this.phoneFax=phoneFax;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getInstituteCodeName() {
        return instituteCodeName;
    }

    public void setInstituteCodeName(String instituteCodeName) {
        this.instituteCodeName = instituteCodeName;
    }

    public String getPhoneFax() {
        return phoneFax;
    }

    public void setPhoneFax(String phoneFax) {
        this.phoneFax = phoneFax;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getViewDetails() {
        return viewDetails;
    }

    public void setViewDetails(String viewDetails) {
        this.viewDetails = viewDetails;
    }
}
