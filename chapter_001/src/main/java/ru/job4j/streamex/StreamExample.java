package ru.job4j.streamex;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class StreamExample {
    /**
     * Пример № 2
     * Нахождение максимального значения исключая null значения
     */
    public static void main(String[] args) {
        ArrayList<Integer> testValuesNull = new ArrayList();
        testValuesNull.add(0, null);
        testValuesNull.add(1, 1);
        testValuesNull.add(2, 2);
        testValuesNull.add(3, 70);
        testValuesNull.add(4, 50);

        Optional<Integer> maxValueNotNull = testValuesNull.stream().filter((p) -> p != null).max(Integer::compareTo);
      final AtomicInteger x = new AtomicInteger(0);
        maxValueNotNull.ifPresent(integer -> x.set(integer.intValue()));
        System.out.println("maxValueNotNull=" + x);
    }

}
