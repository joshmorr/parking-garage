package com.example.parkinggarage.presenter;

import android.content.Context;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivityPresenter {
    private View view;

    public MainActivityPresenter(View view) {
        this.view = view;
    }

    public void login(FirebaseFirestore database, boolean isManager, String usernameInput, String passwordInput) {

    }

    public interface View {

    }

}
