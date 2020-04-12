package ru.job4j.lsp;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WareHouse extends Control {
    List<Food> wareHouse = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        wareHouse.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return (LocalDate.now().getDayOfYear() - food.getCreateDate()
                .getDayOfYear() < 0.25 * food.getExpiryDate()) ? true : false;
    }

    public void printFoods() {
        System.out.println("Ware House contain: ");
        wareHouse.forEach(System.out::println);
    }
}
