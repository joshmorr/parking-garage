package com.example.parkinggarage.model;

public class Manager extends Employee {
    private Garage garage;

    public Manager(Garage garage, InputFields input) {
        super(input);
        this.garage = garage;
    }
    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

}
