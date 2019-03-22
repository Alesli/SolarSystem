package com.roskosmos.solarsystem.dao.impl;

import com.roskosmos.solarsystem.connector.ServerConnector;
import com.roskosmos.solarsystem.dao.SunDAO;
import com.roskosmos.solarsystem.model.impl.Sun;
import com.roskosmos.solarsystem.query.ServerQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SunDAOImpl implements SunDAO {

    @Override
    public Sun getOne(Long id) {

        Connection connection = ServerConnector.getInstance().getConnection();
        String query = ServerQuery.getInstance().getQuery("query102");
        //выводит солнца по id, только заданное

        Sun sun = new Sun();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // подготавливаем запрос, т.е. пихаем его строковое представление в connection
            preparedStatement = connection.prepareStatement(query);
            // устанавливаем параметр для запроса, вместо ? теперь будет id
            preparedStatement.setLong(1, id);
            // если бы у нас было два знака вопроса, то для второго,
            // мы бы указали параметр так же, но номер был бы уже 2 (parameterIndex)
            // пример
            // preparedStatement.setString(2, name);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            sun.setId(resultSet.getLong(1));
            sun.setOrbit(resultSet.getInt(2));
            sun.setName(resultSet.getString(3));
            sun.setPlanets(new ArrayList<>());
        } catch (SQLException e) {
            e.printStackTrace();
            close(preparedStatement, resultSet);
        }
        return sun;
    }

    @Override
    public List<Sun> findAll() {

        Connection connection = ServerConnector.getInstance().getConnection();
        String query = ServerQuery.getInstance().getQuery("query101");
        // выводит все солнца

        List<Sun> sunList = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Sun sun = new Sun();
                sun.setId(resultSet.getLong(1));
                sun.setOrbit(resultSet.getInt(2));
                sun.setName(resultSet.getString(3));
                sun.setPlanets(new ArrayList<>());
                sunList.add(sun);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return sunList;
    }

    private void close(PreparedStatement preparedStatement, ResultSet resultSet) {

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void close(PreparedStatement preparedStatement, ResultSet resultSet, Connection connection) {

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
