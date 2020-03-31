package ru.job4j.lsp;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


public class WareHouse implements OperationAdd {
    private List<Food> warehouseFoods = new ArrayList<>();

    public void printFoods() {
        System.out.println("Ware House contain: ");
        warehouseFoods.forEach(System.out::println);
    }

    @Override
    public void addFoods(Food f) {
        warehouseFoods.add(f);
    }
}
