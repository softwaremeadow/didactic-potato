package com.codegym.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    public final int MAX_TRUCK_SPEED = 80;
    public final int MAX_SEDAN_SPEED = 120;
    public final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfGallons) throws Exception {
        if (numberOfGallons < 0) {
            throw new Exception();
        }
        fuel += numberOfGallons;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        double consumption;
        if (!isSummer(date, summerStart, summerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersThatCanBeCarried() {
        if (!canPassengersBeCarried()) {
            return 0;
        }
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengerBelts();
        }
    }

    public void fastenPassengerBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers) {
        Car car = null;
        if (type == TRUCK) {
            car = new Truck(numberOfPassengers);
        } else if (type == SEDAN) {
            car = new Sedan(numberOfPassengers);
        } else if (type == CABRIOLET) {
            car = new Cabriolet(numberOfPassengers);
        }
        return car;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {
        if (!date.before(summerStart) && !date.after(summerEnd)) {
            return true;
        } else {
            return false;
        }
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    private boolean canPassengersBeCarried() {
        if (isDriverAvailable() && fuel > 0.0) {
            return true;
        }
        return false;
    }
}