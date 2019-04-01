package com.example.parkinggarage.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Account;
import com.example.parkinggarage.ui.CustomDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(getApplicationContext());
        final FirebaseFirestore database = FirebaseFirestore.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextInputEditText usernameField = findViewById(R.id.usernameEditText);
        TextInputEditText passwordField = findViewById(R.id.passwordEditText);

        usernameField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                TextInputEditText passwordField = findViewById(R.id.passwordEditText);
                passwordField.requestFocus();
                return true;
            }

        });


        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText usernameField = findViewById(R.id.usernameEditText);
                TextInputEditText passwordField = findViewById(R.id.passwordEditText);

                final String username = usernameField.getText().toString();
                final String password = passwordField.getText().toString();

                final CollectionReference cr = database.collection("accounts");
                ImageView view = new ImageView(MainActivity.this);
                view.setImageResource(R.drawable.gandalf);
                CustomDialog cd = new CustomDialog(MainActivity.this, getString(R.string.failed_login_dialog_title),  getString(R.string.failed_login_dialog_message), view);
                final AlertDialog dialog = cd.getBuilder().create();
                cr.whereEqualTo("username", username).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult() == null) {
                                dialog.show();
                                Log.d(TAG, "Task result is null");
                            }
                            else if (task.getResult().getDocuments() == null){
                                dialog.show();
                                Log.d(TAG, "DocumentSnapshot list is null");
                            }
                            else if (task.getResult().getDocuments().size() == 0){
                                dialog.show();
                                Log.d(TAG, "DocumentSnapshot list is has no elements");
                            }
                            else {
                                Log.d(TAG, "Username exists!");
                                DocumentSnapshot document = task.getResult().getDocuments().get(0);
                                if (document.get("password").equals(password)) {
                                    Log.d(TAG, "Password matches!");
                                    if (document.get("isManager").equals(true)) {
                                        Map<String, Object> map = document.getData();
                                        Account account = new Account.Builder()
                                                .setFirstname((String) map.get("firstname"))
                                                .setLastname((String) map.get("lastname"))
                                                .setUsername((String) map.get("username"))
                                                .setPassword((String) map.get("password"))
                                                .setIsManager((boolean) map.get("isManager"))
                                                .create();
                                        startManagerActivity(account);
                                    }
                                }
                                else {
                                    dialog.show();
                                    Log.d(TAG, "Password does not match");
                                }

                            }
                        }
                        else {
                            dialog.show();
                            Log.d(TAG, "Could not complete task!");
                        }
                    }
                });
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

    public void startManagerActivity(Account account) {
        Intent intent = new Intent(this, ManagerActivity.class);
        intent.putExtra("account", account);
        startActivity(intent);
    }

    public void startSetUpActivity() {
       Intent intent = new Intent(this, ManagerAccountSetupActivity.class);
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