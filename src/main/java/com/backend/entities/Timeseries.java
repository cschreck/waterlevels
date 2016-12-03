package com.backend.entities;

/**
 * Created by Felix on 03.12.2016.
 * Package: com.backend.entities
 * Project: waterlevels
 */
public class Timeseries {



    public String shortName;
    public String longName;
    public String unit;
    public int equidistance;
    public GaugeZero gaugeZero;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getEquidistance() {
        return equidistance;
    }

    public void setEquidistance(int equidistance) {
        this.equidistance = equidistance;
    }

    public GaugeZero getGaugeZero() {
        return gaugeZero;
    }

    public void setGaugeZero(GaugeZero gaugeZero) {
        this.gaugeZero = gaugeZero;
    }


}
