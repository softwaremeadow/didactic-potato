package com.codegym.task.task29.task2909.car;

public class Sedan extends Car {
    private int numberOfPassengers;

    public Sedan(int numberOfPassengers) {
        super(1, numberOfPassengers);
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
