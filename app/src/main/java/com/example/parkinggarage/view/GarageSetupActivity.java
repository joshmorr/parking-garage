package com.example.parkinggarage.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parkinggarage.R;

public class GarageSetupActivity extends AppCompatActivity {
    static final String TAG = "GarageSetupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_setup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText rowsEditText = findViewById(R.id.rowsEditText);
                EditText spacesEditText = findViewById(R.id.spacesEditText);
//
//                int nRows = Integer.valueOf(rowsEditText.getText().toString());
//                int nSpacesPerRow = Integer.valueOf(spacesEditText.getText().toString());
//                Garage garage = new Garage(nRows, nSpacesPerRow);
//                Garage system = new Garage(garage);
//                FirebaseApp.initializeApp(GarageSetupActivity.this);
//                FirebaseFirestore db = FirebaseFirestore.getInstance();
//                db.collection("systems").add(system).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot successfully written!");
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error writing document", e);
//                    }
//                });

            }
        });

    }

}
