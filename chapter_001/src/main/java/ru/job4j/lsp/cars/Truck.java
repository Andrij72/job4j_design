package ru.job4j.lsp.cars;


public class Truck implements Vehicle {
    private int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;

    }
}
