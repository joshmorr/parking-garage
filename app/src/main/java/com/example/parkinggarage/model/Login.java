package com.example.parkinggarage.model;

import java.util.HashMap;

public class Login {
    private HashMap<String, Account> accounts;
    private Account account;
    private String username;
    private String password;


    public Login(HashMap<String, Account> accounts, String username, String password) {
        this.accounts = accounts;
        this.username = username;
        this.password = password;
        account = null;
    }

    public void attemptLogin() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
