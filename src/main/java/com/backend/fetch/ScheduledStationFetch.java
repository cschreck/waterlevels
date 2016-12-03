package com.backend.fetch;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.backend.entities.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineParameter;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlinePegelinformation;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineWebservicePortType;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineWebservice_Impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    public ArrayList<String> waterJSONS = new ArrayList<>();

    public void getMessStellenAndWater() {


        RestTemplate restTemplate = new RestTemplate();

        String jsonStationsEndpoint = "http://www.pegelonline.wsv.de/webservices/rest-api/v2/stations.json";

        StationJson[] stations = restTemplate.getForObject(
                jsonStationsEndpoint,
                StationJson[].class);
        for (int i = 0; i < stations.length; i++){

            waterJSONS.add("http://www.pegelonline.wsv.de/webservices/rest-api/v2/stations/"+stations[i].getShortname()+"/W/measurements.json?start=P0DT0H20M");
        }
        String test = "";
        for(int i = 0; i< waterJSONS.size();i++) {

            try {

                //test = waterJSONS.get(i);

                //WaterLevel[] water = restTemplate.getForObject(waterJSONS.get(i), WaterLevel[].class);
                //for (int j = 0; j < water.length; j++) {
                    //if (j < 1) {
                        //System.out.println("Station: " + stations[i].getShortname() + " Wasserstand: " + water[0].getValue());
                        //System.out.println(water[0].getValue());
                        break;
                   // }
                   /* PegelonlineWebservicePortType port =
                            new PegelonlineWebservice_Impl().getPegelonlineWebservicePort();

                    PegelonlinePegelinformation[] pi =
                            port.getPegelinformationen(null, null, new String[] {stations[i].getShortname()});




                for(int x=0; x < pi.length; x++){
                       //if(pi[x].getPegelonlineParameter().getName().equals("WASSERTEMPERATUR ROHDATEN")){
                           System.out.println(stations[i].getShortname());
                           System.out.println(pi[x].getPegelonlineParameter().getName());
                           System.out.println();
                           System.out.println();
                      // }

                }*/

                //}
            }catch (Exception e) {
               // System.out.println(test);
                //e.printStackTrace();
            }
        }



    }

}
