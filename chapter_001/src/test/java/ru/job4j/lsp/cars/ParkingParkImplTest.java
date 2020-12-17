package ru.job4j.lsp.cars;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParkingParkImplTest {


    @Test
    public void whenParkTruck1Truck2ThanTrue() {
        FabricaVechile truck1 = new Truck(new VehicleImpl());
        FabricaVechile truck2 = new Truck(new VehicleImpl());
        ParkingPark parkingPark = new ParkingParkImpl(2, 1);
        parkingPark.park(truck1);
        assertThat(parkingPark.park(truck2), is(true));
    }

    @Test
    public void whenParkCar1Car2ThanTrue() {
        FabricaVechile car1 = new Car(new VehicleImpl());
        FabricaVechile car2 = new Car(new VehicleImpl());
        ParkingPark parkingPark = new ParkingParkImpl(2, 0);
        parkingPark.park(car1);
        assertThat(parkingPark.park(car2), is(true));
    }

    @Test
    public void whenParkTruck1Truck2Car1ThanFalse() {
        FabricaVechile truck1 = new Truck(new VehicleImpl());
        FabricaVechile truck2 = new Truck(new VehicleImpl());
        FabricaVechile car1 = new Car(new VehicleImpl());
        ParkingPark parkingPark = new ParkingParkImpl(2, 1);
        parkingPark.park(truck1);
        parkingPark.park(truck2);
        assertThat(parkingPark.park(car1), is(false));
    }

}