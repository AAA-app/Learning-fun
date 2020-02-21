package com.aaa.homeworktojava.data;

public class DataClass {

    private String description;
    private String image;

    public DataClass(String description, String image) {
        this.description = description;
        this.image = image;
    }

    public DataClass() {
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
