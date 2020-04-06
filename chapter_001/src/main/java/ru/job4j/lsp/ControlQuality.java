package ru.job4j.lsp;

public class ControlQuality {
    private FoodSeparator foodSeparator;

    public ControlQuality(FoodSeparator foodSeparator) {
        this.foodSeparator = foodSeparator;
    }

    public void sortFoods(Food food) {
        if (foodSeparator.accept(food)) {
            foodSeparator.addFood(food);
        }
    }

    public void print() {
        foodSeparator.printFoods();
    }
}
