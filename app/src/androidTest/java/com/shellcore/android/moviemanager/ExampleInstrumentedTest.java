package com.shellcore.android.moviemanager;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.shellcore.android.moviemanager.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.shellcore.android.moviemanager", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(
            MainActivity.class, true, true
    ){};

    @Test
    public void validateRecyclerViewClickSecondElement() {
        onView(withId(R.id.rec_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
    }

    @Test
    public void validateRecyclerViewClickThirdElement() {
        onView(withId(R.id.rec_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
    }
}
