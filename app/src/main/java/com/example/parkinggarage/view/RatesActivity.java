package com.example.parkinggarage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Manager;
import com.example.parkinggarage.presenter.RatesActivityPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

public class RatesActivity extends AppCompatActivity implements RatesActivityPresenter.View {
    private FirebaseFirestore database;
    private Manager manager;
    private RatesActivityPresenter presenter;
    private Intent intent;
    private EditText motorcycleEditText;
    private EditText carEditText;
    private EditText truckEditText;
    private Button setRatesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(RatesActivity.this);
        database = FirebaseFirestore.getInstance();

        manager = (Manager) getIntent().getExtras().get("manager");

        intent = new Intent(this, ManagerActivity.class);
        intent.putExtra("manager", manager);

        presenter = new RatesActivityPresenter(database, this, manager);




    }

}
