package ru.job4j.lsp.cars;

public class Car implements Vehicle {
    private int size;

    @Override
    public int size() {
        return size;
    }

    public Car(int size) {
        this.size = size;
    }
}
