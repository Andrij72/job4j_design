package ru.job4.spammer;

import ru.job4.jdbc.Property;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImportDb {
    private String dump;
    private Connection connection;

    public ImportDb(String dump) throws SQLException, ClassNotFoundException, IOException {
        initConnection();
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(ln -> {
                if (!ln.isEmpty()) {
                    users.add(new User(ln.substring(0, ln.indexOf(";")), ln.substring(ln.indexOf(";") + 1)));
                }
            });
        }
        return users;
    }

    private void initConnection() throws SQLException, ClassNotFoundException, IOException {
        Property settings = new Property();
        settings.load("app.properties");
        Class.forName(settings.getValue("jdbc.driver"));
        Connection connection = DriverManager.getConnection(settings.getValue("jdbc.url"),
                settings.getValue("jdbc.username"), settings.getValue("jdbc.password"));
        this.connection = connection;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException, IOException {

        for (User user : users) {
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO users(usr_name,email) VALUES(?,?);")) {
                ps.setString(1, user.name);
                ps.setString(2, user.email);
                ps.executeUpdate();
            }
        }
        initConnection();
    }

    private static class User {
        String name;
        String email;
        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        ImportDb db = new ImportDb("./chapter_004/dump.txt");
        db.save(db.load());
    }
}
