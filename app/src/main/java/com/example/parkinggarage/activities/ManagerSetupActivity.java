package com.example.parkinggarage.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.example.parkinggarage.database.UsernameChecker;
import com.example.parkinggarage.presenter.ManagerSetupActivityPresenter;
import com.example.parkinggarage.model.ManagerSetupInput;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ManagerSetupActivity extends AppCompatActivity implements ManagerSetupActivityPresenter.View {
    private static final String TAG = "ManagerAccountSetup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_account_setup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(ManagerSetupActivity.this);

        final ManagerSetupActivityPresenter presenter = new ManagerSetupActivityPresenter(ManagerSetupActivity.this, this);

        setEditorFocusChanges();
        Button nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstnameEditText = findViewById(R.id.firstnameEditText);
                EditText lastnameEditText = findViewById(R.id.lastnameEditText);
                EditText usernameEditText = findViewById(R.id.usernameEditText);
                EditText passwordEditText = findViewById(R.id.passwordEditText);

                String firstname = firstnameEditText.getText().toString();
                String lastname = lastnameEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                final ManagerSetupInput input = new ManagerSetupInput(firstname, lastname, username, password);

                FirebaseFirestore database = FirebaseFirestore.getInstance();
                UsernameChecker.check(database, input.getUsername());

                database.collection("managers").document(username).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            } else {
                                Log.d(TAG, "No such document");
                                Intent intent = new Intent(getApplicationContext(), GarageSetupActivity.class);
                                intent.putExtra("input", input);
                                startActivity(intent);
                            }
                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
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

    @Override
    public void showFailedAddManagerDialog() {

    }
}