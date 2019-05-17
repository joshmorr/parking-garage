package com.example.parkinggarage.view;

import android.widget.RadioGroup;

import com.example.parkinggarage.model.Category;
import com.google.firebase.firestore.FirebaseFirestore;

public class ParkActivityPresenter {
    private FirebaseFirestore database;
    private View view;

    public ParkActivityPresenter(FirebaseFirestore database, View view) {
        this.database = database;
        this.view = view;
    }

    public void park(String plateNum, Category category) {

    }

    public interface View {

    }
}
