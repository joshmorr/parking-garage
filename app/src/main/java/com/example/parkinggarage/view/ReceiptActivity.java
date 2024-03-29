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
import com.example.parkinggarage.presenter.ReceiptActivityPresenter;

public class ReceiptActivity extends AppCompatActivity implements ReceiptActivityPresenter.View {
    private Vehicle vehicle;
    private Attendant attendant;
    private TextView labelsTextView;
    private TextView dataTextView;
    private Button printButton;
    private Button finishButton;
    private CoordinatorLayout coordinatorLayout;
    private ReceiptActivityPresenter presenter;
    private Snackbar snackbar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        labelsTextView = findViewById(R.id.labelsTextView);
        dataTextView = findViewById(R.id.dataTextView);
        printButton = findViewById(R.id.printButton);
        finishButton = findViewById(R.id.finishButton);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        snackbar = Snackbar.make(coordinatorLayout, "The receipt has been sent to the printer.", Snackbar.LENGTH_SHORT);

        attendant = (Attendant) getIntent().getExtras().get("attendant");
        vehicle = (Vehicle) getIntent().getExtras().get("vehicle");

        intent = new Intent(this, AttendantActivity.class);
        intent.putExtra("attendant", attendant);

        presenter = new ReceiptActivityPresenter(vehicle, this);
        presenter.setLabels();
        presenter.setData();

        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.print();
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
