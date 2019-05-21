package com.example.parkinggarage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.model.InputStrings;
import com.example.parkinggarage.model.Manager;
import com.example.parkinggarage.presenter.MainActivityPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {
    private MainActivityPresenter presenter;
    private Intent attendantIntent;
    private Intent setupIntent;
    private TextInputLayout usernameInputLayout;
    private TextInputLayout passwordInputLayout;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button setupButton;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(getApplicationContext());
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        presenter = new MainActivityPresenter(database, this);

        usernameInputLayout = findViewById(R.id.usernameInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        setupButton = findViewById(R.id.setupButton);
        radioGroup = findViewById(R.id.radioGroup);

        attendantIntent = new Intent(this, AttendantActivity.class);

        setupIntent = new Intent(this, AccountSetupActivity.class);
        setupIntent.putExtra("username", "null");
        setupIntent.putExtra("managerSetup", true);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                InputStrings input = new InputStrings(username, password);

                boolean isManager;
                if (radioGroup.getCheckedRadioButtonId() == R.id.managerButton)
                    isManager = true;
                else
                    isManager = false;
                try {
                    presenter.login(isManager, input);
                } catch (IllegalArgumentException e) {
                    presenter.setPasswordError("You must enter a username and a password!");
                }
            }
        });

        Button setUpButton = findViewById(R.id.setupButton);
        setUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSetUpActivity();
            }
        });
    }

    public void startSetUpActivity() {
       startActivity(setupIntent);
    }

    @Override
    public void startManagerActivity(String username, Manager manager) {
        Intent intent = new Intent(this, ManagerActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("manager", manager);
        startActivity(intent);
    }

    @Override
    public void startAttendantActivity(Attendant attendant) {
        attendantIntent.putExtra("attendant", attendant);
        startActivity(attendantIntent);
    }

    @Override
    public void setPasswordError(String message) {
        passwordInputLayout.setError(message);
    }
}