package com.roskosmos.solarsystem.dao;

import com.roskosmos.solarsystem.model.impl.Planet;

import java.util.List;

public interface PlanetDAO {

    Planet getOne(Long id);
    List<Planet> findAll();
    List<Planet> findAllBySunId(Long sunId);
}
