package com.example.parkinggarage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Category;
import com.example.parkinggarage.presenter.ParkActivityPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

public class ParkActivity extends AppCompatActivity implements ParkActivityPresenter.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(ParkActivity.this);
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        final Attendant attendant = (Attendant) getIntent().getExtras().get("attendant");

        final ParkActivityPresenter presenter = new ParkActivityPresenter(database, this);

        final TextView plateNumTextView = findViewById(R.id.plateNumEditText);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup2);
        final RadioButton motorcycleButton = findViewById(R.id.motorcycleButton);
        final RadioButton carButton = findViewById(R.id.carButton);
        final RadioButton truckButton = findViewById(R.id.truckButton);


        Button parkButton = findViewById(R.id.parkButton);
        parkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plateNum = plateNumTextView.getText().toString();
                Category category = null;
                int id = radioGroup.getCheckedRadioButtonId();
                if (id == motorcycleButton.getId())
                    category = Category.MOTORCYCLE;
                else if (id == carButton.getId())
                    category = Category.CAR;
                else if (id == truckButton.getId()) {
                    category = Category.TRUCK;
                }
                presenter.park(attendant, plateNum, category);
            }
        });

    }

    @Override
    public void startTicketActivity(String ticket) {
        Intent intent = new Intent(getApplicationContext(), TicketActivity.class);
        intent.putExtra("ticket", ticket);
        startActivity(intent);
    }
}
