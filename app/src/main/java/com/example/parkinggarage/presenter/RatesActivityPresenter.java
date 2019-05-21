package com.example.parkinggarage.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Garage;
import com.example.parkinggarage.model.Manager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class RatesActivityPresenter {
    private FirebaseFirestore database;
    private View view;
    private Manager manager;
    private static String TAG = "RatesActivity";

    public RatesActivityPresenter(FirebaseFirestore database, View view, Manager manager) {
        this.database = database;
        this.view = view;
        this.manager = manager;
    }

    public interface View {

    }
}
