package com.example.parkinggarage.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ImageView;

import com.example.parkinggarage.R;

public class CustomDialog {
    private Context context;
    private AlertDialog dialog;
    private String title;
    private String message;
    private ImageView view;

    public CustomDialog(Context context, String title, String message) {
        this.context = context;
        this.title = title;
        this.message = message;
        view = null;
    }

    public CustomDialog(Context context, String title, String message, ImageView view) {
        this.context = context;
        this.title = title;
        this.message = message;
        this.view = view;
    }

    public AlertDialog.Builder getBuilder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        if (view != null) {
            builder.setView(view);
        }
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder;
    }
}
