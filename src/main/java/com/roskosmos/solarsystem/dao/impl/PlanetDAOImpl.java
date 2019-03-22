package com.roskosmos.solarsystem.dao.impl;

import com.roskosmos.solarsystem.connector.ServerConnector;
import com.roskosmos.solarsystem.dao.PlanetDAO;
import com.roskosmos.solarsystem.model.impl.Planet;
import com.roskosmos.solarsystem.query.ServerQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanetDAOImpl implements PlanetDAO {

    @Override
    public Planet getOne(Long id) {
        return null;
    }

    @Override
    public List<Planet> findAll() {
        return null;
    }

    @Override
    public List<Planet> findAllBySunId(Long sunId) {
        Connection connection = ServerConnector.getInstance().getConnection();
        String query = ServerQuery.getInstance().getQuery("query105");
        List<Planet> planets = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, sunId);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                Planet planet = new Planet();
                planet.setId(resultSet.getLong(1));
                planet.setSunId(resultSet.getLong(2));
                planet.setOrbit(resultSet.getInt(3));
                planet.setName(resultSet.getString(4));
                planet.setType(resultSet.getString(5));
                planet.setHabitable(resultSet.getBoolean(6));
                planet.setPopulation(resultSet.getLong(7));
                planet.setSatellites(new ArrayList<>());

                planets.add(planet);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if (preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return planets;
    }
}
