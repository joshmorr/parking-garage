package com.example.parkinggarage.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.InputStrings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AttendantsListActivityPresenter {
    private FirebaseFirestore database;
    private View view;
    private String managerUsername;
    private static String TAG = "AttendantsListActivity:";

    public AttendantsListActivityPresenter(FirebaseFirestore database, View view, String managerUsername) {
        this.database = database;
        this.view = view;
        this.managerUsername = managerUsername;
    }

    public void fabClick() {
        view.startAccountSetupActivity();
    }

    public void updateList() {
        database.collection("managers").document(managerUsername).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (task.isSuccessful()) {
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        final ArrayList<String> usernameList =  (ArrayList<String>) document.get("attendantsList");
                        view.setListAdapter(usernameList);
                    }
                    else {
                        Log.d(TAG, "No such document");
                    }
                }
                else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }


    public interface View {
        void setListAdapter(ArrayList<String> usernameList);
        void startAccountSetupActivity();
    }
}
