package com.roskosmos.solarsystem.dao;

import com.roskosmos.solarsystem.model.impl.Sun;

import java.util.List;

public interface SunDAO {

    Sun getOne(Long id);

    List<Sun> findAll();
}
