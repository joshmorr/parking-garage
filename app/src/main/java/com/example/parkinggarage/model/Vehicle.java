package com.example.parkinggarage.model;

public class Vehicle {
    private Type type;
    private String plateNumber;

    public Vehicle(Type type, String plateNumber) {
        this.type = type;
        this.plateNumber = plateNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
