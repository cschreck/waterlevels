package com.backend.fetch;

import java.text.SimpleDateFormat;

import com.backend.entities.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by masc on 02.12.2016.
 */
@Component
public class ScheduledStationFetch {

    private static final Logger log = LoggerFactory.getLogger(ScheduledStationFetch.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private StationRepository stationRepo;
    @Autowired
    private WaterRepository waterRepository;

    @Scheduled(fixedRate = 1000*10000)
    public void getMessStellenAndWater() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        String jsonStationsEndpoint = "http://www.pegelonline.wsv.de/webservices/rest-api/v2/stations.json";

        StationJson[] stations = restTemplate.getForObject(
                jsonStationsEndpoint,
                StationJson[].class);

        for (StationJson stat : stations){
            /**
            WaterEntity water = new WaterEntity(stat.getWater().longname, stat.getWater().shortname);
            waterRepository.save(water);
            */

            StationEntity stationEnt = new StationEntity(
                    stat.getUuid(),
                    stat.getNumber(),
                    stat.getShortname(),
                    stat.getLongname(),
                    stat.getKm(),
                    stat.getAgency(),
                    stat.getLongitude(),
                    stat.getLatitude()
            );

            log.info(stationEnt.toString());

            stationRepo.save(stationEnt);

        }



    }

}
