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

public class TicketActivity extends AppCompatActivity {
    private Attendant attendant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Attendant attendant = (Attendant) getIntent().getExtras().get("attendant");
        String ticket = getIntent().getStringExtra("ticket");

        TextView dataTextView = findViewById(R.id.ticketDataTextView);
        dataTextView.setText(ticket);

        TextView labelsTextView = findViewById(R.id.ticketLabelsTextView);
        StringBuilder builder = new StringBuilder();
        builder.append("License Plate Number:")
                .append("\n\nVehicle Category:")
                .append("\n\nAttendant Name:")
                .append("\n\nDate:")
                .append("\n\nTimeParked:")
                .append("\n\nRate");
        labelsTextView.setText(builder.toString());

        final CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinatorLayout);

        Button printButton = findViewById(R.id.printTicketButton);
        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout, "The ticket has been sent to the printer.", Snackbar.LENGTH_SHORT).show();
            }
        });

        final Intent intent = new Intent(this, AttendantActivity.class);
        intent.putExtra("attendant", attendant);

        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

}
