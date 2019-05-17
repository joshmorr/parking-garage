package com.example.parkinggarage.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.InputStrings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.support.constraint.Constraints.TAG;

public class MainActivityPresenter {
    private FirebaseFirestore database;
    private View view;
    private String collection;
    private static String managersCollection = "managers";
    private static String attendantsCollection = "attendants";

    public MainActivityPresenter(FirebaseFirestore database, View view) {
        this.database = database;
        this.view = view;
    }

    public void login(final boolean isManager, InputStrings input) {
        if (isManager)
            collection = managersCollection;
        else
            collection = attendantsCollection;

        final String username = input.getUsername();
        final String passwordInput = input.getPassword();

        database.collection(collection).document(username).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        String password = document.getString("password");
                        if (passwordInput.equals(password)) {
                            if (isManager) {
                                view.startManagerActivity(username);
                            }
                            else {
                                Attendant attendant = document.toObject(Attendant.class);
                                view.startAttendantActivity(attendant);
                            }
                        }
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    public interface View {
        void startManagerActivity(String username);
        void startAttendantActivity(Attendant attendant);
    }

}
