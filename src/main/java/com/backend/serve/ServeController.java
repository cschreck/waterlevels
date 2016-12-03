package com.backend.serve;

import com.backend.entities.StationJson;
import com.backend.entities.WaterLevel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by masc on 02.12.2016.
 */
@RestController
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServeController {

    public ServeController(){

    }

    @RequestMapping(value = "/stations", method = RequestMethod.POST)
    public StationJson[] serveStations() {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        StationJson[] stations = restTemplate.getForObject("http://www.pegelonline.wsv.de/webservices/rest-api/v2/stations.json?includeTimeseries=true", StationJson[].class);
        return stations;
    }

    @RequestMapping(value = "/waterlevels", method = RequestMethod.POST)
    public ArrayList<WaterLevel> serveWaterLevels(){
        RestTemplate restTemplate = new RestTemplate();
        StationJson[] stations = restTemplate.getForObject("http://www.pegelonline.wsv.de/webservices/rest-api/v2/stations.json", StationJson[].class);
        ArrayList<String> waterJSONS = new ArrayList<>();
        ArrayList<WaterLevel> waterLevels = new ArrayList<>();

        for (int i = 0; i < stations.length; i++){

            waterJSONS.add("http://www.pegelonline.wsv.de/webservices/rest-api/v2/stations/"+stations[i].getShortname()+"/W/measurements.json?start=P0DT0H20M");
        }
        String test = "";
        for(int i = 0; i< waterJSONS.size();i++) {

            try {

                //test = waterJSONS.get(i);

                WaterLevel [] water = restTemplate.getForObject(waterJSONS.get(i), WaterLevel[].class);
                for (int j = 0; j < water.length; j++) {
                    if (j == 0) {
                        water[0].setLatitude(stations[i].getLatitude());
                        water[0].setLongitude(stations[i].getLongitude());
                        water[0].setNumber(stations[i].getNumber());
                        waterLevels.add(water[0]);
                        System.out.println(water[0].getValue());
                        break;
                    }
                }
            }catch (Exception e) {
                i++;
            }
        }

        Collections.sort(waterLevels, (o1, o2) -> Double.valueOf(o1.getLatitude()).compareTo(Double.valueOf(o2.getLatitude())));

        return waterLevels;
    }



}
