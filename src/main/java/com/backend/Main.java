package com.backend;

import com.backend.fetch.ScheduledStationFetch;
import com.backend.serve.ServeController;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineParameter;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlinePegelinformation;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineWebservicePortType;
import de.wsv.pegelonline.webservices.version2_3.api.PegelonlineWebservice_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.rmi.RemoteException;

/**
 * Created by Felix on 02.12.2016.
 * Package: PACKAGE_NAME
 * Project: DataRun-WaterLevels
 */
@SpringBootApplication
@EnableScheduling
public class Main {

    @Autowired
    public static JdbcTemplate jdbcTemplate;
    public static ServeController serveController = new ServeController();


    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
        ScheduledStationFetch fetch = new ScheduledStationFetch();
        fetch.getMessStellenAndWater();


//        jdbcTemplate.execute("DROP TABLE waterlevels IF EXISTS");
  //      jdbcTemplate.execute("CREATE TABLE waterlevels(" +
    //            "timestamp VARCHAR(255), value NUMBER, latitude REAL, longitude REAL)");
        //jdbcTemplate.batchUpdate("INSERT INTO waterlevels(timestamp, value, latitude, longitude) VALUES (?,?,?,?)", serveController.serveWaterLevels());


    }




}
