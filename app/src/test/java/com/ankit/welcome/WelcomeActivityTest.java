package com.ankit.welcome;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

/**
 * file:///Users/ankitjain/AndroidStudioProjects/Welcome/app/build/reports/tests/debug/classes/com.ankit.welcome.WelcomeActivityTest.html
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class WelcomeActivityTest {

    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        WelcomeActivity activity = Robolectric.setupActivity(WelcomeActivity.class);
        activity.findViewById(R.id.login).performClick();

        Intent expectedIntent = new Intent(activity, LoginActivity.class);
        assertThat(shadowOf(activity).getNextStartedActivity()).isEqualTo(expectedIntent);
    }

    @Test
    public void titleIsCorrect() throws Exception {
        WelcomeActivity activity = Robolectric.setupActivity(WelcomeActivity.class);
        assertTrue(activity.getTitle().toString().equals("Deckard"));
    }

    @Test
    public void onCreate_shouldInflateTheMenu() throws Exception {
        WelcomeActivity activity = Robolectric.setupActivity(WelcomeActivity.class);


        final Menu menu = shadowOf(activity).getOptionsMenu();
        assertThat(menu.findItem(R.id.item1).getTitle()).isEqualTo("First menu item");
        assertThat(menu.findItem(R.id.item2).getTitle()).isEqualTo("Second menu item");
    }

    @Test
    public void clickMenuItem_shouldDelegateClickToFragment() {
        final WelcomeActivity activity = Robolectric.setupActivity(WelcomeActivity.class);

        shadowOf(activity).clickMenuItem(R.id.item2);
        assertThat(ShadowToast.getTextOfLatestToast()).isEqualTo("Clicked Item 4");
    }

    @Test
    public void shouldUseCorrectApplicatioName() throws Exception {
        Activity activity = Robolectric.setupActivity(WelcomeActivity.class);

        final TextView text = (TextView) activity.findViewById(R.id.text);
        assertThat(text.getText().toString()).isEqualTo("Welcome");
    }

}