package com.example.testmobil

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule
import org.junit.Test
import com.example.testmobil.MainActivity
import com.example.testmobil.SecondActivity
import com.example.testmobil.R

class ActivityNavigationTest {

    @Rule
    @JvmField
    var intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun testNavigateToSecondActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_to_next_activity)).perform(click())
        intended(hasComponent(SecondActivity::class.java.name))
        activityScenario.close()
    }
}
