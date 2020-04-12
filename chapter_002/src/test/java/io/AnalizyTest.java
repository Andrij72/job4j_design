package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void unavailable() throws IOException {
        File source = tempFolder.newFile("text.txt");
        File target = tempFolder.newFile("log.txt");

        StringBuilder builder = new StringBuilder();
        builder.append("200 10:56:01").append(System.lineSeparator());
        builder.append("500 10:57:01").append(System.lineSeparator());
        builder.append("400 10:58:01").append(System.lineSeparator());
        builder.append("200 10:59:01").append(System.lineSeparator());
        try (PrintWriter out = new PrintWriter(source)) {
            out.write(builder.toString());
        }
        Analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder res = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
         in.lines().forEach(res::append);
        }
        assertThat(res.toString(), is("Start server: 10:57:01" + " Finish server: 10:59:01"));
    }
}