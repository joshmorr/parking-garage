package com.example.parkinggarage.firestore;

import com.google.firebase.firestore.FirebaseFirestore;

public class Login {
    private FirebaseFirestore database;
    private String username;
    private String password;
    private boolean managerSelected;

    public Login(String username, String password) {
        database = FirebaseFirestore.getInstance();
        this.username = username;
        this.password = password;
    }

    public static void attemptLogin(String usernameInput, String passwordInput) {

    }

    public void attemptLogin() {

    }


}
