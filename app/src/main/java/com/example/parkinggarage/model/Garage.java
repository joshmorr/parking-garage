package com.example.parkinggarage.model;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Garage {
    private ArrayList<ArrayList<Space>> rowsList;

    public Garage(TableLayout tableLayout) {
        create(tableLayout);
    }

    private void create(TableLayout tableLayout) {
        int nRows = tableLayout.getChildCount();
        TableRow row = (TableRow) tableLayout.getChildAt(0);
        int maxSpaces = row.getChildCount();

        rowsList = new ArrayList<>(nRows);
        for (int i = 0; i < nRows; i++) {
            ArrayList<Space> spacesList  = new ArrayList<>(maxSpaces);
            row = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < maxSpaces; j++) {
                TextView textView = (TextView) row.getChildAt(j);
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
            rowsList.add(spacesList);
        }
    }

    public ArrayList<ArrayList<Space>> getRowsList() {
        return rowsList;
    }

    public void setRowsList(ArrayList<ArrayList<Space>> rowsList) {
        this.rowsList = rowsList;
    }
}
