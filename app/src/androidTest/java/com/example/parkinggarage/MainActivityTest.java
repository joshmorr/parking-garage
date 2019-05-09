package com.example.parkinggarage;

import android.content.Context;

import com.example.parkinggarage.activities.MainActivity;
import com.google.firebase.firestore.FirebaseFirestore;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class MainActivityTest {
    private String str;
    private Context context;
    private FirebaseFirestore db;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() {
        str = "Hello";
    }

    @Test
    public void setupButton_opens_ManagerAccountSetupActivity_on_click() {
        onView(withId(R.id.setupButton)).perform(click());
        onView(withId(R.id.managerAccountSetupToolbar)).check(matches(isDisplayed()));
    }

    @Test
    public void changeTextUsername() {
        onView(withId(R.id.usernameEditText)).perform(typeText(str));
        onView(withId(R.id.usernameEditText)).check(matches(withText(str)));
    }

    @Test
    public void changeTextPassword() {
        onView(withId(R.id.passwordEditText)).perform(typeText(str));
        onView(withId(R.id.passwordEditText)).check(matches(withText(str)));
    }



}
