package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements  OperationAdd {
    private List<Food> trashFoods = new ArrayList<>();

    public void printFoods() {
        System.out.println("Push in trash: ");
        trashFoods.forEach(System.out::println);
    }

    @Override
    public void addFoods(Food f) {
        trashFoods.add(f);
    }
}
