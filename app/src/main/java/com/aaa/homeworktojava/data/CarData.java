package com.aaa.homeworktojava.data;

public class CarData {

    private String description;
    private int imgID;

    public CarData(String description, int imgID) {
        this.description = description;
        this.imgID = imgID;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgID() {
        return imgID;
    }
    public void setImgID(int imgID) {
        this.imgID = imgID;
    }
}
