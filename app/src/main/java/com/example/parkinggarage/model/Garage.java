package com.example.parkinggarage.model;

import java.util.ArrayList;

public class Garage {
    private Manager manager;
    private PaymentScheme scheme;
    private ArrayList<ArrayList<Space>> spaces;

    public Garage(PaymentScheme scheme) {
        this.scheme = scheme;
        setUpSampleGarage();
    }

    public Garage(Manager manager, PaymentScheme scheme) {
        this.manager = manager;
        this.scheme = scheme;
        setUpSampleGarage();
    }

    public Space getSpace(int rowNum, int spaceNum) {
        return spaces.get(rowNum).get(spaceNum);
    }

    private void setUpSampleGarage() {
        int nRows = 10;
        int nSpaces = 20;

        ArrayList<ArrayList<Space>> rowsList = new ArrayList<>(nRows);
        for (int i = 0; i < nRows; i++) {
            ArrayList<Space> spacesList = new ArrayList<>(nSpaces);
            for (int j = 0; j < nSpaces; j++) {
                spacesList.add(new Space(i, j, Category.CAR));
            }
        }
        spaces = rowsList;
    }

    public PaymentScheme getScheme() {
        return scheme;
    }

    public void setScheme(PaymentScheme scheme) {
        this.scheme = scheme;
    }

    public ArrayList<ArrayList<Space>> getSpaces() {
        return spaces;
    }

    public void setSpaces(ArrayList<ArrayList<Space>> spaces) {
        this.spaces = spaces;
    }
}
