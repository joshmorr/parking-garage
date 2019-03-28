package com.example.parkinggarage.model;

public class PaymentScheme {
    private double truckEarlyBird;
    private double carEarlyBird;
    private double motorcycleEarlyBird;
    private double truckPerHour;
    private double carPerHour;
    private double motorcyclePerHour;

    public PaymentScheme() {
        setUp();
    }

    private void setUp() {
        truckEarlyBird = 40;
        carEarlyBird = 20;
        motorcycleEarlyBird = 10;
        truckPerHour = 5;
        carPerHour = 2.5;
        motorcyclePerHour = 1;
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

    public double getTruckPerHour() {
        return truckPerHour;
    }

    public void setTruckPerHour(double truckPerHour) {
        this.truckPerHour = truckPerHour;
    }

    public double getCarPerHour() {
        return carPerHour;
    }

    public void setCarPerHour(double carPerHour) {
        this.carPerHour = carPerHour;
    }

    public double getMotorcyclePerHour() {
        return motorcyclePerHour;
    }

    public void setMotorcyclePerHour(double motorcyclePerHour) {
        this.motorcyclePerHour = motorcyclePerHour;
    }
}
