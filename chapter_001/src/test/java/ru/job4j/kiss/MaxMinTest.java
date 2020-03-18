package ru.job4j.kiss;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void max() {
            List<Integer> list = new LinkedList<>();
            list.add(-1);
            list.add(4);
            list.add(-5);
            list.add(1);
            int res = new MaxMin().max(list, Collections.reverseOrder());
            System.out.println("Max val: "
                    + res);
            assertThat(res, Is.is(-5));
        }

    @Test
    public void min() {
        List<Integer> list = new LinkedList<>();
        list.add(-1);
        list.add(4);
        list.add(-5);
        list.add(1);
        int res = new MaxMin().min(list, Comparator.reverseOrder());
        System.out.println("Min val: "
                + res);
        assertThat(res, Is.is(4));
    }
}
