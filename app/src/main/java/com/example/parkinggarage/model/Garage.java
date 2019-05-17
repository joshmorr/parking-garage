package com.example.parkinggarage.model;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Observable;

public class Garage {
    private ArrayList<Row> rowsList;
    private String name;
    private int emptyMotorcycleSpaces;
    private int emptyCarSpaces;
    private int emptyTruckSpaces;
    private int occupiedMotorcycleSpaces;
    private int occupiedCarSpaces;
    private int occupiedTruckSpaces;


    public Garage(TableLayout tableLayout, String name) {
        this.name = name;
        emptyMotorcycleSpaces = 0;
        emptyCarSpaces = 0;
        emptyTruckSpaces = 0;
        occupiedMotorcycleSpaces = 0;
        occupiedCarSpaces = 0;
        occupiedTruckSpaces = 0;
        create(tableLayout);
    }

    private void create(TableLayout tableLayout) {
        int nRows = tableLayout.getChildCount();
        TableRow tableRow = (TableRow) tableLayout.getChildAt(0);
        int maxSpaces = tableRow.getChildCount();

        rowsList = new ArrayList<>(nRows);
        for (int i = 0; i < nRows; i++) {
            ArrayList<Space> spacesList  = new ArrayList<>(maxSpaces);
            tableRow = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < maxSpaces; j++) {
                TextView textView = (TextView) tableRow.getChildAt(j);
                String categoryStr = textView.getText().toString();
                if (!categoryStr.equals("")) {
                    spacesList.add(new Space(categoryStr, i + 1, j + 1));
                    if (categoryStr.equals("M"))
                        emptyMotorcycleSpaces++;
                    else if (categoryStr.equals("C"))
                        emptyCarSpaces++;
                    else if (categoryStr.equals("T"))
                        emptyTruckSpaces++;
                }
            }
            Row row = new Row(spacesList);
            rowsList.add(row);
        }
    }

    public ArrayList<Row> getRowsList() {
        return rowsList;
    }

    public void setRowsList(ArrayList<Row> rowsList) {
        this.rowsList = rowsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmptyMotorcycleSpaces() {
        return emptyMotorcycleSpaces;
    }

    public void setEmptyMotorcycleSpaces(int emptyMotorcycleSpaces) {
        this.emptyMotorcycleSpaces = emptyMotorcycleSpaces;
    }

    public int getEmptyCarSpaces() {
        return emptyCarSpaces;
    }

    public void setEmptyCarSpaces(int emptyCarSpaces) {
        this.emptyCarSpaces = emptyCarSpaces;
    }

    public int getEmptyTruckSpaces() {
        return emptyTruckSpaces;
    }

    public void setEmptyTruckSpaces(int emptyTruckSpaces) {
        this.emptyTruckSpaces = emptyTruckSpaces;
    }

    public int getOccupiedMotorcycleSpaces() {
        return occupiedMotorcycleSpaces;
    }

    public void setOccupiedMotorcycleSpaces(int occupiedMotorcycleSpaces) {
        this.occupiedMotorcycleSpaces = occupiedMotorcycleSpaces;
    }

    public int getOccupiedCarSpaces() {
        return occupiedCarSpaces;
    }

    public void setOccupiedCarSpaces(int occupiedCarSpaces) {
        this.occupiedCarSpaces = occupiedCarSpaces;
    }

    public int getOccupiedTruckSpaces() {
        return occupiedTruckSpaces;
    }

    public void setOccupiedTruckSpaces(int occupiedTruckSpaces) {
        this.occupiedTruckSpaces = occupiedTruckSpaces;
    }
}
