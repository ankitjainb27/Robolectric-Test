package com.ankit.welcome;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

/**
 * file:///Users/ankitjain/AndroidStudioProjects/Welcome/app/build/reports/tests/debug/classes/com.ankit.welcome.WelcomeActivityTest.html
 *Running test using Terminal - ./gradlew test
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class WelcomeActivityTest {
    private WelcomeActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(WelcomeActivity.class)
                .create().get();
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull("WelcomeActivity is not instantiated", activity);
    }

    @Test
    public void shouldHaveHappySmiles() throws Exception {
        String hello = new WelcomeActivity().getResources().getString(R.string.hello_world);
        assertThat(hello).isEqualTo("Hello world!");
    }

    @Test
    public void buttonClickShouldStartNewActivity() throws Exception {
        WelcomeActivity activity = Robolectric.setupActivity(WelcomeActivity.class);
        Button button = (Button) activity.findViewById(R.id.login);
        assertNotNull(button);
        button.performClick();
        Intent intent;
        intent = shadowOf(activity).peekNextStartedActivity();
        assertEquals(LoginActivity.class.getCanonicalName(), intent.getComponent().getClassName());
    }

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
        assertTrue("TextView contains incorrect text",activity.getTitle().toString().equals("Deckard"));
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