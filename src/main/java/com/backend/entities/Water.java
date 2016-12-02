package com.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Felix on 02.12.2016.
 * Package: com.backend.entities
 * Project: waterlevels
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Water {

    public String shortname;
    public String longname;

}
