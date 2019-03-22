package com.roskosmos.solarsystem.service;

import com.roskosmos.solarsystem.model.impl.Satellite;

import java.util.List;

public interface SatelliteService {

    List<Satellite> findAllByPlanetId(Long planetId);
}
