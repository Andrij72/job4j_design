package ru.job4.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Config conf = new Config();
        ClassLoader ldr = Config.class.getClassLoader();

        try (InputStream io = ldr.getResourceAsStream("app_load.properties")) {
            Class.forName("org.postgresql.Driver");
            conf.load(io);
            try (Connection connection = DriverManager.getConnection(conf.getValue("jdbc.url"),
                    conf.getValue("jdbc.username"), conf.getValue("jdbc.password"))) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
        }
    }
}

