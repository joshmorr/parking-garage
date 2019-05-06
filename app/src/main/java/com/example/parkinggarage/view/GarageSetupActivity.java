package com.example.parkinggarage.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parkinggarage.R;

public class GarageSetupActivity extends AppCompatActivity {
    static final String TAG = "GarageSetupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_setup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SpaceButtonFactory spaceButtonFactory = new SpaceButtonFactory();

        final EditText rowsEditText = findViewById(R.id.rowsEditText);
        final EditText spacesEditText = findViewById(R.id.spacesEditText);

        final Button generateButton = findViewById(R.id.generateButton);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
