package com.example.parkinggarage.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Garage;
import com.example.parkinggarage.model.Manager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ManagerActivityPresenter {
    private FirebaseFirestore database;
    private View view;
    private static String TAG = "ManagerActivity";

    public ManagerActivityPresenter(FirebaseFirestore database, View view) {
       this.database = database;
       this.view = view;
    }

    public void goToAttendantsList(String username) {
        view.startAttendantsListActivity(username);
    }

    public void setRates() {
        view.startRatesActivity();
    }

    public void getGarageData(Manager manager) {
        final String garageId = manager.getGarageId();
        database.collection("garages").document(garageId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Garage garage = document.toObject(Garage.class);
                        view.setEmptyMotorcycleSpaces(garage.getEmptyMotorcycleSpaces());
                        view.setEmptyCarSpaces(garage.getEmptyCarSpaces());
                        view.setEmptyTruckSpaces(garage.getEmptyTruckSpaces());
                        view.setOccupiedMotorcycleSpaces(garage.getOccupiedMotorcycleSpaces());
                        view.setOccupiedCarSpaces(garage.getOccupiedCarSpaces());
                        view.setOccupiedTruckSpaces(garage.getOccupiedTruckSpaces());
                        view.setMotorcycleRate(garage.getPaymentScheme().getMotorcycleHourly());
                        view.setCarRate(garage.getPaymentScheme().getCarHourly());
                        view.setTruckRate(garage.getPaymentScheme().getTruckHourly());
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
        void setEmptyMotorcycleSpaces(int n);
        void setEmptyCarSpaces(int n);
        void setEmptyTruckSpaces(int n);
        void setOccupiedMotorcycleSpaces(int n);
        void setOccupiedCarSpaces(int n);
        void setOccupiedTruckSpaces(int n);
        void setMotorcycleRate(double rate);
        void setCarRate(double rate);
        void setTruckRate(double rate);
        void startAttendantsListActivity(String username);
        void startRatesActivity();
    }

}
