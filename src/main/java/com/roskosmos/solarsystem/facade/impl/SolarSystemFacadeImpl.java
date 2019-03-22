package com.roskosmos.solarsystem.facade.impl;

import com.roskosmos.solarsystem.facade.SolarSystemFacade;
import com.roskosmos.solarsystem.model.impl.Planet;
import com.roskosmos.solarsystem.model.impl.Satellite;
import com.roskosmos.solarsystem.model.impl.Sun;
import com.roskosmos.solarsystem.service.PlanetService;
import com.roskosmos.solarsystem.service.SatelliteService;
import com.roskosmos.solarsystem.service.SunService;
import com.roskosmos.solarsystem.service.impl.PlanetServiceImpl;
import com.roskosmos.solarsystem.service.impl.SatelliteServiceImpl;
import com.roskosmos.solarsystem.service.impl.SunServiceImpl;

import java.util.List;

public class SolarSystemFacadeImpl implements SolarSystemFacade {

    private SunService sunService = new SunServiceImpl();
    private PlanetService planetService = new PlanetServiceImpl();
    private SatelliteService satelliteService = new SatelliteServiceImpl();

    @Override
    public Sun getSunById(Long sunId) {

        Sun sun = sunService.getOne(sunId);

        List<Planet> planets = planetService.findAllBySunId(sunId);

        for (Planet planet : planets) {
            List<Satellite> satellites = satelliteService.findAllByPlanetId(planet.getId());
            planet.setSatellites(satellites);
        }

        sun.setPlanets(planets);

        return sun;
    }
}
