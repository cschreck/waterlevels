package com.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by masc on 02.12.2016.
 */
@Entity
public class WaterEntity {

    @Id
    private String longname;
    private String shortname;

    protected WaterEntity(){};

    public WaterEntity(String longname, String shortname){
        this.longname = longname;
        this.shortname = shortname;
    }

}
