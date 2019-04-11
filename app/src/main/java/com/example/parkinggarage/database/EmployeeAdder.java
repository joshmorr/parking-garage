package com.example.parkinggarage.database;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.model.Employee;
import com.example.parkinggarage.model.Manager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class EmployeeAdder extends Adder {
    private Employee employee;
    private String username;
    private static final String managersCollection = "managers";
    private static final String attendantsCollection = "attendant";
    private static final String addManagerTag = "ManagerAccountSetupActivity";
    private static final String addAttendantTag = "AddAttendantActivity";

    public EmployeeAdder(Employee employee) {
        super();
        this.employee = employee;
        username = employee.getUsername();
        if (employee.isManager()) {
            setCollectionPath(managersCollection);
            setTag(addManagerTag);
        }
        else {
            setCollectionPath(attendantsCollection);
            setTag(addAttendantTag);
        }
    }

    public void add() {
        getDatabase().collection(getCollectionPath())
                .document(username)
                .set(employee)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(getTag(), "DocumentSnapshot successfully written!");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(getTag(), "Error adding document", e);
                    }
                });
    }
}
