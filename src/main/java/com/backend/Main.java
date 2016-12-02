package com.backend;

import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineParameter;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlinePegelinformation;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineWebservicePortType;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineWebservice_Impl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.rmi.RemoteException;

/**
 * Created by Felix on 02.12.2016.
 * Package: PACKAGE_NAME
 * Project: DataRun-WaterLevels
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);

        PegelonlineWebservicePortType port =
                new PegelonlineWebservice_Impl().getPegelonlineWebservicePort();

        //Abfrage getParameterList: Alle in Pegelonline Webservice-Aktuell enthaltenden Parameter
        //werden zurückgeliefert
        //Bei PegelonlineParameter handelt es sich um einen custom-type aus Pegelonline Webservice-Aktuell
        try{
            PegelonlineParameter[] par = new PegelonlineParameter[0];
            par = port.getParameterList();

            //Ausgabe der Parameternamer

                PegelonlinePegelinformation[] pi =
            port.getPegelinformationen(null, null, new String[] {"EITZE"});

                //Ausgabe der aktuellen Messung der Messstelle TRUNSTADT für alle Parameter
                for (int x = 0; x < pi.length; x++) {
                    System.out.println(
                            "Letzte Messung vom " +
                                    pi[x].getPegelonlineAktuelleMessung().getZeitpunkt().getTime() +
                                    " mit dem Wert " + pi[x].getPegelonlineAktuelleMessung().getMesswert() +
                                    " für den Parameter " + pi[x].getPegelonlineParameter().getName());
                    System.out.println();
                }


        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
