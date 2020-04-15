package com.aaa.learningfun.data;

public class DataClass {

    private String description;
    private String image;
    private String radioUrl;
    private String url;

    public DataClass(String description, String image, String radioUrl, String url) {
        this.description = description;
        this.image = image;
        this.radioUrl = radioUrl;
        this.url = url;
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

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
