package com.roskosmos.solarsystem.service;

import com.roskosmos.solarsystem.model.impl.Planet;

import java.util.List;

public interface PlanetService {

    Planet getOne(Long id);
    List<Planet> findAll();
    List<Planet> findAllBySunId(Long sunId);
}
