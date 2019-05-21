package com.example.parkinggarage.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.InputStrings;
import com.example.parkinggarage.model.Manager;
import com.example.parkinggarage.presenter.AttendantsListActivityPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AttendantsListActivity extends AppCompatActivity implements AttendantsListActivityPresenter.View {
    private FirebaseFirestore database;
    private String username;
    private Manager manager;
    private AttendantsListActivityPresenter presenter;
    private ListView listView;
    private ArrayAdapter adapter;
    private FloatingActionButton fab;
    private Intent intent;

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendants_list);
        Toolbar toolbar = findViewById(R.id.toolbar);

        FirebaseApp.initializeApp(AttendantsListActivity.this);
        database = FirebaseFirestore.getInstance();

        listView = findViewById(R.id.attendantsListView);
        fab = findViewById(R.id.fab);

        username = getIntent().getExtras().getString("username");
        manager = (Manager) getIntent().getExtras().get("manager");

        presenter = new AttendantsListActivityPresenter(database, this, username);

        intent = new Intent(this, AccountSetupActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("managerSetup", false);
        intent.putExtra("manager", manager);

        presenter.updateList();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.fabClick();
            }
        });
    }

    @Override
    public void setListAdapter(ArrayList<String> usernameList) {
        adapter = new ArrayAdapter<>(this, R.layout.list_item, usernameList);
        listView.setAdapter(adapter);
    }

    @Override
    public void startAccountSetupActivity() {
        startActivity(intent);
    }


}