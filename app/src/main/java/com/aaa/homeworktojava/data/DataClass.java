package com.aaa.homeworktojava.data;

public class DataClass {

    private String description;
    private String image;
    private String radioUrl;

    public DataClass(String description, String image, String radioUrl) {
        this.description = description;
        this.image = image;
        this.radioUrl = radioUrl;
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

    public String getRadioUrl() {
        return radioUrl;
    }
    public void setRadioUrl(String radioUrl) {
        this.radioUrl = radioUrl;
    }
}
