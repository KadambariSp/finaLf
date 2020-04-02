package com.example.eudcatetoelevate.Model;

public class StoreStudentProfileSY {
    String name,email,phone,city,qualification,collegeName,passingYear;
    String fields;

    public StoreStudentProfileSY(String name, String email, String phone, String city, String qualification, String collegeName, String passingYear, String fields) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.qualification = qualification;
        this.collegeName = collegeName;
        this.passingYear = passingYear;
        this.fields = fields;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
}
