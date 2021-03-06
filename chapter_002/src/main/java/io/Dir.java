package io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("D:\\projects\\job4j\\");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s ", file.getAbsolutePath()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsolutePath()));
        }

        for (File subfile : file.listFiles()) {
            System.out.print(String.format(" filename: %s ", subfile.getName()));
            System.out.println(String.format("|size: %s ", subfile.length()));
        }
    }
}
