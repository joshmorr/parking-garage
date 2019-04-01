package com.example.parkinggarage.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.firestore.AccountAdder;
import com.example.parkinggarage.model.Account;
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
                FirebaseApp.initializeApp(getApplicationContext());
                FirebaseFirestore database = FirebaseFirestore.getInstance();
                EditText firstnameEditText = findViewById(R.id.firstnameEditText);
                EditText lastnameEditText = findViewById(R.id.lastnameEditText);
                EditText usernameEditText = findViewById(R.id.usernameEditText);
                EditText passwordEditText = findViewById(R.id.passwordEditText);

                Account account = new Account.Builder()
                        .setFirstname(firstnameEditText.getText().toString())
                        .setLastname(lastnameEditText.getText().toString())
                        .setUsername(usernameEditText.getText().toString())
                        .setPassword((passwordEditText.getText().toString()))
                        .setIsManager(true)
                        .create();

                AccountAdder adder = new AccountAdder(database, ManagerAccountSetupActivity.this, account, TAG);
                adder.addToFirebase();
            }
        });
    }

    public void startGarageSetUpActivity() {
        Intent intent = new Intent(this, GarageSetupActivity.class);
        startActivity(intent);
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
