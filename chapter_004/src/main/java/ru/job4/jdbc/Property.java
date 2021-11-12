package ru.job4.jdbc;

import java.io.InputStream;

public class Property {
    private final java.util.Properties prs = new java.util.Properties();

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }

    public void load(String filename) {
        ClassLoader ldr = Property.class.getClassLoader();
        try (InputStream io = ldr.getResourceAsStream(filename)) {
            this.prs.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
