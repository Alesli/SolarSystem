package com.roskosmos.solarsystem.service;

import com.roskosmos.solarsystem.model.impl.Sun;

import java.util.List;

public interface SunService {

    Sun getOne(Long id);

    List<Sun> findAll();
}
