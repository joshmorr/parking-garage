package com.example.parkinggarage.database;

import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends FirestoreConnection {
    private String username;
    private String password;
    private static String TAG = "MainActivity";

    public Login(boolean isManager, String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public void attemptLogin() {

    }
    
}
