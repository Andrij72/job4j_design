package io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Analizy {

    public static void unavailable(String source, String target) {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader buf = new BufferedReader(new FileReader(source))) {
            /* buf.lines()
             *//* .filter(e -> e.substring(0, 2)). e.startsWith("500") || e.startsWith("400"))*//*
                    .dropWhile(e -> e.startsWith("500") || e.startsWith("400"))
                    .map(str -> "Start: " + str)
                    .takeWhile(e -> e.startsWith("200") || e.startsWith("300"))
                    .map(str -> "Finish: " + str)
                    .forEach(out::add);*/
            //  System.out.println(out.toString());
            Map<String, String> values = new LinkedHashMap<>();
            Map<String, String> reslt = new LinkedHashMap<>();
            buf.lines().filter(l -> !l.isBlank())
                    .collect(Collectors.toMap(k -> k.substring(4), v -> v.substring(0, 3),
                            (a, b) -> String.join(", ", a, b),
                            LinkedHashMap::new
                    )).forEach(values::put);

            Set entrySet = values.entrySet();
            Iterator it = entrySet.iterator();
            boolean check = false;
            while (it.hasNext()) {
                Map.Entry me = (Map.Entry) it.next();
                if ((me.getValue().equals("500") || me.getValue().equals("400")) && !check) {
                    check = true;
                    out.add("Start server: " + me.getKey() + "\n");
                    continue;
                }
                if ((me.getValue().equals("200") || me.getValue().equals("300")) && check) {
                    out.add("Finish server: " + me.getKey() + "\n");
                    check = false;
                }
            }
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

        try (PrintWriter trg = new PrintWriter(new FileOutputStream(target))) {
            trg.println(out.toString());
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        unavailable("servers.log", "unavailable.csv");
    }
}
