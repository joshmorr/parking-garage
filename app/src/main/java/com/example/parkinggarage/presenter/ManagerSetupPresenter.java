package com.example.parkinggarage.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.InputStrings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ManagerSetupPresenter {
    private FirebaseFirestore database;
    private View view;
    private static String TAG = "ManagerSetupActivity:";

    public ManagerSetupPresenter(FirebaseFirestore database, View view) {
        this.database = database;
        this.view = view;
    }

    public void next(InputStrings input)  {
        if (checkFields(input)) {
            checkUsername(input);
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


    private void checkUsername(final InputStrings input) {
                            String username = input.getUsername();
                            database.collection("managers").document(username).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    if (task.isSuccessful()) {
                                        DocumentSnapshot document = task.getResult();
                                        if (document.exists()) {
                                            Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                                        } else {
                                            Log.d(TAG, "No such document");
                                            view.startNextActivity(input);
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
