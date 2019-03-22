package com.roskosmos.solarsystem.facade;

import com.roskosmos.solarsystem.model.impl.Sun;

public interface SolarSystemFacade {

    Sun getSunById(Long sunId);

}
