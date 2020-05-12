package io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFiles extends PrintFiles {
    private List<Path> archived = new ArrayList<>();
    private String xt = "";

    public SearchFiles(String xt) {
        this.xt = xt;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toFile().getName().endsWith(xt)) {
               archived.add(file);
        }

        return FileVisitResult.CONTINUE;
    }

    public List<Path> getArchived() {
        return archived;
    }
}