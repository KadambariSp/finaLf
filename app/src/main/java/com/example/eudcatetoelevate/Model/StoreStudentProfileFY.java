package com.example.eudcatetoelevate.Model;

public class StoreStudentProfileFY {
    String name,email,phone,year,term,shift,batch;
    String enroll;
    public StoreStudentProfileFY(String name, String email, String phone, String year, String term, String shift, String batch, String enroll) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.year = year;
        this.term = term;
        this.shift = shift;
        this.batch = batch;
        this.enroll = enroll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }
}
