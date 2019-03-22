package com.roskosmos.solarsystem.service.impl;

import com.roskosmos.solarsystem.dao.SatelliteDAO;
import com.roskosmos.solarsystem.dao.impl.SatelliteDAOImpl;
import com.roskosmos.solarsystem.model.impl.Satellite;
import com.roskosmos.solarsystem.service.SatelliteService;

import java.util.List;

public class SatelliteServiceImpl implements SatelliteService{

    private SatelliteDAO satelliteDAO = new SatelliteDAOImpl();

    @Override
    public List<Satellite> findAllByPlanetId(Long planetId) {
        return satelliteDAO.findAllByPlanetId(planetId);
    }
}
