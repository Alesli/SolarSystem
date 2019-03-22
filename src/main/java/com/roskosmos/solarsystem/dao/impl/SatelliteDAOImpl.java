package com.roskosmos.solarsystem.dao.impl;

import com.roskosmos.solarsystem.connector.ServerConnector;
import com.roskosmos.solarsystem.dao.SatelliteDAO;
import com.roskosmos.solarsystem.model.impl.Satellite;
import com.roskosmos.solarsystem.query.ServerQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SatelliteDAOImpl implements SatelliteDAO {

    private Connection connection = ServerConnector.getInstance().getConnection();


    @Override
    public List<Satellite> findAllByPlanetId(Long planetId) {

        String query = ServerQuery.getInstance().getQuery("query108");
        List<Satellite> satellites = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, planetId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Satellite satellite = new Satellite();

                satellite.setId(resultSet.getLong(1));
                satellite.setPlanetId(resultSet.getLong(2));
                satellite.setOrbit(resultSet.getInt(3));
                satellite.setName(resultSet.getString(4));


                satellites.add(satellite);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

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

        return satellites;
    }
}
