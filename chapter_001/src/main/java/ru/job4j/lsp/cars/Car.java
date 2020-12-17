package ru.job4j.lsp.cars;

public class Car implements FabricaVechile {
    private String name;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private Vehicle vehicle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(Vehicle vehicle) {
        accept(vehicle);
        this.name = "Car";
        vehicle.setSize(1);
    }

    @Override
    public int getSize() {
        return vehicle.getSize();
    }

    @Override
    public void setSize(int size) {
        vehicle.setSize(size);
    }

    @Override
    public void accept(Vehicle vehicle) {

    }
}
