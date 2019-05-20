package com.example.parkinggarage.view;

import android.content.Context;
import android.os.Build;
import android.widget.Button;

import com.example.parkinggarage.R;

public class ButtonFactory {
    private Context context;

    public ButtonFactory(Context context) {
        this.context = context;
    }

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.M)
    public Button getButton(String text) {
        Button button = new Button(context);
        button.setText(text);
        button.setBackgroundResource(R.drawable.rectangle);
        button.setTextAppearance(R.style.Widget_AppCompat_Button);
        button.setTextSize(14);
        return button;
    }

}
