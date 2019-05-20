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
import com.example.parkinggarage.presenter.MainActivityPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {
    private Intent attendantIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(getApplicationContext());
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        final MainActivityPresenter presenter = new MainActivityPresenter(database, this);

        final TextInputLayout usernameInputLayout = findViewById(R.id.usernameInputLayout);
        final TextInputLayout passwordInputLayout = findViewById(R.id.passwordInputLayout);
        final EditText usernameEditText = findViewById(R.id.usernameEditText);
        final EditText passwordEditText = findViewById(R.id.passwordEditText);
        final Button loginButton = findViewById(R.id.loginButton);
        final Button setupButton = findViewById(R.id.setupButton);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);

        attendantIntent = new Intent(this, AttendantActivity.class);

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

                presenter.login(isManager, input);

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
       Intent intent = new Intent(this, ManagerSetupActivity.class);
       startActivity(intent);
    }

    @Override
    public void startManagerActivity(String username) {
        Intent intent = new Intent(this, ManagerActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    @Override
    public void startAttendantActivity(Attendant attendant) {
        attendantIntent.putExtra("attendant", attendant);
        startActivity(attendantIntent);
    }
}