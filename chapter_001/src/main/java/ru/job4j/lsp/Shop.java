package ru.job4j.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shop implements FoodSeparator {
    List<Food> shop = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        shop.add(food);
    }

    @Override
    public boolean accept(Food food) {
        boolean res = false;
        if (LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear() > 0.25 * food.getExpiryDate()
                && LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear() < 0.75 * food.getExpiryDate()) {
            res = true;
        } else if (LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear() > 0.75 * food.getExpiryDate()
                && LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear() <= food.getExpiryDate()) {
            food.setDiscount(10);
            res = true;
        }
        return res;
    }

    @Override
    public void printFoods() {
        System.out.println("Shop Foods: ");
        shop.forEach(System.out::println);
    }
}
