package com.example.parkinggarage.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    Account account;
    String password;
    String incorrectInput;

    @Before
    public void setup() {
        account = new Account();
        password = "password1";
        account.setPassword(password);
    }

}
