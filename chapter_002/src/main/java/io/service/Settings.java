package io.service;

import java.io.InputStream;
import java.util.Properties;

public class Settings {
    private final Properties prs = new Properties();

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }

    public void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
