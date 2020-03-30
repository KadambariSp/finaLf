package com.example.eudcatetoelevate.Model;

public class ParentSecretCodes {
    private String enrollmentNO,code;

    public String getEnrollmentNO() {
        return enrollmentNO;
    }

    public void setEnrollmentNO(String enrollmentNO) {
        this.enrollmentNO = enrollmentNO;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ParentSecretCodes(String enrollmentNO, String code) {
        this.enrollmentNO = enrollmentNO;
        this.code = code;
    }

    public ParentSecretCodes() {
    }
}
