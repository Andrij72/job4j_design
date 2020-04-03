package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EvenNumberFile {
    public static void main(String[] args) {

        List<Character> list = new ArrayList<>();
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int rd;
            while ((rd = in.read()) != -1) {
                if (rd % 2 == 0) {
                   char el = (char) rd;
                    list.add(el);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
    }
}

