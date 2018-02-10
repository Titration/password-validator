package com.example.shan.password_validator;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by SHAN on 18/2/10.
 */

public class ValidatorEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void case1() {
        //input password in EditText
        onView(withId(R.id.password)).perform(typeText("1111shan"));
        //close keyboard
        Espresso.closeSoftKeyboard();
        //perform button
        onView(withId(R.id.validate)).perform(click());
        //checking the text in TextView
        onView(withId(R.id.strength)).check(matches(withText("Password strength: 3 not strong enough.")));
    }

    @Test
    public void case2() {
        //input password in EditText
        onView(withId(R.id.password)).perform(typeText("1111ShanXue"));
        //close keyboard
        Espresso.closeSoftKeyboard();
        //perform button
        onView(withId(R.id.validate)).perform(click());
        //checking the text in TextView
        onView(withId(R.id.strength)).check(matches(withText("Password strength: 4 not strong enough.")));
    }

    @Test
    public void case3() {
        //input password in EditText
        onView(withId(R.id.password)).perform(typeText("1111@ShanXue"));
        //close keyboard
        Espresso.closeSoftKeyboard();
        //perform button
        onView(withId(R.id.validate)).perform(click());
        //checking the text in TextView
        onView(withId(R.id.strength)).check(matches(withText("Password strength level: 5. Strong")));
    }

    @Test
    public void case4() {
        //input password in EditText
        onView(withId(R.id.password)).perform(typeText("1111"));
        //close keyboard
        Espresso.closeSoftKeyboard();
        //perform button
        onView(withId(R.id.validate)).perform(click());
        //checking the text in TextView
        onView(withId(R.id.strength)).check(matches(withText("Password strength: 2 not strong enough.")));
    }

    @Test
    public void case5() {
        //input password in EditText
        onView(withId(R.id.password)).perform(typeText("password"));
        //close keyboard
        Espresso.closeSoftKeyboard();
        //perform button
        onView(withId(R.id.validate)).perform(click());
        //checking the text in TextView
        onView(withId(R.id.strength)).check(matches(withText("Password strength: 1 not strong enough.")));
    }

    @Test
    public void case6() {
        //input password in EditText
        onView(withId(R.id.password)).perform(typeText("!@#$%^"));
        //close keyboard
        Espresso.closeSoftKeyboard();
        //perform button
        onView(withId(R.id.validate)).perform(click());
        //checking the text in TextView
        onView(withId(R.id.strength)).check(matches(withText("Password strength: 2 not strong enough.")));
    }


}