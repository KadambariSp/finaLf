package com.example.eudcatetoelevate.Model;

public class MobileNumbersSy{
    private String  enrollmentNO1,Mobile1;

    public String getEnrollmentNO() {
        return enrollmentNO1;
    }

    public void setEnrollmentNO(String enrollmentNO) {
        this.enrollmentNO1 = enrollmentNO;
    }

    public String getMobile() {
        return Mobile1;
    }

    public void setMobile(String mobile) {
        Mobile1 = mobile;
    }

    public MobileNumbersSy(String enrollmentNO, String mobile) {
        this.enrollmentNO1 = enrollmentNO;
        Mobile1 = mobile;
    }

    public MobileNumbersSy() {
    }
}
