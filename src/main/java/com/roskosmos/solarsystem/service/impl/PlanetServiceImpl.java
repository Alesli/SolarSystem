package com.roskosmos.solarsystem.service.impl;

import com.roskosmos.solarsystem.dao.PlanetDAO;
import com.roskosmos.solarsystem.dao.impl.PlanetDAOImpl;
import com.roskosmos.solarsystem.model.impl.Planet;
import com.roskosmos.solarsystem.service.PlanetService;

import java.util.List;

public class PlanetServiceImpl implements PlanetService {

    private PlanetDAO planetDAO = new PlanetDAOImpl();

    @Override
    public Planet getOne(Long id) {
        return planetDAO.getOne(id);
    }

    @Override
    public List<Planet> findAll() {
        return planetDAO.findAll();
    }

    @Override
    public List<Planet> findAllBySunId(Long sunId) {
        return planetDAO.findAllBySunId(sunId);
    }
}
