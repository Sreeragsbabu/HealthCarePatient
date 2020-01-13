package com.example.healthcarepatient.data_models;

import android.media.Image;

public class Article {
    private Integer demoImage;
    private String categoryName;
    private String articleHeading;
    private String doctorName;

    public Article(Integer demoImage,String categoryName, String articleHeading, String doctorName) {
        this.demoImage = demoImage;
        this.categoryName = categoryName;
        this.articleHeading = articleHeading;
        this.doctorName = doctorName;
    }

    public Integer getDemoImage() {
        return demoImage;
    }

    public void setDemoImage(Integer demoImage) {
        this.demoImage = demoImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getArticleHeading() {
        return articleHeading;
    }

    public void setArticleHeading(String articleHeading) {
        this.articleHeading = articleHeading;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }


}
