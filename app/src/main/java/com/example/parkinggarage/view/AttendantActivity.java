package com.example.parkinggarage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Vehicle;
import com.example.parkinggarage.presenter.AttendantActivityPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

public class AttendantActivity extends AppCompatActivity implements AttendantActivityPresenter.View {
    private ArrayAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(AttendantActivity.this);
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        listView = findViewById(R.id.listView);

        Attendant attendant = (Attendant) getIntent().getExtras().get("attendant");
        final Intent parkIntent = new Intent(this, ParkActivity.class);
        parkIntent.putExtra("attendant", attendant);

        AttendantActivityPresenter presenter = new AttendantActivityPresenter(database, this);

        presenter.getParkedVehiclesList(attendant.getGarageId());

        Button parkButton = findViewById(R.id.parkButton);
        parkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(parkIntent);
            }
        });

    }

    @Override
    public void setListAdapter(String[] array) {
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, array);
        listView.setAdapter(adapter);
    }
}
