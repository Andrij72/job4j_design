package ru.job4j.lsp;

import java.time.LocalDate;
import java.util.List;

public class DemoSortProduct {

    public static void main(String[] args) {
        ControlQuality controller1 = new ControlQuality(new Shop());
        ControlQuality controller2 = new  ControlQuality(new WareHouse());
        ControlQuality controller3 = new  ControlQuality(new Trash());

        List<Food> receivedFoods = List.of(
                new Food("banana", 9, LocalDate.of(2020, 04, 02), 3.0, 0),
                new Food("cherry", 3, LocalDate.of(2020, 04, 02), 4.0, 0),
                new Food("potato", 30, LocalDate.of(2020, 04, 02), 6.0, 0),
                new Food("tomato", 5, LocalDate.of(2020, 04, 02), 6.0, 0)
        );

        receivedFoods.forEach(controller1::sortFoods);
        receivedFoods.forEach(controller2::sortFoods);
        receivedFoods.forEach(controller3::sortFoods);
        controller1.print();
        controller2.print();
        controller3.print();
    }
}
