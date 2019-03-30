package com.example.parkinggarage;

import com.example.parkinggarage.activities.ManagerAccountSetupActivity;

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
public class ManagerAccountSetupActivityTest {
    private String str;


    @Rule
    public ActivityTestRule<ManagerAccountSetupActivity> activityRule = new ActivityTestRule<>(ManagerAccountSetupActivity.class);

    @Before
    public void setup() {
        str = "Hello";

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
