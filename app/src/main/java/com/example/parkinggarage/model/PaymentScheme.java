package com.example.parkinggarage.model;

public class PaymentScheme {
    private double truckHourly;
    private double carHourly;
    private double motorcycleHourly;

    public PaymentScheme() {
        setUp();
    }

    private void setUp() {
        truckHourly = 5;
        carHourly = 2.5;
        motorcycleHourly = 1;
    }

    public double getRate(Category category) {
        if (category.equals(Category.MOTORCYCLE))
            return motorcycleHourly;
        if (category.equals(Category.CAR))
            return carHourly;
        if (category.equals(Category.TRUCK))
            return truckHourly;
        return -1;
    }

    public double getTruckHourly() {
        return truckHourly;
    }

    public void setTruckHourly(double truckHourly) {
        this.truckHourly = truckHourly;
    }

    public double getCarHourly() {
        return carHourly;
    }

    public void setCarHourly(double carHourly) {
        this.carHourly = carHourly;
    }

    public double getMotorcycleHourly() {
        return motorcycleHourly;
    }

    public void setMotorcycleHourly(double motorcycleHourly) {
        this.motorcycleHourly = motorcycleHourly;
    }
}
