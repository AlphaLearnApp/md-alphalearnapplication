package com.aplhaacademy.alphalearn.ui.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import com.aplhaacademy.alphalearn.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSeeAllTryOutButton() {
        // Memastikan bahwa button "See All TryOut" dapat diklik
        onView(withId(R.id.tv_see_all_try_out)).perform(click())
    }

    @Test
    fun testSeeAllCourseButton() {
        // Memastikan bahwa button "See All Course" dapat diklik
        onView(withId(R.id.tv_see_all_course)).perform(click())
    }
}