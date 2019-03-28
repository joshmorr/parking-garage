package com.example.parkinggarage.model;

import java.util.ArrayList;

public class Row {
    private ArrayList<Space> spacesList;

    public Row(ArrayList<Space> spacesList) {
        this.spacesList = spacesList;
    }

    public Row(int size) {
        spacesList = new ArrayList<Space>(size);
    }

    public ArrayList<Space> getSpacesList() {
        return spacesList;
    }

    public int getSize() {
        return spacesList.size();
    }
}
