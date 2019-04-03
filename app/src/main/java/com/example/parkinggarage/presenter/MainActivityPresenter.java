package com.example.parkinggarage.presenter;

public class MainActivityPresenter {
    private View view;

    public MainActivityPresenter(View view) {
        this.view = view;
    }

    public void login(String username, String password) {

    }

    public interface View {
        void showFailedLoginDialog();
    }

}
