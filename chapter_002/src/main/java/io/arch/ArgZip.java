package io.arch;

import java.io.File;
import java.util.Arrays;

public class ArgZip {
    private final static int COMMAND_LINE_LENGTH = 6;
    private final static int PARAM_COUNT = 3;
    private final static int DIR_KEY = 0;
    private final static int EXT_KEY = 3;
    private final static int OUT_KEY = 5;
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() throws Exception {
        int keyCount = (int) Arrays.stream(args).filter(s -> s.startsWith("-")).count();

        if (args.length != COMMAND_LINE_LENGTH && keyCount != PARAM_COUNT) {
            throw new Exception("Invalid command line or count of args.");
        }

        if (!args[DIR_KEY].equals("-d") || !args[EXT_KEY - 1].equals("-e") || !args[OUT_KEY - 1].equals("-o")) {
            throw new Exception("Invalid key! ( <-d> - directory, <-e> - exclude extension, <-o> - output filename)");
        }

        File file = new File(args[DIR_KEY + 1]);
        if (!file.exists() || !file.isDirectory()) {
            throw new Exception("Invalid directory!");
        }
        return true;
    }

    public String directory() {
        return args[DIR_KEY + 1];
    }

    public String exclude() {
        return args[EXT_KEY];
    }

    public String output() {
        return args[OUT_KEY];
    }
}
