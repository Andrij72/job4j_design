package ru.job4.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDb {

    private Properties cfg;
    private String dump;

    public ImportDb(Properties cfg, String dump) {
        this.cfg = cfg;
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

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("INSERT INTO users(usr_name,email) VALUES(?,?);")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.executeUpdate();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./chapter_004/app.properties")) {
            cfg.load(in);
        }
        ImportDb db = new ImportDb(cfg, "./chapter_004/dump.txt");
        db.save(db.load());
    }
}
