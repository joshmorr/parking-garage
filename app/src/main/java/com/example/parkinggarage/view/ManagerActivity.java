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
import com.example.parkinggarage.presenter.MainActivityPresenter;
import com.example.parkinggarage.presenter.ManagerActivityPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

public class ManagerActivity extends AppCompatActivity implements ManagerActivityPresenter.View {
    private Manager manager;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(ManagerActivity.this);
        final FirebaseFirestore database = FirebaseFirestore.getInstance();

        final ManagerActivityPresenter presenter = new ManagerActivityPresenter(database, this);

        final String username = getIntent().getExtras().getString("username");
        manager = (Manager) getIntent().getExtras().get("manager");

        intent = new Intent(this, AttendantsListActivity.class);
        intent.putExtra("manager", manager);

        Button attendantsListButton = findViewById(R.id.attendantsButton);
        attendantsListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToAttendantsList(username);
            }
        });

    }

    @Override
    public void startAttendantsListActivity(String username) {
        intent.putExtra("username", username);
        startActivity(intent);
    }
}
