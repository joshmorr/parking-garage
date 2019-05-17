package com.example.parkinggarage.view;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Category;
import com.example.parkinggarage.model.Garage;
import com.example.parkinggarage.model.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ParkActivityPresenter {
    private FirebaseFirestore database;
    private View view;
    private static String TAG = "ParkActivity";

    public ParkActivityPresenter(FirebaseFirestore database, View view) {
        this.database = database;
        this.view = view;
    }

    public void park(Attendant attendant, final String plateNum, final Category category) {
        String username = attendant.getUsername();
        final String garageId = attendant.getGarageId();

        database.collection("garages").document(garageId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "Document exists");
                        Garage garage = document.toObject(Garage.class);
                        Vehicle vehicle = new Vehicle(category, plateNum);
                        garage.parkVehicle(vehicle);
                        database.collection("garages").document(garageId).set(garage);
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    public interface View {

    }
}
