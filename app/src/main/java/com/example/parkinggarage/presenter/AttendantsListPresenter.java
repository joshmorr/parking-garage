package com.example.parkinggarage.presenter;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Button;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.InputStrings;
import com.example.parkinggarage.model.Vehicle;
import com.example.parkinggarage.view.ButtonFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Iterator;

import static android.support.constraint.Constraints.TAG;

public class AttendantsListPresenter {
    private FirebaseFirestore database;
    private View view;
    private String managerUsername;
    private static String TAG = "AttendantsListActivity:";

    public AttendantsListPresenter(FirebaseFirestore database, View view, String managerUsername) {
        this.database = database;
        this.view = view;
    }

    public void create() {
        view.showDialog();
    }

    public void getAttendantsList() {
        database.collection("managers").document(managerUsername).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (task.isSuccessful()) {
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        final ArrayList<String> usernameList =  (ArrayList<String>) document.get("attendantsList");
                        final ArrayList<Attendant> attendantsList = new ArrayList<>(usernameList.size());
                        for (int i = 0; i < usernameList.size(); i++) {
                            String attendantUsername = usernameList.get(i);
                            if (attendantUsername != null) {
                                database.collection("attendants").document(attendantUsername).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                        if (task.isSuccessful()) {
                                            DocumentSnapshot document = task.getResult();
                                            if (document.exists()) {
                                                Attendant attendant = document.toObject(Attendant.class);
                                                attendantsList.add(attendant);
                                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                                            } else {
                                                Log.d(TAG, "No such document");
                                            }
                                        } else {
                                            Log.d(TAG, "get failed with ", task.getException());
                                        }
                                    }
                                });
                            }
                        }
                        view.setListAdapter(attendantsList);
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
        void setListAdapter(ArrayList<Attendant> attendantsList);
        void showDialog();
    }
}
