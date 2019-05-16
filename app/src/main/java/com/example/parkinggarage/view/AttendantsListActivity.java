package com.example.parkinggarage.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.parkinggarage.R;
import com.example.parkinggarage.presenter.AttendantsListPresenter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

public class AttendantsListActivity extends AppCompatActivity implements AttendantsListPresenter.View {
    private LinearLayout layout;

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendants_list);
        Toolbar toolbar = findViewById(R.id.toolbar);

        FirebaseApp.initializeApp(AttendantsListActivity.this);
        final FirebaseFirestore database = FirebaseFirestore.getInstance();

        AttendantsListPresenter presenter = new AttendantsListPresenter(database, this);

        final String username = getIntent().getExtras().getString("username");

        layout = findViewById(R.id.linearLayout);

        final ButtonFactory buttonFactory = new ButtonFactory(AttendantsListActivity.this);
        presenter.getAttendantsList(username, buttonFactory);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.dialog_attendant_setup)
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
        final AlertDialog dialog = builder.create();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

    }

    @Override
    public void addViewToLayout(Button button) {
        layout.addView(button);
    }
}