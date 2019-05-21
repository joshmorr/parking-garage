package com.example.parkinggarage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Manager;
import com.example.parkinggarage.presenter.ManagerActivityPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.Future;

public class ManagerActivity extends AppCompatActivity implements ManagerActivityPresenter.View {
    private FirebaseFirestore database;
    private Manager manager;
    private ManagerActivityPresenter presenter;
    private Intent attendantsListIntent;
    private Intent ratesIntent;
    private TextView motorcycleEmpty;
    private TextView carEmpty;
    private TextView truckEmpty;
    private TextView motorcycleOccupied;
    private TextView carOccupied;
    private TextView truckOccupied;
    private TextView motorcycleRate;
    private TextView carRate;
    private TextView truckRate;
    private Button attendantsListButton;
    private Button setRatesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(ManagerActivity.this);
        database = FirebaseFirestore.getInstance();

        presenter = new ManagerActivityPresenter(database, this);

        final String username = getIntent().getExtras().getString("username");
        manager = (Manager) getIntent().getExtras().get("manager");

        attendantsListIntent = new Intent(this, AttendantsListActivity.class);
        attendantsListIntent.putExtra("manager", manager);

        ratesIntent = new Intent(this, RatesActivity.class);
        ratesIntent.putExtra("manager", manager);

        motorcycleEmpty = findViewById(R.id.motorcycleEmpty);
        carEmpty = findViewById(R.id.carEmpty);
        truckEmpty = findViewById(R.id.truckEmpty);
        motorcycleOccupied = findViewById(R.id.motorcycleOccupied);
        carOccupied = findViewById(R.id.carOccupied);
        truckOccupied = findViewById(R.id.truckOccupied);
        motorcycleRate = findViewById(R.id.motorcycleRate);
        carRate = findViewById(R.id.carRate);
        truckRate = findViewById(R.id.truckRate);
        attendantsListButton = findViewById(R.id.attendantsButton);
        setRatesButton = findViewById(R.id.ratesButton);

        presenter.getGarageData(manager);

        attendantsListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToAttendantsList(username);
            }
        });

        setRatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setRates();
            }
        });

    }

    @Override
    public void setEmptyMotorcycleSpaces(int n) {
        motorcycleEmpty.setText(String.valueOf(n));
    }

    @Override
    public void setEmptyCarSpaces(int n) {
        carEmpty.setText(String.valueOf(n));
    }

    @Override
    public void setEmptyTruckSpaces(int n) {
        truckEmpty.setText(String.valueOf(n));
    }

    @Override
    public void setOccupiedMotorcycleSpaces(int n) {
        motorcycleOccupied.setText(String.valueOf(n));
    }

    @Override
    public void setOccupiedCarSpaces(int n) {
        carOccupied.setText(String.valueOf(n));
    }

    @Override
    public void setOccupiedTruckSpaces(int n) {
        truckOccupied.setText(String.valueOf(n));
    }

    @Override
    public void setMotorcycleRate(double rate) {
        motorcycleRate.setText(String.format("$%.2f / hour", rate));
    }

    @Override
    public void setCarRate(double rate) {
        carRate.setText(String.format("$%.2f / hour", rate));
    }

    @Override
    public void setTruckRate(double rate) {
        truckRate.setText(String.format("$%.2f / hour", rate));
    }

    @Override
    public void startAttendantsListActivity(String username) {
        attendantsListIntent.putExtra("username", username);
        startActivity(attendantsListIntent);
    }

    @Override
    public void startRatesActivity() {
        startActivity(ratesIntent);
    }
}
