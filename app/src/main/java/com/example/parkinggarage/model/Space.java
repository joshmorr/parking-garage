package com.example.parkinggarage.model;

public class Space {
    private Category category;
    private Vehicle vehicle;

    public Space() {
        category = null;
        vehicle = null;
    }

    public Space(Category category) {
        this.category = category;
        vehicle = null;
    }

    public boolean isEmpty() {
        return vehicle == null;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
