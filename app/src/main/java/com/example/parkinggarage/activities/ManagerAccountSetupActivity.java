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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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
                EditText firstnameEditText = findViewById(R.id.firstnameEditText);
                EditText lastnameEditText = findViewById(R.id.lastnameEditText);
                EditText usernameEditText = findViewById(R.id.usernameEditText);
                EditText passwordEditText = findViewById(R.id.passwordEditText);

                Account account = new Account();
                account.setFirstname(firstnameEditText.getText().toString());
                account.setLastname(lastnameEditText.getText().toString());
                account.setUsername(usernameEditText.getText().toString());
                account.setPassword(passwordEditText.getText().toString());
                account.setManager(true);

                FirebaseApp.initializeApp(getApplicationContext());
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("accounts").add(account).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "Document successfully added!");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "Error adding document", e);
                    }
                });

            }
        });
    }

    public void setEditorFocusChanges() {
        EditText firstnameEditText = findViewById(R.id.firstnameEditText);
        firstnameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                TextInputEditText lastnameEditText = findViewById(R.id.lastnameEditText);
                lastnameEditText.requestFocus();
                return true;
            }
        });

        EditText lastnameEditText = findViewById(R.id.lastnameEditText);
        lastnameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                TextInputEditText usernameEditText = findViewById(R.id.usernameEditText);
                usernameEditText.requestFocus();
                return true;
            }
        });

        EditText usernameEditText = findViewById(R.id.usernameEditText);
        usernameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                TextInputEditText passwordEditText = findViewById(R.id.passwordEditText);
                passwordEditText.requestFocus();
                return true;
            }
        });
    }

}
