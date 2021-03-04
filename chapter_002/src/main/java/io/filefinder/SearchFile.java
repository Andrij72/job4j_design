package io.filefinder;

import io.SearchFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

/**
 * 1. Create a program to find a file.
 * 2. The program must search for data in the specified directory and subdirectories.
 * 3. The file name can be specified, entirely, by mask, by regular expression (optional).
 * 4. The program must be compiled in jar and run via java -jar find.jar -d = c: / -n = *. Txt -t = mask -o = log.txt
 * (java -jar find.jar -d c:\\Users\\a.kulynych\\WORKING -n * .docx -t mask -o log.txt).
 * Keys:
 * -d - directory where to start searching.
 * -n - file name, mask, or regular expression.
 * -t - search type: mask search by mask, name by full name match.
 * -o - write the result to a file.
 * 5. The program must write the result to a file.
 * 6. The program must have a key validation and a hint.
 *
 * @author A.Kulynych
 */

public class SearchFile {
    private static final Logger LOG = LoggerFactory.getLogger(SearchFiles.class.getName());
    public static StringBuilder buf = new StringBuilder();

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getArchived();
    }

    public static void writeFiles(List<Path> files, String path) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(path)
                ))) {

            files.forEach(f -> buf.append(f + System.lineSeparator()));
            out.write(buf.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Parameters prm = new Parameters(args);
        prm.validateParams();
        Predicate<Path> condition = new FactoryPredicate().conditionSet(prm);

        List<Path> files = search(Path.of(prm.getDir()), condition);
        writeFiles(files, prm.getLog());
        LOG.warn("Var buf:{}", buf);
    }

}
