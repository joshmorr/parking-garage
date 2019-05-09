package com.example.parkinggarage;

import com.example.parkinggarage.view.ManagerSetupActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class ManagerSetupActivityTest {
    private String str;
    @Rule
    public ActivityTestRule<ManagerSetupActivity> activityRule = new ActivityTestRule<>(ManagerSetupActivity.class);

    @Before
    public void setup() {
        str = "Hello";
    }

    @Test
    public void changeTextFirstname() {
        onView(withId(R.id.firstnameEditText)).perform(replaceText(str));
        onView(withId(R.id.firstnameEditText)).check(matches(hasErrorText("You must enter a first name!")));
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
        onView(withId(R.id.usernameEditText)).perform(replaceText(str));
        onView(withId(R.id.usernameEditText)).check(matches(withText(str)));
    }

}
