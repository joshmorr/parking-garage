package com.example.parkinggarage.model;

public class Vehicle {
    private Category category;
    private String plateNumber;

    public Vehicle(Category category, String plateNumber) {
        this.category = category;
        this.plateNumber = plateNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
