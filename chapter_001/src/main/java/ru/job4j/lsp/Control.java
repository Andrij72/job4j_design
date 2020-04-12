package ru.job4j.lsp;

import java.awt.*;
import java.util.function.Predicate;

abstract class Control {
    abstract void addFood(Food food);

    abstract boolean accept(Food food);

    abstract void printFoods();

    public void sortFoods(Food food) {
        if (this.accept(food)) {
            this.addFood(food);
        }
    }


}
