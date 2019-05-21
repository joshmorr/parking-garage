package com.example.parkinggarage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Vehicle;
import com.example.parkinggarage.presenter.TicketActivityPresenter;

public class TicketActivity extends AppCompatActivity implements TicketActivityPresenter.View {
    private Vehicle vehicle;
    private Attendant attendant;
    private CoordinatorLayout coordinatorLayout;
    private TextView dataTextView;
    private TextView labelsTextView;
    private Button printButton;
    private Button finishButton;
    private Snackbar snackbar;
    private Intent intent;
    private TicketActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        dataTextView = findViewById(R.id.dataTextView);
        dataTextView = findViewById(R.id.dataTextView);
        labelsTextView = findViewById(R.id.labelsTextView);
        printButton = findViewById(R.id.printButton);
        finishButton = findViewById(R.id.finishButton);
        snackbar = Snackbar.make(coordinatorLayout, "The ticket has been sent to the printer.", Snackbar.LENGTH_SHORT);

        vehicle = (Vehicle) getIntent().getExtras().get("vehicle");
        attendant = (Attendant) getIntent().getExtras().get("attendant");

        intent = new Intent(this, AttendantActivity.class);

        presenter = new TicketActivityPresenter(vehicle, attendant, this);
        presenter.setLabels();
        presenter.setData();

        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.printButtonClick();
            }
        });
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.finish();
            }
        });
    }

    @Override
    public void setLabels(String labels) {
        labelsTextView.setText(labels);
    }

    @Override
    public void setData(String data) {
        dataTextView.setText(data);
    }

    @Override
    public void showSnackbar() {
        snackbar.show();
    }

    @Override
    public void startAttendantActivity() {
        startActivity(intent);
    }
}
