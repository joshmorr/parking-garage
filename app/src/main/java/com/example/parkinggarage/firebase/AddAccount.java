package com.example.parkinggarage.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Account;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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

    public void addToFirebase() {
        getDatabase().collection("accounts").add(account).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
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