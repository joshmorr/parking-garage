package com.example.parkinggarage.firestore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Account;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class AccountAdder extends FirestoreConnection {
    private Account account;
    private String tag;

    public AccountAdder(FirebaseFirestore database, Context context, Account account, String tag) {
        super(database, context);
        this.account = account;
        this.tag = tag;
}

    public void addToFirebase(){
        getDatabase().collection("accounts").document(account.getUsername()).set(account).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(tag, "Document successfully added!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(tag, "Error adding document", e);
            }
        });
    }
}