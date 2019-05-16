package com.example.parkinggarage.presenter;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Button;

import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.InputStrings;
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
    private static String TAG = "AttendantsListActivity:";

    public AttendantsListPresenter(FirebaseFirestore database, View view) {
        this.database = database;
        this.view = view;
    }

    public void getAttendantsList(String username, final ButtonFactory buttonFactory) {
        database.collection("managers").document(username).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (task.isSuccessful()) {
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        ArrayList<String> list =  (ArrayList<String>) document.get("attendantsList");
                        Iterator<String> iterator = list.iterator();
                        while (iterator.hasNext()) {
                            String username = iterator.next();
                            database.collection("attendants").document(username).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document.exists()) {
                                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                                            String firstname = (String) document.get("firstname");
                                            String lastname = (String) document.get("lastname");
                                            Button button = buttonFactory.getButton(firstname + " " + lastname);
                                            view.addViewToLayout(button);
                                    }
                                    else {
                                        Log.d(TAG, "No such document");
                                    }
                                }
                            });
                        }
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
        void addViewToLayout(Button button);
    }
}
