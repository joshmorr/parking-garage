package com.example.parkinggarage.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TableLayout;

import com.example.parkinggarage.model.Garage;
import com.example.parkinggarage.model.InputStrings;
import com.example.parkinggarage.model.Manager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class GarageSetupPresenter {
    private FirebaseFirestore database;
    private View view;
    private static String TAG = "GarageSetupActivity";

    public GarageSetupPresenter(FirebaseFirestore database, View view) {
        this.database = database;
        this.view = view;
}

    public void finish(TableLayout tableLayout, InputStrings input, String garageName) {
        Garage garage = new Garage(tableLayout, garageName);
        addGarageToFirestore(database, garage, input);
    }

    private void addGarageToFirestore(final FirebaseFirestore database, Garage garage, final InputStrings input) {
        DocumentReference garageDocRef = database.collection("garages").document();
        final String garageId = garageDocRef.getId();
        garageDocRef.set(garage).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot successfully written!");
                Manager manager = new Manager(garageId, input);
                addToManagerFirestore(database, manager);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error writing document", e);
            }
        });
    }

    public void addToManagerFirestore(FirebaseFirestore database, Manager manager) {
        final String username = manager.getUsername();
        database.collection("managers").document(username).set(manager).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot successfully written!");
                view.startManagerActivity(username);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error writing document", e);
            }
        });
    }

    public interface View {
        void startManagerActivity(String username);
    }
}
