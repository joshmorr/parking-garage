package com.example.parkinggarage.model;

import java.util.ArrayList;

public class Row {
    private ArrayList<Space> spacesList;

    public Row() {
    }

    public Row(ArrayList<Space> spacesList) {
        this.spacesList = spacesList;
    }

    public ArrayList<Space> getSpacesList() {
        return spacesList;
    }

    public void setSpacesList(ArrayList<Space> spacesList) {
        this.spacesList = spacesList;
    }
}
