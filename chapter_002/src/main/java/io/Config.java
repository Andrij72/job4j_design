package io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader content = new BufferedReader(new FileReader("./data/pair_without_comment.properties"))) {
            Map<String, String> res = content.lines().filter((line) ->
                    (line.contains("=") && !line.startsWith("#") && !line.isBlank()))
                    .collect(Collectors.toMap(k -> k.substring(0, k.indexOf('=')), v -> v.substring(v.indexOf('=') + 1)));
            values.putAll(res);
            values.forEach((k, v) -> System.out.println("[" + k + "=" + v + "]"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {

        return values.get(key);
    }
}
