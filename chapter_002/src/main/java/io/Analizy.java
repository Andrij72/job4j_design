package io;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Analizy {

    public static void checkLog(String source, String target) {
        StringBuilder out = new StringBuilder();

        try (BufferedReader buf = new BufferedReader(new FileReader(source));
             BufferedWriter trg = new BufferedWriter(new FileWriter(target))) {
            String line = "";
            boolean check = false;
            while ((line = buf.readLine()) != null) {
                if ((line.contains("500") || line.contains("400")) && !check) {
                    check = true;
                    out.append("Start server: ").append(line.substring(4)).append(System.lineSeparator());
                }
                if ((line.contains("200") || line.contains("300")) && check) {
                    out.append(" Finish server: ").append(line.substring(4)).append(System.lineSeparator());
                    check = false;
                }
            }
            trg.write(out.toString());
            System.out.println(out);
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void unavailable(String source, String target) {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader buf = new BufferedReader(new FileReader(source));
             PrintWriter trg = new PrintWriter(new FileOutputStream(target))) {
            AtomicBoolean check = new AtomicBoolean(false);
            buf.lines()
                    .filter(l -> !l.isBlank())
                    .filter(e -> {
                        if ((e.contains("500") || e.contains("400")) && !check.get()) {
                            check.set(true);
                            out.add("Start server: " + e.substring(4) + "\n");
                        }
                        if ((e.contains("200") || e.contains("300")) && check.get()) {
                            out.add(" Finish server: " + e.substring(4) + "\n");
                            check.set(false);
                        }
                        return e.isEmpty();
                    })
                    .findAny();

            trg.println(out.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void anotherUnavailable(String source, String target) {
        Map<String, String> values = new HashMap<>();
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader buf = new BufferedReader(new FileReader(source))) {
            buf.lines()
                    .filter(l -> !l.isBlank()).filter(l -> !l.isBlank())
                    .collect(Collectors.toMap(k -> k.substring(4), v -> v.substring(0, 3),
                            (a, b) -> String.join(", ", a, b), LinkedHashMap::new))
                    .forEach(values::put);
            Set entrySet = values.entrySet();
            Iterator it = entrySet.iterator();
            boolean check = false;
            while (it.hasNext()) {
                Map.Entry me = (Map.Entry) it.next();
                if ((me.getValue().equals("500") || me.getValue().equals("400")) && !check) {
                    check = true;
                    out.add("Start server: " + me.getKey() + "\n");
                }
                if ((me.getValue().equals("200") || me.getValue().equals("300")) && check) {
                    out.add(" Finish server: " + me.getKey() + "\n");
                    check = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter trg = new PrintWriter(new FileOutputStream(target))) {
            trg.println(out.toString());
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //anotherUnavailable("servers.log", "unavailable.csv");
        checkLog("servers.log", "unavailable.csv");
    }
}
