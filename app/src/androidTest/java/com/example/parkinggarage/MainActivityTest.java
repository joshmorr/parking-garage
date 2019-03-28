package com.example.parkinggarage;

import android.support.test.runner.AndroidJUnit4;

import com.example.parkinggarage.activities.MainActivity;
import com.example.parkinggarage.model.Account;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class MainActivityTest {
    private String str;
    FirebaseFirestore db;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        str = "Espresso";
        FirebaseApp.initializeApp(activityRule.getActivity().getApplicationContext());
        db = FirebaseFirestore.getInstance();
    }

    @Test
    public void changeTextUsername() {
        onView(withId(R.id.usernameInputEditText)).perform(typeText(str));
        onView(withId(R.id.usernameInputEditText)).check(matches(withText(str)));
    }

    @Test
    public void changeTextPassword() {
        onView(withId(R.id.passwordInputEditText)).perform(typeText(str));
        onView(withId(R.id.passwordInputEditText)).check(matches(withText(str)));
    }


}
