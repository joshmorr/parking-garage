package com.example.parkinggarage.model;

public class PaymentScheme {
    private double truckEarlyBird;
    private double carEarlyBird;
    private double motorcycleEarlyBird;
    private double truckHourly;
    private double carHourly;
    private double motorcycleHourly;

    public PaymentScheme() {
        setUp();
    }

    private void setUp() {
        truckEarlyBird = 40;
        carEarlyBird = 20;
        motorcycleEarlyBird = 10;
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

    public double getTruckEarlyBird() {
        return truckEarlyBird;
    }

    public void setTruckEarlyBird(double truckEarlyBird) {
        this.truckEarlyBird = truckEarlyBird;
    }

    public double getCarEarlyBird() {
        return carEarlyBird;
    }

    public void setCarEarlyBird(double carEarlyBird) {
        this.carEarlyBird = carEarlyBird;
    }

    public double getMotorcycleEarlyBird() {
        return motorcycleEarlyBird;
    }

    public void setMotorcycleEarlyBird(double motorcycleEarlyBird) {
        this.motorcycleEarlyBird = motorcycleEarlyBird;
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
