package com.example.parkinggarage.model;

import java.util.HashMap;

public class ParkingGarageSystem {
    private Garage garage;
    private PaymentScheme scheme;
    private HashMap<String, Account> accounts;
    private double moneyMade;

    public ParkingGarageSystem() {
        garage = new Garage();
        scheme = new PaymentScheme();
    }

    public ParkingGarageSystem(int size, PaymentScheme scheme) {
        garage = new Garage(size);
        this.scheme = scheme;
        accounts = new HashMap<String, Account>();
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

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }
}
