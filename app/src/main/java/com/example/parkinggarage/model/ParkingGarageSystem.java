package com.example.parkinggarage.model;

import java.util.HashMap;

public class ParkingGarageSystem {
    private Garage garage;
    private PaymentScheme scheme;
    private Accounts attendants;

    public ParkingGarageSystem() {
        garage = new Garage(1, 2);
        scheme = new PaymentScheme();
    }

    public ParkingGarageSystem(Garage garage) {
        this.garage = garage;

    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public PaymentScheme getScheme() {
        return scheme;
    }

    public void setScheme(PaymentScheme scheme) {
        this.scheme = scheme;
    }

    public Accounts getAttendants() {
        return attendants;
    }

    public void setAttendants(Accounts attendants) {
        this.attendants = attendants;
    }

}
