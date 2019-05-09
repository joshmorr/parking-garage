package com.example.parkinggarage.model;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Garage {
    private ArrayList<Row> rowsList;
    private String name;

    public Garage(TableLayout tableLayout, String name) {
        this.name = name;
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
                if (!textView.getText().toString().equals("")) {
                    Space space = new Space(i,j);
                    if (textView.getText().toString().equals("M"))
                        space.setCategory(Category.MOTORCYCLE);
                    else if (textView.getText().toString().equals("C"))
                        space.setCategory(Category.CAR);
                    else if (textView.getText().toString().equals("T"))
                        space.setCategory(Category.TRUCK);
                    spacesList.add(space);
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
}
