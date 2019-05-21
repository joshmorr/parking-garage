package com.example.parkinggarage.model;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.Timestamp;

import java.time.Instant;
import java.util.ArrayList;

public class Garage {
    private ArrayList<Row> rowsList;
    private String name;
    private PaymentScheme paymentScheme;
    private int nRows;
    private int maxSpaces;
    private int emptyMotorcycleSpaces;
    private int emptyCarSpaces;
    private int emptyTruckSpaces;
    private int occupiedMotorcycleSpaces;
    private int occupiedCarSpaces;
    private int occupiedTruckSpaces;

    public Garage() {
    }

    public Garage(TableLayout tableLayout, String name) {
        this.name = name;
        paymentScheme = new PaymentScheme();
        emptyMotorcycleSpaces = 0;
        emptyCarSpaces = 0;
        emptyTruckSpaces = 0;
        occupiedMotorcycleSpaces = 0;
        occupiedCarSpaces = 0;
        occupiedTruckSpaces = 0;
        create(tableLayout);
    }

    private void create(TableLayout tableLayout) {
        nRows = tableLayout.getChildCount();
        TableRow tableRow = (TableRow) tableLayout.getChildAt(0);
        maxSpaces = tableRow.getChildCount();

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

    public void parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < nRows; i++) {
            Row row = rowsList.get(i);
            for (int j = 0; j < maxSpaces; j++) {
                Space space = row.getSpacesList().get(j);
                if (space.isEmpty() && space.getCategory().equals(vehicle.getCategory())) {
                    vehicle.setRowNum(i+1);
                    vehicle.setSpaceNum(j+1);
                    space.setVehicle(vehicle);
                    if (space.getCategory().equals(Category.MOTORCYCLE)) {
                       occupiedMotorcycleSpaces++;
                       emptyMotorcycleSpaces--;
                    }
                    else if (space.getCategory().equals(Category.CAR)) {
                        occupiedCarSpaces++;
                        emptyMotorcycleSpaces--;
                    }
                    else if (space.getCategory().equals(Category.TRUCK)) {
                        occupiedTruckSpaces++;
                        emptyTruckSpaces--;
                    }
                    return;
                }
            }
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

    public PaymentScheme getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(PaymentScheme paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public int getnRows() {
        return nRows;
    }

    public void setnRows(int nRows) {
        this.nRows = nRows;
    }

    public int getMaxSpaces() {
        return maxSpaces;
    }

    public void setMaxSpaces(int maxSpaces) {
        this.maxSpaces = maxSpaces;
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
