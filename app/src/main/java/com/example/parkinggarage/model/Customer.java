package com.example.parkinggarage.model;

public class Customer extends Person {
    private Vehicle vehicle;

    public Customer(String firstname, String lastname, Category category, String plateNumber) {
        super(firstname, lastname);
        vehicle = new Vehicle(category, plateNumber);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
