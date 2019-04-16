package com.example.parkinggarage.presenter;

import android.content.Context;

import com.google.firebase.firestore.FirebaseFirestore;

public abstract class Presenter {
    private Context context;

    public Presenter(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

}
