package com.example.parkinggarage.firebase;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.parkinggarage.ui.FailedLoginDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Login {
    private FirebaseFirestore db;
    private Context context;
    private String username;
    private String password;
    private static final String TAG = "MainActivity";

    public Login(FirebaseFirestore db, Context context, String username, String password) {
        this.db = db;
        this.context = context;
        this.username = username;
        this.password = password;
    }

    public void attemptLogin() {
        final CollectionReference cr = db.collection("accounts");

        cr.whereEqualTo("username", username).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult() == null) {
                        FailedLoginDialog fld = new FailedLoginDialog(context);
                        AlertDialog dialog = fld.getDialog();
                        dialog.show();
                        Log.d(TAG, "Task result is null");
                    }
                    else if (task.getResult().getDocuments() == null){
                        FailedLoginDialog fld = new FailedLoginDialog(context);
                        AlertDialog dialog = fld.getDialog();
                        dialog.show();
                        Log.d(TAG, "DocumentSnapshot list is null");
                    }
                    else if (task.getResult().getDocuments().size() == 0){
                        FailedLoginDialog fld = new FailedLoginDialog(context);
                        AlertDialog dialog = fld.getDialog();
                        dialog.show();
                        Log.d(TAG, "DocumentSnapshot list is has no elements");
                    }
                    else {
                        Log.d(TAG, "Username exists!");
                        DocumentSnapshot document = task.getResult().getDocuments().get(0);
                        if (document.get("password").equals(password)) {
                            Log.d(TAG, "Password matches!");
                        }
                        else {
                            FailedLoginDialog fld = new FailedLoginDialog(context);
                            AlertDialog dialog = fld.getDialog();
                            dialog.show();
                            Log.d(TAG, "Password does not match");
                        }

                    }
                }
                else {
                    FailedLoginDialog fld = new FailedLoginDialog(context);
                    AlertDialog dialog = fld.getDialog();
                    dialog.show();
                    Log.d(TAG, "5");
                }
            }
        });
    }

}
