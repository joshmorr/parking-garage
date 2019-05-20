package com.example.parkinggarage.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Garage;
import com.example.parkinggarage.model.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AttendantActivityPresenter {
    private FirebaseFirestore database;
    private Attendant attendant;
    private View view;
    private static String TAG = "AttendantActivity:";

    public AttendantActivityPresenter(FirebaseFirestore database, Attendant attendant, View view) {
        this.database = database;
        this.attendant = attendant;
        this.view = view;
    }

    public void park() {
        view.startParkActivity();
    }

    public void retrieve(final Vehicle vehicle) {
        final String garageId = attendant.getGarageId();
        database.collection("garages").document(garageId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isComplete()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Garage garage = document.toObject(Garage.class);
                        final ArrayList<Vehicle> vehiclesList = garage.getParkedVehiclesList();
                        vehiclesList.remove(vehicle);
                        garage.setParkedVehiclesList(vehiclesList);
                        garage.getRowsList().get(vehicle.getRowNum()).getSpacesList().remove(vehicle.getSpaceNum());
                        database.collection("garages").document(garageId).set(garage).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                view.startReceiptActivity(vehicle);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

    }

    public void getParkedVehiclesList() {
        final String garageId = attendant.getGarageId();
        database.collection("garages").document(garageId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isComplete()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Garage garage = document.toObject(Garage.class);
                        final ArrayList<Vehicle> vehiclesList = (ArrayList<Vehicle>) document.get("parkedVehiclesList");
                        view.setListAdapter(vehiclesList);

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
        void setListAdapter(ArrayList<Vehicle> vehiclesList);
        void startParkActivity();
        void startReceiptActivity(Vehicle vehicle);
    }
}
