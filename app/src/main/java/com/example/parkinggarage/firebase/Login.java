package com.example.parkinggarage.firebase;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.ui.CustomDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends FirebaseConnection {
    private String username;
    private String password;
    private static final String TAG = "MainActivity";

    public Login(FirebaseFirestore database, Context context, String username, String password) {
        super(database, context);
        this.username = username;
        this.password = password;
    }

    public void attemptLogin() {
        final CollectionReference cr = getDatabase().collection("accounts");
        ImageView view = new ImageView(getContext());
        view.setImageResource(R.drawable.gandalf);
        CustomDialog cd = new CustomDialog(getContext(), getContext().getString(R.string.failed_login_dialog_title),  getContext().getString(R.string.failed_login_dialog_message), view);
        final AlertDialog dialog = cd.getBuilder().create();
        cr.whereEqualTo("username", username).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult() == null) {
                        dialog.show();
                        Log.d(TAG, "Task result is null");
                    }
                    else if (task.getResult().getDocuments() == null){
                        dialog.show();
                        Log.d(TAG, "DocumentSnapshot list is null");
                    }
                    else if (task.getResult().getDocuments().size() == 0){
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
                            dialog.show();
                            Log.d(TAG, "Password does not match");
                        }

                    }
                }
                else {
                    dialog.show();
                    Log.d(TAG, "Could not complete task!");
                }
            }
        });
    }

}
