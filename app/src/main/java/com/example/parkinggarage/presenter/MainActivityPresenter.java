package com.example.parkinggarage.presenter;

import android.content.Context;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivityPresenter extends Presenter {
    private View view;

    public MainActivityPresenter(Context context, View view) {
        super(context);
        this.view = view;
    }

    public void login(FirebaseFirestore database, boolean isManager, String usernameInput, String passwordInput) {

    }

    public interface View {
        void showFailedLoginDialog();
    }

}
