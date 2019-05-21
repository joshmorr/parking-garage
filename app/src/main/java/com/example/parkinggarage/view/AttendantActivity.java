package com.example.parkinggarage.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Vehicle;
import com.example.parkinggarage.presenter.AttendantActivityPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AttendantActivity extends AppCompatActivity implements AttendantActivityPresenter.View {
    private FirebaseFirestore database;
    private ArrayAdapter adapter;
    private ListView listView;
    private Intent parkIntent;
    private Intent receiptIntent;
    private Attendant attendant;
    private AttendantActivityPresenter presenter;
    private Button parkButton;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(AttendantActivity.this);
        database = FirebaseFirestore.getInstance();

        parkButton = findViewById(R.id.parkButton);
        listView = findViewById(R.id.listView);

        attendant = (Attendant) getIntent().getExtras().get("attendant");
        parkIntent = new Intent(this, ParkActivity.class);
        receiptIntent = new Intent(this, ReceiptActivity.class);
        parkIntent.putExtra("attendant", attendant);
        receiptIntent.putExtra("attendant", attendant);

        presenter = new AttendantActivityPresenter(database, attendant, this);
        presenter.getParkedVehicles();

        parkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.park();
            }
        });

        builder = new AlertDialog.Builder(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Vehicle vehicle = (Vehicle) listView.getItemAtPosition(position);
                        vehicle.setTimeRetrieved(Timestamp.now());
                        presenter.retrieve(vehicle);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setTitle("Retrieve Vehicle?").create().show();
            }
        });

    }

    @Override
    public void setListAdapter(ArrayList<Vehicle> vehiclesList) {
        adapter = new ArrayAdapter<>(this, R.layout.list_item, vehiclesList);
        listView.setAdapter(adapter);
    }

    @Override
    public void startParkActivity() {
        startActivity(parkIntent);
    }

    @Override
    public void startReceiptActivity(Vehicle vehicle) {
        receiptIntent.putExtra("vehicle", vehicle);
        startActivity(receiptIntent);
    }
}
