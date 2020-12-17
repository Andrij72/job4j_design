package ru.job4j.lsp.cars;

public class ParkingParkImpl implements ParkingPark {
    private int carPlace;
    private int trPlace;

    public ParkingParkImpl(int carPlace, int trPlace) {
        this.carPlace = carPlace;
        this.trPlace = trPlace;
    }

    @Override
    public int getFreePlace(FabricaVechile vhl) {
        int isFreePlace = 0;

        if (vhl.getSize() == 2) {
            if (carPlace >= 2) {
                isFreePlace = trPlace + carPlace / 2;
            }
        } else if (vhl.getSize() == 1) {
            isFreePlace = carPlace;
        }
        return isFreePlace;
    }

    @Override
    public boolean park(FabricaVechile vhl) {
        boolean res = false;
        if (vhl.getSize() == 2 || getFreePlace(vhl) != 0) {
            trPlace = trPlace - 1;
        } else if (carPlace >= 2) {
            carPlace = carPlace - 2;
        }
        res = true;

        if (vhl.getSize() == 1 || getFreePlace(vhl) != 0) {
            carPlace = carPlace - 1;
            res = true;
        }
        return res;
    }
}
