package ru.job4j.lsp.cars;


public class Truck implements FabricaVechile {
    private String name;
   private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Truck(Vehicle vehicle) {
        accept(vehicle);
        this.name = "truck";
        vehicle.setSize(2);
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
