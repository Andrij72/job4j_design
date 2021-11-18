package ru.job4j.lsp.parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParkingAutoTest {

    @Test
    public void whenParkTruck1Truck2ThanTrue() {
        TVehicle truck1 = TVehicle.TRUCK;
        TVehicle car1 = TVehicle.CAR;
        ParkingAuto parkingAuto = new ParkingAuto(4, 1);
        parkingAuto.park(truck1);
        boolean result = parkingAuto.park(car1);
        assertThat(result, is(true));
    }

    @Test
    public void whenParkTruck1Truck2Car1Car2ThanTrue() {
        TVehicle truck1 = TVehicle.TRUCK;
        TVehicle truck2 = TVehicle.TRUCK;
        TVehicle car1 = TVehicle.CAR;
        TVehicle car2 = TVehicle.CAR;
        ParkingAuto parkingAuto = new ParkingAuto(4, 1);
        parkingAuto.park(truck1);

        parkingAuto.park(car1);
        boolean result = parkingAuto.park(car2);
        assertThat(result, is(true));
    }

    @Test
    public void whenParkTruck1Truck2Car1Car2Car3ThanFalse() {
        TVehicle truck1 = TVehicle.TRUCK;
        TVehicle truck2 = TVehicle.TRUCK;
        TVehicle car1 = TVehicle.CAR;
        TVehicle car2 = TVehicle.CAR;
        TVehicle car3 = TVehicle.CAR;
        ParkingAuto parkingAuto = new ParkingAuto(2, 1);
        parkingAuto.park(truck1);
        parkingAuto.park(truck2);
        boolean result = parkingAuto.park(car3);
        assertThat(result, is(false));
    }

}