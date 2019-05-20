package com.example.parkinggarage.view;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.presenter.ReceiptActivityPresenter;

public class ReceiptActivity extends AppCompatActivity implements ReceiptActivityPresenter.View {
    private TextView labelsTextView;
    private TextView dataTextView;
    private Button printButton;
    private Button finishButton;
    private CoordinatorLayout coordinatorLayout;
    private ReceiptActivityPresenter presenter;

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


        presenter = new ReceiptActivityPresenter(this);


    }

}
