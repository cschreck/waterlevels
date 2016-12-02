package com.backend.fetch;

import java.text.SimpleDateFormat;

import com.backend.entities.Messstelle;
import com.backend.entities.MessstelleRepository;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineMessstelle;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlinePegelinformation;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineWebservicePortType;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineWebservice_Impl;
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

    @Scheduled(fixedRate = 1000*60)
    public void getMessStellen() {

        try {
            PegelonlineWebservicePortType port =
                    new PegelonlineWebservice_Impl().getPegelonlineWebservicePort();

            PegelonlineMessstelle[] messstellen  = port.getMessstellenList(null, null);

            PegelonlinePegelinformation[] pi =
                    port.getPegelinformationen(null, null, new String[] {"TRUNSTADT"});

            //Ausgabe der aktuellen Messung der Messstelle TRUNSTADT für alle Parameter
            for (int i = 0; i < pi.length; i++) {
                //System.out.println(pi[i].getPegelonlineKoordinate().getHochwert().toString());
                //System.out.println(pi[i].getPegelonlineKoordinate().getRechtswert().toString());
                //System.out.println(pi[i].getPegelonlineMessstelle().getName());
            }

            for (PegelonlineMessstelle messstelle: messstellen){
              //  log.info(messstelle.getName());
                System.out.println(messstelle.getName());
            }


        }catch (Exception e){

        }


        repository.save(new Messstelle("a", "b"));

        for(Messstelle mess : repository.findAll()){
          //  log.info(mess.toString());
        }


    }

}
