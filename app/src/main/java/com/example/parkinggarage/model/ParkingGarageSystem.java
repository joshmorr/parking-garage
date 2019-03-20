package com.example.parkinggarage.model;

import java.util.HashMap;

public class ParkingGarageSystem {
    private Garage garage;
    private PaymentScheme scheme;
    private Accounts accounts;
    private double moneyMade;

    public ParkingGarageSystem() {
        garage = new Garage();
        scheme = new PaymentScheme();
        accounts = new Accounts();
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

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }
}
