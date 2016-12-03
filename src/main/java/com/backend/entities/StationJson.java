package com.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Felix on 02.12.2016.
 * Package: com.backend.entities
 * Project: DataRun-WaterLevels
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationJson {

    public String uuid;
    public String number;
    public String shortname;
    public String longname;
    public double km;
    public String agency;
    public double longitude;
    public double latitude;
    public WaterJson water;
    public Timeseries[] timeseries;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
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

    public WaterJson getWater() {
        return water;
    }

    public void setWater(WaterJson water) {
        this.water = water;
    }



}
