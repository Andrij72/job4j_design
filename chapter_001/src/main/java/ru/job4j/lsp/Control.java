package ru.job4j.lsp;

abstract class Control {
    abstract void addFood(Food food);

    abstract boolean accept(Food food);

    abstract void printFoods();
}
