package com.aaa.homeworktojava.data;

public class DataClass {

    private String description;
    private String imageUrl;

    public DataClass(String description, String imageUrl) {
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public DataClass() {
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
