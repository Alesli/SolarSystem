package com.roskosmos.solarsystem.connector;

import com.roskosmos.solarsystem.property.reader.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ServerConnector {

    private static ServerConnector instance;
    private static Connection connection;

    private ServerConnector() {

        PropertyReader propertyReader = new PropertyReader();
        Properties properties = propertyReader.getProperties("connection.properties");

        Connection conn = null;

        try {
            Class.forName(properties.getProperty("driver"));

            try {
                conn = DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("username"),
                        properties.getProperty("password")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = conn;
    }

    public static ServerConnector getInstance() {
        if (instance == null) {
            instance = new ServerConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
