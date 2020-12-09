package ru.job4j.lsp.parking;

/**
 * Class ParkingAuto - the class implements parking and accounting of free parking spaces.
 *
 * @author Andrej Kulynych
 * @version 1.0
 * @since 01.01.2020
 */
public class ParkingAuto implements Vehicle, InfoPanel {
    private int carPlace;
    private int trPlace;

    public ParkingAuto(int carPlace, int trPlace) {
        this.carPlace = carPlace;
        this.trPlace = trPlace;
    }

    @Override
    public int getFreePlace(TVehicle vhl) {
        int isFreePlace = 0;
        if (vhl.equals(TVehicle.TRUCK)) {
            if (carPlace >= 2) {
                isFreePlace = trPlace + carPlace / 2;
            }
        } else if (vhl.equals(TVehicle.CAR)) {
            isFreePlace = carPlace;
        }
        return isFreePlace;
    }

    public boolean park(TVehicle vhl) {
        boolean res = false;
        if (vhl.equals(TVehicle.TRUCK) || getFreePlace(TVehicle.TRUCK) != 0) {
            if (trPlace != 0) {
                trPlace = trPlace - 1;
            } else if (carPlace >= 2) {
                carPlace = carPlace - 2;
            }
            res = true;
        }
        if (vhl.equals(TVehicle.CAR)) {
            if (getFreePlace(TVehicle.CAR) != 0) {
                carPlace = carPlace - 1;
                res = true;
            }
        }
        return res;
    }
}
