package com.example.parkinggarage.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Account;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddManagerAccount extends FirebaseConnection {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private static final boolean isManager = true;
    private Account account;
    private final String TAG = "ManagerAccountSetupActivity";

    public AddManagerAccount(FirebaseFirestore database, Context context, String firstname, String lastname, String username, String password) {
        super(database, context);
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        account = new Account(firstname, lastname, username, password, true);
    }

    private void addAccountToFirebase() {

    }
}