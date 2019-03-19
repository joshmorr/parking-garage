package com.example.parkinggarage.model;

public class PaymentScheme {
    private int truckPerHour;
    private int carPerHour;
    private int motorcyclePerHour;

    public PaymentScheme() {

    }

    public PaymentScheme(int truckPerHour, int carPerHour, int motorcyclePerHour) {
        this.truckPerHour = truckPerHour;
        this.carPerHour = carPerHour;
        this.motorcyclePerHour = motorcyclePerHour;
    }

    public int getTruckPerHour() {
        return truckPerHour;
    }

    public void setTruckPerHour(int truckPerHour) {
        this.truckPerHour = truckPerHour;
    }

    public int getCarPerHour() {
        return carPerHour;
    }

    public void setCarPerHour(int carPerHour) {
        this.carPerHour = carPerHour;
    }

    public int getMotorcyclePerHour() {
        return motorcyclePerHour;
    }

    public void setMotorcyclePerHour(int motorcyclePerHour) {
        this.motorcyclePerHour = motorcyclePerHour;
    }
}
