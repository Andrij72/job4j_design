package io.filefinder;

import java.io.File;

public class Parameters {
    private static final int DIR_KEY = 0;
    private static final int EXT_KEY = 2;
    private static final int SEARCH_TYPE_KEY = 4;
    private static final int LOG_KEY = 6;

    private final String[] args;


    public Parameters(String[] args) {
        this.args = args;
    }


    public void validateParams() {
        if (args.length != 8) {
            throw new IllegalArgumentException(
                    "Not enough parameters !  Usage sample:  java -jar find.jar -d=c:/ -n=*.txt -t=mask -o=log.txt");
        }
        if (!args[DIR_KEY].equalsIgnoreCase("-d")
                || !args[EXT_KEY].equalsIgnoreCase("-n")
                || !args[SEARCH_TYPE_KEY].equalsIgnoreCase("-t")
                || !args[LOG_KEY].equalsIgnoreCase("-o")
        ) {
            throw new IllegalArgumentException(
                    "Parameter names are wrong !");
        }
        File fl = new File(args[DIR_KEY + 1]);
        if (!fl.exists() || !fl.isDirectory()) {
            throw new IllegalArgumentException(
                    "Directory not exist or it's not directory!");
        }
    }

    public String getDir() {
        return args[DIR_KEY + 1];
    }

    public String getExtKey() {
        return args[EXT_KEY + 1];
    }

    public String getSearchType() {
        return args[SEARCH_TYPE_KEY + 1];
    }

    public String getLog() {
        return args[LOG_KEY + 1];
    }

}
