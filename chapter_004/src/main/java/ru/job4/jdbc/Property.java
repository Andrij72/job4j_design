package ru.job4.jdbc;

import java.io.IOException;

public class Property {
    private final java.util.Properties prs = new java.util.Properties();

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }

    public void load(String filename) throws IOException {
            this.prs.load(Property.class.getClassLoader().getResourceAsStream(filename));
    }
}
