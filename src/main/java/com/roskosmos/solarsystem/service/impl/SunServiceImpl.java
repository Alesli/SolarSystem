package com.roskosmos.solarsystem.service.impl;

import com.roskosmos.solarsystem.dao.SunDAO;
import com.roskosmos.solarsystem.dao.impl.SunDAOImpl;
import com.roskosmos.solarsystem.model.impl.Sun;
import com.roskosmos.solarsystem.service.SunService;

import java.util.List;

public class SunServiceImpl implements SunService {

    private SunDAO sunDAO = new SunDAOImpl();

    @Override
    public Sun getOne(Long id) {
        return sunDAO.getOne(id);
    }

    @Override
    public List<Sun> findAll() {
        return sunDAO.findAll();
    }
}
