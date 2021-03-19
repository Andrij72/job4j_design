package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 16. Как получить список файлов?
 * Без учета подпапок
 * File file = new File("dir");
 * File[] filesArr = file.listFiles();
 * String[] filesNames = file.list();
 */
public class SmplListFiles {
    public static void main(String[] args) throws IOException {
        final File folder = new File("C:\\Users\\a.kulynych\\WORKING");
        // listFilesForFolder(folder);
        getListDir("C:\\Users\\a.kulynych\\WORKING");

    }

    /**
     * получить список файлов?
     * С учетом подпапок
     *
     * @param folder
     */
    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }

    /**
     * Java NIO без учета подпапок
     */
    public static void getListDir(String dir) throws IOException {
        Stream<Path> stramFiles = Files.list(Paths.get(dir));
        stramFiles.forEach(System.out::println);
    }
}
