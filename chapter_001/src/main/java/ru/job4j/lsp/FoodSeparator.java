package ru.job4j.lsp;

public interface FoodSeparator {

    void addFood(Food food);

    boolean accept(Food food);

    void printFoods();
}
