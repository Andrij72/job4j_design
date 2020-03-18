package ru.job4j.kiss;

import java.util.*;
import java.util.function.Predicate;


public class MaxMin {

    public <T> T findBy(List<T> value, Comparator<T> comparator, Predicate<Integer> pr) {
        Iterator<T> itr = value.iterator();
        T vFind = itr.next();
        while (itr.hasNext()) {
            T next = itr.next();
            int resComp = comparator.compare(next, vFind);
            if (pr.test(resComp)) {
                vFind = next;
            }
        }
        return vFind;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findBy(value, comparator, pr -> pr > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findBy(value, comparator, pr -> pr < 0);
    }

}
