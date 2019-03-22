package com.roskosmos.solarsystem.query;

import com.roskosmos.solarsystem.property.reader.PropertyReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ServerQuery {

    private static ServerQuery instance;
    private static Map<String, String> queries;

    private ServerQuery() {

        PropertyReader propertyReader = new PropertyReader();
        Properties properties = propertyReader.getProperties("connection.properties");

        String server = properties.getProperty("server");

        if (server.equalsIgnoreCase("mssql")) {
            properties = propertyReader.getProperties("mssql_queries.properties");
        } else if (server.equalsIgnoreCase("mysql")) {
            properties = propertyReader.getProperties("mysql_queries.properties");
        } else if (server.equalsIgnoreCase("oracle")) {
            properties = propertyReader.getProperties("oracle_queries.properties");
        }

        Map<String, String> map = new HashMap<>(properties.size());
        for (Map.Entry<Object, Object> prop : properties.entrySet()) {
            map.put(prop.getKey().toString(), prop.getValue().toString());
        }
        queries = map;
    }

    public static ServerQuery getInstance() {
        if (instance == null) {
            instance = new ServerQuery();
        }
        return instance;
    }

    public String getQuery(String key) {
        if (key != null) {
            return queries.get(key);
        } else {
            return "";
        }
    }
}
