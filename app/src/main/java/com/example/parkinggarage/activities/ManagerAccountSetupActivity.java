package com.example.parkinggarage.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        setEditorFocusChanges();
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstnameEditText = findViewById(R.id.firstnameInputEditText);
                EditText lastnameEditText = findViewById(R.id.lastnameInputEditText);
                EditText usernameEditText = findViewById(R.id.usernameInputEditText);
                EditText passwordEditText = findViewById(R.id.passwordInputEditText);

                Account account = new Account();
                account.setFirstname(firstnameEditText.getText().toString());
                account.setLastname(lastnameEditText.getText().toString());
                account.setUsername(usernameEditText.getText().toString());
                account.setPassword(passwordEditText.getText().toString());
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

    public void setEditorFocusChanges() {
        EditText firstnameEditText = findViewById(R.id.firstnameInputEditText);
        firstnameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                TextInputEditText lastnameEditText = findViewById(R.id.lastnameInputEditText);
                lastnameEditText.requestFocus();
                return true;
            }
        });

        EditText lastnameEditText = findViewById(R.id.lastnameInputEditText);
        lastnameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                TextInputEditText usernameEditText = findViewById(R.id.usernameInputEditText);
                usernameEditText.requestFocus();
                return true;
            }
        });

        EditText usernameEditText = findViewById(R.id.usernameInputEditText);
        usernameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                TextInputEditText passwordEditText = findViewById(R.id.passwordInputEditText);
                passwordEditText.requestFocus();
                return true;
            }
        });
    }

}
