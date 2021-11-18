package ru.job4j.lsp.cars;

public class ParkingAndControlImpl implements Parking, ControlParking {
    private int carPlace;
    private int trPlace;
    /**
     * this constant is the size of the car parking lot is
     */
    private static final int CAR_SIZE_PLACE = 1;


    public ParkingAndControlImpl(int carPlace, int trPlace) {
        this.carPlace = carPlace;
        this.trPlace = trPlace;
    }

    @Override
    public int getQuantityFreePlaces(Vehicle vcl) {
        int isFreePlace = 0;
        int carSizeForTruck = carPlace * CAR_SIZE_PLACE;

        if (carPlace != 0 && vcl.size() <= CAR_SIZE_PLACE) {
            isFreePlace = carPlace;
        } else if (vcl.size() > CAR_SIZE_PLACE && trPlace != 0) {
            isFreePlace = trPlace;
        } else if (vcl.size() > CAR_SIZE_PLACE && trPlace == 0) {
            if (vcl.size() <= carSizeForTruck) {
                isFreePlace = carSizeForTruck / vcl.size();
            }
        }
        return isFreePlace;
    }

    @Override
    public boolean park(Vehicle vcl) {
        /**
         * for trucks,if there is a shortage of cargo areas,
         * select the number of carspaceces according to the truck size
         */
        boolean res = false;

        if (vcl.size() <= CAR_SIZE_PLACE && getQuantityFreePlaces(vcl) != 0) {
            carPlace -= 1;
            res = true;
        } else if (vcl.size() > CAR_SIZE_PLACE && getQuantityFreePlaces(vcl) != 0) {
            trPlace -= 1;
            res = true;
        } else if (vcl.size() > CAR_SIZE_PLACE && getQuantityFreePlaces(vcl) == 0) {
            int tmp = getQuantityFreePlaces(new Car(CAR_SIZE_PLACE)) * CAR_SIZE_PLACE;
            if (vcl.size() <= tmp) {
                carPlace -= tmp / CAR_SIZE_PLACE;
                res = true;
            }
        }
        return res;
    }
}
