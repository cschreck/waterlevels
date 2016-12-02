package com.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Felix on 02.12.2016.
 * Package: com.backend.entities
 * Project: DataRun-WaterLevels
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {

    public String uuid;
    public String number;
    public String shortname;
    public String longname;

}
