package com.backend.fetch;

import java.text.SimpleDateFormat;
import java.util.Date;

import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineMessstelle;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineWebservicePortType;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineWebservice_Impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by masc on 02.12.2016.
 */
@Component
public class ScheduledStationFetch {

    private static final Logger log = LoggerFactory.getLogger(ScheduledStationFetch.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000*60*10)
    public void getMessStellen() {
        try {
            PegelonlineWebservicePortType port =
                    new PegelonlineWebservice_Impl().getPegelonlineWebservicePort();

            PegelonlineMessstelle[] messstellen  = port.getMessstellenList(null, null);

            for (PegelonlineMessstelle messstelle: messstellen){
                log.info(messstelle.getName());
            }



        }catch (Exception e){

        }

    }

}
