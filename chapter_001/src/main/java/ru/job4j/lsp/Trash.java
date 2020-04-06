package ru.job4j.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trash implements FoodSeparator {
    List<Food> trash = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        trash.add(food);
    }

    @Override
    public boolean accept(Food food) {
       return (LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear() > food.getExpiryDate()) ? true : false;
    }

    public void printFoods() {
        System.out.println("Push in trash: ");
       trash.forEach(System.out::println);
    }
}
