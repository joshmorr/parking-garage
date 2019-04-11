package com.example.parkinggarage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.presenter.MainActivityPresenter;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseApp.initializeApp(getApplicationContext());

        final MainActivityPresenter presenter = new MainActivityPresenter(MainActivity.this, this);

        TextInputEditText usernameField = findViewById(R.id.usernameEditText);
        usernameField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                TextInputEditText passwordField = findViewById(R.id.passwordEditText);
                passwordField.requestFocus();
                return true;
            }

        });

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText usernameField = findViewById(R.id.usernameEditText);
                TextInputEditText passwordField = findViewById(R.id.passwordEditText);

                boolean isManager = false;
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                if (radioGroup.getCheckedRadioButtonId() == R.id.managerButton)
                    isManager = true;

                presenter.login(isManager, usernameField.getText().toString(), passwordField.getText().toString());

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

    public void startManagerActivity() {
        Intent intent = new Intent(this, ManagerActivity.class);
        startActivity(intent);
    }

    public void startSetUpActivity() {
       Intent intent = new Intent(this, ManagerSetupActivity.class);
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

    @Override
    public void showFailedLoginDialog() {
        ImageView view = new ImageView(MainActivity.this);
        view.setImageResource(R.drawable.gandalf);
        CustomDialog cd = new CustomDialog(MainActivity.this, getString(R.string.failed_login_dialog_title),  getString(R.string.failed_login_dialog_message), view);
        cd.getBuilder().create().show();
    }
}