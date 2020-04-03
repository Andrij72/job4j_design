package io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> lines = new ArrayList<>();

    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(lines::add);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines.stream().filter(e -> e.contains("404")).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.forEach(System.out::println);
    }
}
