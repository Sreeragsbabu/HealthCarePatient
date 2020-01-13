package com.example.healthcarepatient.data_models;

import java.sql.Time;

public class Doctor {
    private Integer doctorImage;
    private String doctorName;
    private String doctorCategory;
    private String googleApi;
    private Double doctorRating;
    private Integer years;
    private Integer likes;
    private Integer likePercentage;
    private String call;
    private String time;
    private String patientName;

    public void setDoctorRating(Double doctorRating) {
        this.doctorRating = doctorRating;
    }
    public double getDoctorRating() {
        return doctorRating;
    }

    public Integer getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(Integer doctorImage) {
        this.doctorImage = doctorImage;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorCategory() {
        return doctorCategory;
    }

    public void setDoctorCategory(String doctorCategory) {
        this.doctorCategory = doctorCategory;
    }

    public String getGoogleApi() {
        return googleApi;
    }

    public void setGoogleApi(String googleApi) {
        this.googleApi = googleApi;
    }


    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getLikePercentage() {
        return likePercentage;
    }

    public void setLikePercentage(Integer likePercentage) {
        this.likePercentage = likePercentage;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Doctor(Integer doctorImage, String doctorName, String doctorCategory, String googleApi, Double doctorRating, Integer years, Integer likes, Integer likePercentage, String call, String time, String patientName) {
        this.doctorImage = doctorImage;
        this.doctorName = doctorName;
        this.doctorCategory = doctorCategory;
        this.googleApi = googleApi;
        this.doctorRating = doctorRating;
        this.years = years;
        this.likes = likes;
        this.likePercentage = likePercentage;
        this.call = call;
        this.time = time;
        this.patientName = patientName;
    }

//    public Doctor(Integer doctorImage, String doctorName, String doctorCategory, String googleApi, double doctorRating, Integer years, Integer likes, Integer likePercentage, String call) {
//        this.doctorImage = doctorImage;
//        this.doctorName = doctorName;
//        this.doctorCategory= doctorCategory;
//        this.googleApi = googleApi;
//        this.doctorRating = doctorRating;
//        this.years = years;
//        this.likes = likes;
//        this.likePercentage = likePercentage;
//        this.call = call;
//    }
}
