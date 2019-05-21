package com.example.parkinggarage.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
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
        final String vehicleId = vehicle.getId();

        database.collection("garages").document(garageId).collection("vehicles").document(vehicleId).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot successfully deleted!");
                view.startReceiptActivity(vehicle);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error deleting document", e);
            }
        });

    }

    public void getParkedVehicles() {
        final String garageId = attendant.getGarageId();
        database.collection("garages").document(garageId).collection("vehicles").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<Vehicle> vehiclesList = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        Vehicle vehicle = document.toObject(Vehicle.class);
                        vehiclesList.add(vehicle);
                    }
                    view.setListAdapter(vehiclesList);
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
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
