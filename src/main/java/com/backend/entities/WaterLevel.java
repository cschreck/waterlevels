package com.backend.entities;

import java.util.Comparator;

/**
 * Created by Felix on 03.12.2016.
 * Package: com.backend.entities
 * Project: waterlevels
 */
public class WaterLevel implements Comparator<WaterLevel>{



    public String timestamp;
    public int value;
    public double longitude;
    public double latitude;
    public String number;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }



    @Override
    public int compare(WaterLevel o1, WaterLevel o2) {
        return Double.compare(o1.getLatitude(), o2.getLatitude());
    }
}
