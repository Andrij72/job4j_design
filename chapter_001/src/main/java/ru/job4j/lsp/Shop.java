package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements OperationAdd {
    private List<Food> shopFoods = new ArrayList<>();

    public void printFoods() {
        System.out.println("Shop contains: ");
        shopFoods.forEach(System.out::println);
    }

    @Override
    public void addFoods(Food f) {
        shopFoods.add(f);
    }
}
