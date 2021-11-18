package io.service;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SettingsTest {

    @Test
    public void whenLoadWithIndep() throws IOException {
        Settings settings = new Settings();
        File file = new File("./app.properties");
        //File file_test = new File("./../"); parent path
        File fileTest = new File("./");
        Arrays.stream(fileTest.listFiles()).forEach(System.out::println);
        try (FileInputStream io = new FileInputStream(file)) {
            settings.load(io);
        }

        String value = settings.getValue("home.path");
        assertThat(value, is("c:\\temp\\"));
    }

    @Test
    public void whenLoadClassloader() throws IOException {
        Settings settings = new Settings();
        ClassLoader ldr = Settings.class.getClassLoader();
        try (InputStream io = ldr.getResourceAsStream("app_load.properties")) {
            settings.load(io);
        }

        String value = settings.getValue("home.path");
        assertThat(value, is("c:\\temp\\"));
    }
}
