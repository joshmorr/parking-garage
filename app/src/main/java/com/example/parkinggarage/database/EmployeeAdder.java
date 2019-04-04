package com.example.parkinggarage.database;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Employee;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class EmployeeAdder {
    private FirebaseFirestore database;
    private Employee employee;
    private String username;
    private String collectionPath;
    private String tag;
    private static final String managersCollection = "managers";
    private static final String attendantsCollection = "attendant";
    private static final String addManagerTag = "ManagerAccountSetupActivity";
    private static final String addAttendantTag = "AddAttendantActivity";

    public EmployeeAdder(Employee employee) {
        database = FirebaseFirestore.getInstance();
        this.employee = employee;
        username = employee.getUsername();
        if (employee.isManager()) {
            collectionPath = managersCollection;
            tag = addManagerTag;
        }
        else {
            collectionPath = attendantsCollection;
            tag = addAttendantTag;
        }
    }

    public void add() {
        database.collection(collectionPath)
                .document(username)
                .set(employee)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(tag, "DocumentSnapshot successfully written!");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(tag, "Error adding document", e);
                    }
                });
    }
}
