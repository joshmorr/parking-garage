package com.example.parkinggarage.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Account;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

public class ManagerAccountSetupActivity extends AppCompatActivity {
    private static final String TAG = "ManagerAccountSetup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_account_setup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account account = new Account();
//                account.setFirstname(findViewById(R.id.firstnameInputEditText).toString());
//                account.setLastname(findViewById(R.id.lastnameInputEditText).toString());
//                account.setUsername(findViewById(R.id.usernameInputEditText).toString());
//                account.setPassword(findViewById(R.id.passwordInputEditText).toString());
//                account.setManager(true);

                account.setFirstname("Joshua");
                account.setLastname("Morris");
                account.setUsername("jmorris1");
                account.setPassword("password1");
                account.setManager(true);

                FirebaseApp.initializeApp(getApplicationContext());
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("accounts").document(account.getUsername()).set(account).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.i(TAG, "Success!");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Failure!");
                    }
                });
            }
        });


    }

}
