package com.roskosmos.solarsystem;

import com.roskosmos.solarsystem.facade.SolarSystemFacade;
import com.roskosmos.solarsystem.facade.impl.SolarSystemFacadeImpl;
import com.roskosmos.solarsystem.model.impl.Satellite;
import com.roskosmos.solarsystem.model.impl.Sun;
import com.roskosmos.solarsystem.service.SatelliteService;
import com.roskosmos.solarsystem.service.impl.SatelliteServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        SatelliteService satelliteService = new SatelliteServiceImpl();
//        List<Satellite> satellites = satelliteService.findAllByPlanetId(8L);
//        for (Satellite satellite : satellites) {
//            System.out.println(satellite);
//        }

        SolarSystemFacade solarSystemFacade = new SolarSystemFacadeImpl();
        Sun sun = solarSystemFacade.getSunById(1L);
        System.out.println(sun);
    }
}
