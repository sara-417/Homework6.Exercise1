package com.slayton.msu.criminalintent

import androidx.fragment.app.testing.launchFragmentInContainer
import org.junit.Assert.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText


import org.junit.After
import org.junit.Before
import org.junit.Test

class CrimeDetailsFragmentTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun changesInViewsReflectedInCrimeObject() {

        val fragmentScenario = launchFragmentInContainer<CrimeDetailsFragment>()
        val expectedTitle = "Title!"
        val expectedIsSovled = true

        // perform typing the title and checking the solved box
        onView(withId(R.id.crime_title)).perform(typeText("Title!"))
        onView(withId(R.id.crime_solved)).perform(click())

        fragmentScenario.onFragment { fragment ->

            //grab the properties' actual values
            val actualTitle = fragment.crime.title
            val actualIsSolved = fragment.crime.isSolved

            //assert that the expected values and the actual values match
            assertEquals(expectedTitle, actualTitle)
            assertEquals(expectedIsSovled, actualIsSolved)
        }
    }
// notes on what to say
    // used Android Studio documentation + chatGPT to help me understand how to use fragmentScenario
    // chatGPT lead me astray in a couple of different directions and I had to find my way out of them
}