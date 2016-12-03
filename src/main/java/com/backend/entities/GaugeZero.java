package com.backend.entities;

/**
 * Created by Felix on 03.12.2016.
 * Package: com.backend.entities
 * Project: waterlevels
 */
public class GaugeZero {

    public String unit;
    public int value;
    public String validFrom;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }


}
