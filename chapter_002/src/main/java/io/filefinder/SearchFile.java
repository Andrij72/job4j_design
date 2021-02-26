package io.filefinder;

import io.EchoServer;
import io.SearchFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * 1. Создать программу для поиска файла.
 * 2. Программа должна искать данные в заданном каталоге и подкаталогах.
 * 3. Имя файла может задаваться, целиком, по маске, по регулярному выражению(не обязательно).
 * 4. Программа должна собираться в jar и запускаться через java -jar find.jar -d=c:/ -n=*.txt -t=mask -o=log.txt
 * Ключи
 * -d - директория, в которой начинать поиск.
 * -n - имя файла, маска, либо регулярное выражение.
 * -t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.
 * -o - результат записать в файл.
 * 5. Программа должна записывать результат в файл.
 * 6. В программе должна быть валидация ключей и подсказка.
 */

public class SearchFile {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(x -> x.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getArchived();
    }



    public static void main(String[] args) throws IOException {
        search(Path.of("./"), "jar").forEach(System.out::println);

    }
}
