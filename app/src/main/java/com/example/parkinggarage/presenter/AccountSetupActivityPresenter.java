package com.example.parkinggarage.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.InputStrings;
import com.example.parkinggarage.model.Manager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AccountSetupActivityPresenter {
    private FirebaseFirestore database;
    private View view;
    private static String TAG = "AccountSetupActivity:";

    public AccountSetupActivityPresenter(FirebaseFirestore database, View view) {
        this.database = database;
        this.view = view;
    }

    public void next(InputStrings input, boolean managerSetup, Manager manager)  {
        if (checkFields(input)) {
            checkUsername(input, managerSetup, manager);
        }
    }

    public boolean checkFields(InputStrings input) {
        boolean condition = true;
        if (input.getFirstname().isEmpty()) {
            view.setFirstnameError("You must enter a first name!");
            condition = false;
        }
        if (input.getLastname().isEmpty()) {
            view.setLastnameError("You must enter a last name!");
            condition = false;
        }
        if (input.getUsername().isEmpty()) {
            view.setUsernameError("You must enter a username!");
            condition = false;
        }
        if (input.getPassword().isEmpty()) {
            view.setPasswordError("You must enter a password!");
            condition = false;
        }
        return condition;
    }


    private void checkUsername(final InputStrings input, final boolean managerSetup, final Manager manager) {
        final String username = input.getUsername();
        final String managerUsername = manager.getUsername();
        final String collection;
        if (managerSetup)
            collection = "managers";
        else
            collection = "attendants";
        database.collection(collection).document(username).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        view.setLastnameError("That username already exists!");
                    } else {
                        Log.d(TAG, "No such document");
                        if (managerSetup) {
                            view.startNextActivity(input);
                        }
                        else {
                            Attendant attendant = new Attendant(input);
                            String garageId = manager.getGarageId();
                            attendant.setGarageId(garageId);
                            database.collection(collection).document(username).set(attendant).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "DocumentSnapshot successfully written!");
                                    database.collection("managers").document(managerUsername).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                            if (task.isSuccessful()) {
                                                DocumentSnapshot document = task.getResult();
                                                if (document.exists()) {
                                                    Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                                                    Manager manager = document.toObject(Manager.class);
                                                    manager.getAttendantsList().add(username);
                                                    database.collection("managers").document(managerUsername).set(manager).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void aVoid) {
                                                            Log.d(TAG, "DocumentSnapshot successfully written!");
                                                            view.startNextActivity(input);
                                                        }
                                                    }).addOnFailureListener(new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            Log.w(TAG, "Error writing document", e);
                                                        }
                                                    });
                                                } else {
                                                    Log.d(TAG, "No such document");
                                                }
                                            } else {
                                                Log.d(TAG, "get failed with ", task.getException());
                                            }
                                        }
                                    });
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error writing document", e);
                                }
                            });
                        }
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    public interface View {
        void setFirstnameError(String message);
        void setLastnameError(String message);
        void setUsernameError(String message);
        void setPasswordError(String message);
        void startNextActivity(InputStrings input);
    }

}
