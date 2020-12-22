package ru.job4j.lsp.cars;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingAndControlImplTest {

    @Test
    public void whenParkCar1Truck1ThenTrue() {
        ParkingAndControlImpl pk = new ParkingAndControlImpl(2, 1);
        Vehicle truck1 = new Truck(2);
        Vehicle car1 = new Car(1);
        pk.park(car1);
        boolean actual = pk.park(truck1);
        assertThat(actual, is(true));
    }

    @Test
    public void whenParkTruck1Truck2ThenTrue() {
        ParkingAndControlImpl pk = new ParkingAndControlImpl(2, 1);
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(2);
        pk.park(truck1);
        boolean actual = pk.park(truck2);
        assertThat(actual, is(true));
    }

    @Test
    public void whenParkCar1Truck1Truck2ThenFalse() {
        ParkingAndControlImpl pk = new ParkingAndControlImpl(2, 1);
        Vehicle car1 = new Car(1);
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(2);
        pk.park(car1);
        pk.park(truck1);
        boolean actual = pk.park(truck2);
        assertThat(actual, is(false));
    }
}