package ru.job4j.lsp;

import java.time.LocalDate;
import java.util.List;

public class ControlQuality {

    public static void sortFoods(List<Food> foods) {
        WareHouse wH = new WareHouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        for (Food el : foods) {
            double deltaD = LocalDate.now().getDayOfYear() - el.getCreateDate().getDayOfYear();
            double deltaMin = 0.25 * el.getExpiryDate();
            double deltaMax = 0.75 * el.getExpiryDate();
            if (deltaD < deltaMin) {
                wH.addFoods(el);
            } else if (deltaD > deltaMin && deltaD < deltaMax) {
                shop.addFoods(el);
            } else if (deltaD > deltaMax && deltaD <= el.getExpiryDate()) {
                el.setDiscount(10);
                shop.addFoods(el);
            } else if (deltaD > el.getExpiryDate()) {
                trash.addFoods(el);
            }
        }
        wH.printFoods();
        shop.printFoods();
        trash.printFoods();
    }

    public static void main(String[] args) {
        List<Food> receivedFoods = List.of(
                new Food("banana", 10, LocalDate.of(2020, 03, 26), 3.0, 0),
                new Food("cherry", 3, LocalDate.of(2020, 03, 26), 4.0, 0),
                new Food("potato", 30, LocalDate.of(2020, 03, 26), 6.0, 0),
        new Food("tomato", 6, LocalDate.of(2020, 03, 26), 6.0, 0)
        );
        sortFoods(receivedFoods);
    }
}
