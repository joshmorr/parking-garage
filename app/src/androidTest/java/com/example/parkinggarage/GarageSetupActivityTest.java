package com.example.parkinggarage;

import com.example.parkinggarage.activities.GarageSetupActivity;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
public class GarageSetupActivityTest {

    @Rule
    public ActivityTestRule<GarageSetupActivity> activityRule = new ActivityTestRule<>(GarageSetupActivity.class);

    @Test
    public void spaceButtonChangesCategoryWhenClicked() {

    }

}
