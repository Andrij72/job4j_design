package io;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToFileTable {
    public static void writeToFile(String txt) {
        try (FileOutputStream fo = new FileOutputStream("table.txt")) {
            fo.write(txt.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String buf = Stream.of("Demo write to file:", "###Multiply table###", "1 * 2 = 2", "1 * 3 = 3", "1 * 4 = 4",
                              "1 * 5 = 5", "1 * 6 = 6", "1 * 7 = 7", "1 * 8 = 8", "1 * 9 = 9", "1 * 10 = 10")
                            .collect(Collectors.joining(System.lineSeparator()));
        builder.append(buf);
        writeToFile(builder.toString());
    }
}
