package com.example.parkinggarage.presenter;

import android.content.Context;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivityPresenter extends Presenter {
    private View view;

    public MainActivityPresenter(Context context, View view) {
        super(context);
        this.view = view;
    }

    public void login(String usernameInput, String passwordInput) {

    }

    public interface View {
        void showFailedLoginDialog();
    }

}
