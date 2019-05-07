package com.example.parkinggarage.activities;

import java.lang.Math;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.parkinggarage.R;

public class GarageSetupActivity extends AppCompatActivity {
    static final String TAG = "GarageSetupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_setup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText rowsEditText = findViewById(R.id.rowsEditText);
        final EditText spacesEditText = findViewById(R.id.spacesEditText);

        final TableLayout tableLayout= findViewById(R.id.tableLayout);

        final Button generateButton = findViewById(R.id.generateButton);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int nRows;
                int nSpaces;

                try {
                    nRows = Integer.valueOf(rowsEditText.getText().toString());
                    nSpaces = Integer.valueOf(spacesEditText.getText().toString());
                } catch (NumberFormatException e) {
                    Log.e("GarageSetupActivity", e.toString());
                    return;
                }
                int padding = 25;

                float tableLayoutWidth = (float) tableLayout.getWidth();
                float nSpacesFl = (float) nSpaces;
                int rowWidth = Math.round(tableLayoutWidth / nSpacesFl);

                float tableLayoutHeight = (float) (tableLayout.getHeight() - (padding * nRows));
                float nRowsFl = (float) nRows;
                int rowHeight = Math.round(tableLayoutHeight / nRows);

                tableLayout.removeAllViews();
                for (int i = 0; i < nRows; i++) {
                    TableRow tableRow = new TableRow(getApplicationContext());
                    tableRow.setPadding(0,padding,0,0);
                    for (int j = 0; j < nSpaces; j++) {
                        TextView textView = new TextView(getApplicationContext());
                        textView.setWidth(rowWidth);
                        textView.setHeight(rowHeight);
                        textView.setBackgroundResource(R.drawable.rectangle);
                        textView.setText("C");
                        textView.setGravity(1);
                        tableRow.addView(textView);
                    }
                    tableLayout.addView(tableRow);
                }

            }
        });


    }

}