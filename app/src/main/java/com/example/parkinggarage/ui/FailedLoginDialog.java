package com.example.parkinggarage.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ImageView;

import com.example.parkinggarage.R;

import static android.app.AlertDialog.*;

public class FailedLoginDialog {
    private Builder builder;
    private AlertDialog dialog;
    private final String title;
    private final String message;
    private ImageView view;

    public FailedLoginDialog(Context context) {
        builder = new Builder(context);
        title = context.getString(R.string.failed_login_dialog_title);
        message = context.getString(R.string.failed_login_dialog_message);
        view = new ImageView(context);
        view.setImageResource(R.drawable.gandalf);
        dialog = create();
    }

    private AlertDialog create() {
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setView(view);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder.create();
    }

    public Builder getBuilder() {
        return builder;
    }

    public AlertDialog getDialog() {
        return dialog;
    }
}
