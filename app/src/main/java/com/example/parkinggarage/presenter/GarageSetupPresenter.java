package com.example.parkinggarage.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TableLayout;

import com.example.parkinggarage.model.Garage;
import com.example.parkinggarage.model.InputFields;
import com.example.parkinggarage.model.Manager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class GarageSetupPresenter {
    private FirebaseFirestore database;
    private View view;
    private static String TAG = "GarageSetupActivity";

    public GarageSetupPresenter(FirebaseFirestore database, View view) {
        this.database = database;
        this.view = view;
}

    public void finish(TableLayout tableLayout, InputFields input, String garageName) {
        Garage garage = new Garage(tableLayout, garageName);
        Manager manager = new Manager(garage, input);
        addToFirestore(database, manager);
    }

    public void addToFirestore(FirebaseFirestore database, Manager manager) {
        String username = manager.getUsername();
        database.collection("managers").document(username).set(manager).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot successfully written!");
                view.startManagerActivity();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error writing document", e);
            }
        });
    }

    public interface View {
        void startManagerActivity();
    }
}
