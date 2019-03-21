package com.example.parkinggarage.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Account;
import com.example.parkinggarage.model.ParkingGarageSystem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ParkingGarageSystem system = new ParkingGarageSystem();
        system.getAccounts().addSampleAccounts();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextInputEditText usernameField = findViewById(R.id.usernameInputEditText);
        TextInputEditText passwordField = findViewById(R.id.passwordInputEditText);

        usernameField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                TextInputEditText passwordField = findViewById(R.id.passwordInputEditText);
                passwordField.requestFocus();
                return true;
            }

        });

        TextView loginStatusView = findViewById(R.id.loginErrorTextView);

        final Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParkingGarageSystem system = new ParkingGarageSystem();
                system.getAccounts().addSampleAccounts();

                TextInputEditText usernameField = findViewById(R.id.usernameInputEditText);
                TextInputEditText passwordField = findViewById(R.id.passwordInputEditText);

                TextView loginErrorLabel = findViewById(R.id.loginErrorTextView);

                if (!system.getAccounts().attemptLogin(usernameField.getText().toString(), passwordField.getText().toString())) {
                    loginErrorLabel.setVisibility(View.VISIBLE);
                }
                else {
                    Account account = system.getAccounts().getAccountsMap().get(usernameField.getText().toString());
                    if (account.isManager()) {
                        Intent intent = new Intent(getApplicationContext(), ManagerActivity.class);
                        startActivity(intent);
                    }
                }

            }
        });
    }

    public void accessManagerAccount() {
        Intent intent = new Intent(this, ManagerActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
