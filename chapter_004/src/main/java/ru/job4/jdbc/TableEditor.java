package ru.job4.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Property properties;

    public TableEditor(Property properties) throws SQLException, IOException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

     private void initConnection() throws SQLException, ClassNotFoundException, IOException {
        Property settings = new Property();
        settings.load("app_load.properties");
        Class.forName(settings.getValue("jdbc.driver"));
        Connection connection = DriverManager.getConnection(settings.getValue("jdbc.url"),
                settings.getValue("jdbc.username"), settings.getValue("jdbc.password"));
        this.connection = connection;
    }

    public void createTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("CREATE TABLE IF NOT EXISTS " + tableName + "();");
            statement.execute(sql);
        }
    }

    public void dropTable(String tableName) {
        try (Statement statement1 = connection.createStatement()) {
            String sql = String.format("DROP TABLE IF EXISTS " + tableName + ";");
            statement1.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE " + tableName + " ADD COLUMN %s %s;", columnName, type);
            statement.execute(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE " + tableName + " DROP COLUMN %s;", columnName);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE IF EXISTS " + tableName + " RENAME COLUMN %s TO %s;", columnName, newColumnName);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getTableScheme(String tableName) throws Exception {
        var header = String.format("%-15s|%-15s%n", "column_name", "type");
        var buffer = new StringBuffer();
        buffer.append(header);
        try (var statement = this.connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.append(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
