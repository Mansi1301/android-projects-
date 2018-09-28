package com.example.android.tourguide;

/**
 * Created by MANSI on 3/8/2018.
 */

public class Place {

    private String about;
    private String placesToVisit;
    private int imageId;

    public Place(String about, String placesToVisit, int imageId) {
        this.about = about;
        this.placesToVisit = placesToVisit;
        this.imageId = imageId;
    }

    public String getPlacesToVisit() {
        return placesToVisit;
    }

    public String getAbout() {
        return about;
    }

    public int getImageId() {
        return imageId;
    }

}
