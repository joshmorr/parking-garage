package com.example.parkinggarage.database;

import com.google.firebase.firestore.FirebaseFirestore;

public class EmployeeAdder {
    private FirebaseFirestore database;
    private String collection;
    private static final String managersCollection = "managers";
    private static final String attendantsCollection = "attendant";

    public EmployeeAdder(boolean isManagerAdder) {
        database = FirebaseFirestore.getInstance();
        if (isManagerAdder) {
            collection = managersCollection;
        }
        else {
            collection = attendantsCollection;
        }
    }

    public void add() {

    }

}
