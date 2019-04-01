package com.example.parkinggarage.firestore;

import android.content.Context;

import com.google.firebase.firestore.FirebaseFirestore;

public abstract class FirestoreConnection {
    private FirebaseFirestore database;
    private Context context;

    public FirestoreConnection(FirebaseFirestore database, Context context) {
        this.database = database;
        this.context = context;
    }

    public FirebaseFirestore getDatabase() {
        return database;
    }

    public void setDatabase(FirebaseFirestore database) {
        this.database = database;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
