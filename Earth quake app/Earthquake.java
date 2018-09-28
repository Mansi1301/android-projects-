package com.example.android.quakereport;

/**
 * Created by MANSI on 3/11/2018.
 */

public class Earthquake {

    private double magnitude;
    private String place;
    private long timeInMilliseconds;
    private String url;

    public Earthquake(double magnitude, String place, long timeInMilliseconds, String url) {
        this.magnitude = magnitude;
        this.place = place;
        this.timeInMilliseconds = timeInMilliseconds;
        this.url = url;
    }

    public long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }

    public String getPlace() {
        return place;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public  String getUrl() { return url; }

}
