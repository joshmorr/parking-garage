package com.example.parkinggarage.model;

import java.util.ArrayList;

public class Garage {
    private ArrayList<Space> spaces;
    private int totalSpaces;
    private int emptySpaces;

    public Garage() {
        spaces = new ArrayList<Space>();
    }

    public Garage(int totalSpaces) {
        this.totalSpaces = totalSpaces;
        spaces = new ArrayList<Space>(totalSpaces);
        emptySpaces = totalSpaces;
    }



}
