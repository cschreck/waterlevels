package com.backend.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by masc on 02.12.2016.
 */
@Entity
public class StationEntity implements Serializable {

    @Id
    public String uuid;
    public String number;
    public String shortname;
    public String longname;
    public double km;
    public String agency;
    public double longitude;
    public double latitude;


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

    protected StationEntity(){}

    public StationEntity(
            String uuid,
            String number,
            String shortname,
            String longname,
            double km,
            String agency,
            double longitude,
            double latitude
    ){
        this.uuid = uuid;
        this.number = number;
        this.shortname = shortname;
        this.longname = longname;
        this.km = km;
        this.agency = agency;
        this.longitude = longitude;
        this.latitude = latitude;


    }

    @Override
    public String toString(){
        return this.uuid + " " + this.shortname + " " + this.longitude + " " + this.latitude;
    }

}


