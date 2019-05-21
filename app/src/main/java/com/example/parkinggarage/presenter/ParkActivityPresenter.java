package com.example.parkinggarage.presenter;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Category;
import com.example.parkinggarage.model.Garage;
import com.example.parkinggarage.model.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class ParkActivityPresenter {
    private FirebaseFirestore database;
    private View view;
    private static String TAG = "ParkActivity";

    public ParkActivityPresenter(FirebaseFirestore database, View view) {
        this.database = database;
        this.view = view;
    }

    public void park(Attendant attendant, final String plateNum, final Category category) {
        final String firstname = attendant.getFirstname();
        final String garageId = attendant.getGarageId();

        database.collection("garages").document(garageId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @TargetApi(Build.VERSION_CODES.O)
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "Document exists");
                        final Garage garage = document.toObject(Garage.class);
                        final Vehicle vehicle = new Vehicle(category, plateNum, firstname, Timestamp.now(), garage.getPaymentScheme().getRate(category));
                        garage.parkVehicle(vehicle);
                        database.collection("garages").document(garageId).set(garage).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                DocumentReference documentReference = database.collection("garages").document(garageId).collection("vehicles").document();
                                final String vehicleId = documentReference.getId();
                                vehicle.setId(vehicleId);
                                database.collection("garages").document(garageId).collection("vehicles").document(vehicleId).set(vehicle).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "DocumentSnapshot successfully written!");
                                        view.startTicketActivity(vehicle);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error writing document", e);
                                    }
                                });
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });
                    } else {
                        Log.d(TAG, "No such document:" + garageId);
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    public interface View {
        void startTicketActivity(Vehicle vehicle);
    }
}
