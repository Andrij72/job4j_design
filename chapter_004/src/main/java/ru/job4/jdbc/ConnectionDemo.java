package ru.job4.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws SQLException, IOException {
        Property conf = new Property();
            conf.load("app_load.properties");
            try (Connection connection = DriverManager.getConnection(conf.getValue("jdbc.url"),
                    conf.getValue("jdbc.username"), conf.getValue("jdbc.password"))) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
        }
    }
