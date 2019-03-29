package com.example.parkinggarage;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import com.example.parkinggarage.activities.MainActivity;
import com.example.parkinggarage.firebase.Login;
import com.example.parkinggarage.model.Account;
import com.google.firebase.FirebaseApp;
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
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class MainActivityTest {
    private String str;
    private Context context;
    private FirebaseFirestore db;
    private Login login;


    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() {
        str = "Hello darkness my old friend";
        context = activityRule.getActivity().getApplicationContext();
        FirebaseApp.initializeApp(context);
        db = FirebaseFirestore.getInstance();
    }

    @Test
    public void loginCorrect() {
        String username = "morrj1";
        String password = "password1";
        onView(withId(R.id.usernameInputEditText)).perform(typeText("morrj1"));
        onView(withId(R.id.passwordInputEditText)).perform(typeText("password1"));
        onView(withId(R.id.loginButton)).perform(click());
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
