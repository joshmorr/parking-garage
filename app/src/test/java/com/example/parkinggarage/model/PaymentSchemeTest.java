package com.example.parkinggarage.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentSchemeTest {
    private PaymentScheme paymentScheme;

    @Before
    public void setUp() {
        paymentScheme = new PaymentScheme();
    }

    @Test
    public void getRateMotorcycleMatches() {
        assertEquals(paymentScheme.getMotorcycleHourly(), paymentScheme.getRate(Category.MOTORCYCLE), 0);
    }

    @Test
    public void getRateCarMatches() {
        assertEquals(paymentScheme.getCarHourly(), paymentScheme.getRate(Category.CAR), 0);
    }

    @Test
    public void getRateTruckMatches() {
        assertEquals(paymentScheme.getTruckHourly(), paymentScheme.getRate(Category.TRUCK), 0);
    }


}