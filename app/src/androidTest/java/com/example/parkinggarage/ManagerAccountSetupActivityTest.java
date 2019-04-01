package com.example.parkinggarage;

import com.example.parkinggarage.activities.ManagerAccountSetupActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class ManagerAccountSetupActivityTest {
    private FirebaseFirestore database;
    private String str;

    @Rule
    public ActivityTestRule<ManagerAccountSetupActivity> activityRule = new ActivityTestRule<>(ManagerAccountSetupActivity.class);

    @Before
    public void setup() {
        str = "Hello";
    }

    @Test
    public void addAccountCorrectInput() {
        FirebaseApp.initializeApp(activityRule.getActivity().getApplicationContext());
        database = FirebaseFirestore.getInstance();
        onView(withId(R.id.firstnameEditText)).perform(replaceText("Joshua"));
        onView(withId(R.id.lastnameEditText)).perform(replaceText("Morris"));
        onView(withId(R.id.usernameEditText)).perform(replaceText("morrj1"));
        onView(withId(R.id.passwordEditText)).perform(replaceText("password1"));
        onView(withId(R.id.nextButton)).perform(click());
    }


    @Test
    public void changeTextFirstname() {
        onView(withId(R.id.firstnameEditText)).perform(replaceText(str));
        onView(withId(R.id.firstnameEditText)).check(matches(withText(str)));
    }

    @Test
    public void changeTextLastname() {
        onView(withId(R.id.lastnameEditText)).perform(replaceText(str));
        onView(withId(R.id.lastnameEditText)).check(matches(withText(str)));
    }

    @Test
    public void changeTextUsername() {
        onView(withId(R.id.usernameEditText)).perform(replaceText(str));
        onView(withId(R.id.usernameEditText)).check(matches(withText(str)));
    }

    @Test
    public void changeTextPassword() {
        onView(withId(R.id.passwordEditText)).perform(replaceText(str));
        onView(withId(R.id.passwordEditText)).check(matches(withText(str)));
    }

}
