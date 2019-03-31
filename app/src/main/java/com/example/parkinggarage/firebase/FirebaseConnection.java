package com.example.parkinggarage.firebase;

import android.content.Context;

import com.google.firebase.firestore.FirebaseFirestore;

public abstract class FirebaseConnection {
    private FirebaseFirestore database;
    private Context context;

    public FirebaseConnection(FirebaseFirestore database, Context context) {
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
