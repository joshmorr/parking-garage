package com.example.parkinggarage.model;

import java.util.ArrayList;

import static com.example.parkinggarage.model.Type.CAR;

public class Garage {
    private ArrayList<Row> rowsList;
    private int nRows;
    private int nSpacesPerRow;

    public Garage(int nRows, int nSpacesPerRow) {
        this.nRows = nRows;
        this.nSpacesPerRow = nSpacesPerRow;
        initialize();
    }

    private void initialize() {
        rowsList = new ArrayList<Row>(nRows);
        for (int i = 0; i < rowsList.size(); i++) {
            ArrayList<Space> spacesList = new ArrayList<Space>(nSpacesPerRow);
            for (int j = 0; j < spacesList.size(); j++) {
                spacesList.set(j, new Space(CAR));
            }
            rowsList.set(i, new Row(spacesList));
        }
    }

    public ArrayList<Row> getRowsList() {
        return rowsList;
    }

    public void setRowsList(ArrayList<Row> rowsList) {
        this.rowsList = rowsList;
    }

    public int getnRows() {
        return nRows;
    }

    public void setnRows(int nRows) {
        this.nRows = nRows;
    }

    public int getnSpacesPerRow() {
        return nSpacesPerRow;
    }

    public void setnSpacesPerRow(int nSpacesPerRow) {
        this.nSpacesPerRow = nSpacesPerRow;
    }
}
