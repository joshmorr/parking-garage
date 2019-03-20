package com.example.parkinggarage.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountsTest {
    ParkingGarageSystem system;
    Accounts accounts;
    Account account1;

    @Before
    public void setUp() {
        system = new ParkingGarageSystem();
        accounts = new Accounts();
        account1 = new Account("John", "jsmith1", "password1");
        accounts.addAccount(account1);
    }

    @Test
    public void successfulLoginReturnsTrue() {
        assertTrue(accounts.attemptLogin(account1.getUsername(), account1.getPassword()));
    }

    @Test
    public void failedLoginWrongUsernameReturnsFalse() {
        assertFalse(accounts.attemptLogin("jsmith2", account1.getPassword()));
    }

    @Test
    public void failedLoginWrongPasswordReturnsFalse() {
        assertFalse(accounts.attemptLogin(account1.getUsername(), "password2"));
    }
}
