package com.backend.fetch;

import java.text.SimpleDateFormat;

import com.backend.entities.Messstelle;
import com.backend.entities.MessstelleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by masc on 02.12.2016.
 */
@Component
public class ScheduledStationFetch {

    private static final Logger log = LoggerFactory.getLogger(ScheduledStationFetch.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private MessstelleRepository repository;

    @Scheduled(fixedRate = 1000)
    public void getMessStellen() {
        /**
        try {
            PegelonlineWebservicePortType port =
                    new PegelonlineWebservice_Impl().getPegelonlineWebservicePort();

            PegelonlineMessstelle[] messstellen  = port.getMessstellenList(null, null);

            for (PegelonlineMessstelle messstelle: messstellen){
                log.info(messstelle.getName());
            }


        }catch (Exception e){

        }
        */

        repository.save(new Messstelle("a", "b"));

        for(Messstelle mess : repository.findAll()){
            log.info(mess.toString());
        }


    }

}
