package com.example.parkinggarage.database;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Garage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class GarageAdder {
    private FirebaseFirestore db;
    private Garage garage;
    private static String COLLECTION_PATH = "garages";
    private static String TAG = "ManagerSetupActivity";
    private final GarageId garageId;

    public GarageAdder(Garage garage) {
        db = FirebaseFirestore.getInstance();
        this.garage = garage;
        garageId = new GarageId();
    }

    public void add() {
        db.collection(COLLECTION_PATH).document("garage1").set(garage).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot successfully written!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding document", e);
            }
        });
    }

    public String getGarageId() {
       return garageId.getId();
    }

    private class GarageId {
        private String id;

        public GarageId() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
