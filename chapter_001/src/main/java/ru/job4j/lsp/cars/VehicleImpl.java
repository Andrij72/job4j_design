package ru.job4j.lsp.cars;

public class VehicleImpl implements Vehicle {
   private  int size;
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
       this.size = size;
    }
}
