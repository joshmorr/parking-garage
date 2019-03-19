package com.example.parkinggarage.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LoginTest {
    ParkingGarageSystem system;
    HashMap<String, Account> accounts;
    Account account1;

   @Before
   public void setUp() {
       system = new ParkingGarageSystem();
       accounts = new HashMap<>();
       account1 = new Account("John", "jsmith1", "password1");
       accounts.put(account1.getUsername(), account1);

   }

    @Test
    public void successfulLoginAccountNotNull() {
        Login login = new Login(accounts, account1.getUsername(), account1.getPassword());
        login.attemptLogin();
        assertNotNull(login.getAccount());
    }

   @Test
   public void successfulLoginAccountsMatch() {
       Login login = new Login(accounts, account1.getUsername(), account1.getPassword());
       login.attemptLogin();
       assertEquals(login.getAccount(), account1);
   }

}
