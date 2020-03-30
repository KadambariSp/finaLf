package com.example.eudcatetoelevate.Model;

public class MobileNumbersTeacher {
   private String  enrollmentNO,Mobile;

    public String getEnrollmentNO() {
        return enrollmentNO;
    }

    public void setEnrollmentNO(String enrollmentNO) {
        this.enrollmentNO = enrollmentNO;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public MobileNumbersTeacher() {
    }

    public MobileNumbersTeacher(String enrollmentNO, String mobile) {
        this.enrollmentNO = enrollmentNO;
        Mobile = mobile;
    }
}
