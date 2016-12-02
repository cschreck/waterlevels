package com.backend.serve;

import com.backend.entities.StationJson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by masc on 02.12.2016.
 */
@RestController
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServeController {

    @RequestMapping("/stations")
    public StationJson[] serveWaterlevels() {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        StationJson[] stations = restTemplate.getForObject("http://www.pegelonline.wsv.de/webservices/rest-api/v2/stations.json", StationJson[].class);
        return stations;
    }



}
