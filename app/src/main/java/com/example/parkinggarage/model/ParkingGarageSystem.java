package com.example.parkinggarage.model;

import java.util.HashMap;

public class ParkingGarageSystem {
    private Garage garage;
    private PaymentScheme scheme;
    private Accounts attendants;
    private double moneyMade;

    public ParkingGarageSystem() {
        garage = new Garage(1, 2);
        scheme = new PaymentScheme();
    }

    public void setUpSampleSystem() {

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

    public double getMoneyMade() {
        return moneyMade;
    }

    public void setMoneyMade(double moneyMade) {
        this.moneyMade = moneyMade;
    }
}
