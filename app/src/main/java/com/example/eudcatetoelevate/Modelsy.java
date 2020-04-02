package com.example.eudcatetoelevate;

public class Modelsy {
    private int image2;
    private String title2;
    private String desc2;

    public Modelsy(int image, String title, String desc) {
        this.image2 = image;
        this.title2 = title;
        this.desc2 = desc;
    }

    public int getImage() {
        return image2;
    }

    public void setImage(int image) {
        this.image2 = image;
    }

    public String getTitle() {
        return title2;
    }

    public void setTitle(String title) {
        this.title2 = title;
    }

    public String getDesc() {
        return desc2;
    }

    public void setDesc(String desc) {
        this.desc2 = desc;
    }

}
