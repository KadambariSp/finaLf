package com.example.eudcatetoelevate;

public class model {
    String title,image,description;

    public model(String title, String image, String description) {
        this.title = title;
        this.image = image;
        this.description = description;
    }

    public model() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
