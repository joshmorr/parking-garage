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

public class AddAccount extends FirebaseConnection {
    private Account account;
    private String tag;

    public AddAccount(FirebaseFirestore database, Context context, Account account, String tag) {
        super(database, context);
        this.account = account;
        this.tag = tag;
    }

    private void addAccountToFirebase() {

    }
}