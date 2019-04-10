package com.example.parkinggarage.model;

import com.google.firebase.firestore.DocumentReference;

public class Manager extends Employee {

    public Manager(String firstname, String lastname, String username, String password) {
        super(firstname, lastname, username, password);
    }

    @Override
    public boolean isManager() {
        return true;
    }
}
