package ru.job4j.lsp;

public class ControlQuality {
    private Control control;

    public ControlQuality(Control store) {
        control = store;
    }

    public void sortFoods(Food food) {
        if (control.accept(food)) {
            control.addFood(food);
        }
    }

    public void print() {
        control.printFoods();
    }
}
