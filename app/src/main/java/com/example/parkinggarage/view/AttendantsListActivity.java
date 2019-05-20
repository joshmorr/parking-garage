package com.example.parkinggarage.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.parkinggarage.R;
import com.example.parkinggarage.model.Attendant;
import com.example.parkinggarage.presenter.AttendantsListPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AttendantsListActivity extends AppCompatActivity implements AttendantsListPresenter.View {
    private FirebaseFirestore database;
    private String username;
    private AttendantsListPresenter presenter;
    private ListView listView;
    private ArrayAdapter adapter;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendants_list);
        Toolbar toolbar = findViewById(R.id.toolbar);

        FirebaseApp.initializeApp(AttendantsListActivity.this);
        database = FirebaseFirestore.getInstance();

        listView = findViewById(R.id.attendantsListView);

        username = getIntent().getExtras().getString("username");
        presenter = new AttendantsListPresenter(database, this, username);

        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setView(R.layout.dialog_attendant_setup)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
        });
        dialog = dialogBuilder.create();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.create();
            }
        });
    }

    @Override
    public void setListAdapter(ArrayList<Attendant> attendantsList) {
        adapter = new ArrayAdapter<>(this, R.layout.list_item, attendantsList);
        listView.setAdapter(adapter);
    }

    @Override
    public void showDialog() {
        dialog.show();
    }
}