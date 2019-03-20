package com.example.parkinggarage.model;

import java.util.HashMap;

public class Accounts {
    private HashMap<String, Account> accountsMap;

    public Accounts() {
        accountsMap = new HashMap<String, Account>();
    }

    public boolean addAccount(Account account) {
        if (accountsMap.containsKey(account.getUsername())) {
            return false;
        }
        accountsMap.put(account.getUsername(), account);
        return true;
    }

    public boolean attemptLogin(String username, String password) {
        if (!accountsMap.containsKey(username))
            return false;
        if (!accountsMap.get(username).getPassword().equals(password))
            return false;
        return true;
    }

}
