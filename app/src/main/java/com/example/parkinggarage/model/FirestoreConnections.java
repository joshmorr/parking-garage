package com.example.parkinggarage.model;

import com.google.firebase.firestore.FirebaseFirestore;

public class FirestoreConnections {

    public static void attemptLogin(String usernameInput, String passwordInput) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }

    public static void addManager() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }

    public static void addAttendant() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }
}
