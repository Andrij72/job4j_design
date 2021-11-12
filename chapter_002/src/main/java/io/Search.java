package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * For searching input parameters:   D:\projects\job4j_design\  .java
 */
public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "Root folder or file extend are null. Usage java -jar dir.jar ROOT_FOLDER and FILE_EXTEND");
        }

        search(Paths.get(args[0]), args[1]).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(x -> x.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getArchived();
    }
}
