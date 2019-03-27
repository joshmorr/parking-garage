package com.example.parkinggarage.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountsTest {
    ParkingGarageSystem system;
    Accounts accounts;

    @Before
    public void setUp() {
        system = new ParkingGarageSystem();
        accounts = new Accounts();
    }

    @Test
    public void successfulLoginReturnsTrue() {
        assertTrue(accounts.attemptLogin("jmorris1", "password1"));
    }

    @Test
    public void failedLoginWrongUsernameReturnsFalse() {
        assertFalse(accounts.attemptLogin("jmorris2", "password2"));
    }

    @Test
    public void failedLoginWrongPasswordReturnsFalse() {
        assertFalse(accounts.attemptLogin("password2", "password2"));
    }
}
