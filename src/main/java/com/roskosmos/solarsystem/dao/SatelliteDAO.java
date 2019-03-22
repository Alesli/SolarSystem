package com.roskosmos.solarsystem.dao;

import com.roskosmos.solarsystem.model.impl.Satellite;

import java.util.List;

public interface SatelliteDAO {

    List<Satellite> findAllByPlanetId(Long planetId);
}
