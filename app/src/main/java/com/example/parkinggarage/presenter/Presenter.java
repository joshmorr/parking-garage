package com.example.parkinggarage.presenter;

import com.example.parkinggarage.view.ActivityView;
import com.google.firebase.firestore.FirebaseFirestore;

public abstract class Presenter {
    private FirebaseFirestore database;
    private ActivityView view;

    public Presenter(FirebaseFirestore database, ActivityView view) {
            this.database = database;
            this.view = view;
    }

    public FirebaseFirestore getDatabase() {
        return database;
    }

    public void setDatabase(FirebaseFirestore database) {
        this.database = database;
    }

    public ActivityView getView() {
        return view;
    }

    public void setView(ActivityView view) {
        this.view = view;
    }
}
