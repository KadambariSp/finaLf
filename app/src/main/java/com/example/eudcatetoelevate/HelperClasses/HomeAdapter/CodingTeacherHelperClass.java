package com.example.eudcatetoelevate.HelperClasses.HomeAdapter;

public class CodingTeacherHelperClass {
    int image;
    String title,description;

    public CodingTeacherHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
