package com.example.parkinggarage.presenter;

import android.widget.TableLayout;

import com.example.parkinggarage.model.InputFields;
import com.google.firebase.firestore.FirebaseFirestore;

public class GarageSetupPresenter {
    private FirebaseFirestore database;
    private View view;

    public GarageSetupPresenter(FirebaseFirestore database, View view) {
        this.database = database;
}

    public void finishAccountSetup(FirebaseFirestore database, TableLayout tableLayout, InputFields fields) {

    }

    public interface View {

    }
}
