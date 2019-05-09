package com.example.parkinggarage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.presenter.ManagerSetupPresenter;
import com.example.parkinggarage.model.InputStrings;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

public class ManagerSetupActivity extends AppCompatActivity implements ManagerSetupPresenter.View {
    private TextInputLayout firstnameInputLayout;
    private TextInputLayout lastnameInputLayout;
    private TextInputLayout usernameInputLayout;
    private TextInputLayout passwordInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_account_setup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(ManagerSetupActivity.this);
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        final ManagerSetupPresenter presenter = new ManagerSetupPresenter(database, this);

        firstnameInputLayout = findViewById(R.id.firstnameInputLayout);
        lastnameInputLayout = findViewById(R.id.lastnameInputLayout);
        usernameInputLayout = findViewById(R.id.usernameInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);

        final EditText firstnameEditText = findViewById(R.id.firstnameEditText);
        final EditText lastnameEditText = findViewById(R.id.lastnameEditText);
        final EditText usernameEditText = findViewById(R.id.usernameEditText);
        final EditText passwordEditText = findViewById(R.id.passwordEditText);

        setEditorFocusChanges();
        Button nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = firstnameEditText.getText().toString();
                String lastname = lastnameEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                InputStrings input = new InputStrings(firstname, lastname, username, password);
                presenter.next(input);
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
                TextInputEditText passwordEditText = findViewById(R.id.usernameEditText);
                passwordEditText.requestFocus();
                return true;
            }
        });
    }

    @Override
    public void setFirstnameError(String message) {
        firstnameInputLayout.setError(message);
    }

    @Override
    public void setLastnameError(String message) {
        lastnameInputLayout.setError(message);
    }

    @Override
    public void setUsernameError(String message) {
        usernameInputLayout.setError(message);
    }

    @Override
    public void setPasswordError(String message) {
        passwordInputLayout.setError(message);
    }

    @Override
    public void startNextActivity(InputStrings input) {
        Intent intent = new Intent(getApplicationContext(), GarageSetupActivity.class);
        intent.putExtra("input", input);
        startActivity(intent);
    }
}