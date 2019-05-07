package com.example.parkinggarage.model;

public class Manager extends Employee {
    private Garage garage;

    public Manager(Garage garage, String firstname, String lastname, String username, String password) {
        super(firstname, lastname, username, password);
        this.garage = garage;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public boolean isManager() {
        return true;
    }
}
