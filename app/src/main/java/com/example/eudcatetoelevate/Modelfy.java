package com.example.eudcatetoelevate;

public class Modelfy  {
    private int image1;
    private String title1;
    private String desc1;

    public Modelfy(int image, String title, String desc) {
        this.image1 = image;
        this.title1= title;
        this.desc1 = desc;
    }

    public int getImage() {
        return image1;
    }

    public void setImage(int image) {
        this.image1 = image;
    }

    public String getTitle() {
        return title1;
    }

    public void setTitle(String title) {
        this.title1 = title;
    }

    public String getDesc() {
        return desc1;
    }

    public void setDesc(String desc) {
        this.desc1 = desc;
    }

}
