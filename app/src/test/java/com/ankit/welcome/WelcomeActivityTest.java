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
 * Running test using Terminal - ./gradlew test
 */
/*Assert commands used
1)assertThat(activity).isNotNull();
2)assertThat(hello).isEqualTo("Hello world!");
3)assertThat(shadowOf(activity).getNextStartedActivity()).isEqualTo(expectedIntent);
4)assertThat(textView.getText().toString()).contains("Hello, Peter!");
5)assertEquals(LoginActivity.class.getCanonicalName(), intent.getComponent().getClassName());
6)assertTrue("TextView contains incorrect text", activity.getTitle().toString().equals("Deckard"));
*/
/*Other Assert commands
http://developer.android.com/reference/junit/framework/Assert.html
http://junit.sourceforge.net/javadoc/org/junit/Assert.html

1)assertEquals(String message, char expected, char actual)
1.1)assertArrayEquals(char[] expecteds, char[] actuals)
          Asserts that two char arrays are equal.
2)assertFalse(String message, boolean condition)
3)assertNotNull(String message, Object object)
4)assertNotSame(String message, Object expected, Object actual)
        Asserts that two objects do not refer to the same object.
5)assertNull(String message, Object object)
        Asserts that an object is null.
6)assertSame(String message, Object expected, Object actual)
        Asserts that two objects refer to the same object.
7)assertTrue(String message, boolean condition)
        Asserts that a condition is true.
8)fail(String message)
       Fails a test with the given message.
9)failNotEquals(String message, Object expected, Object actual)
10)failNotSame(String message, Object expected, Object actual)
11)failSame(String message)
*/

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class WelcomeActivityTest {
    private WelcomeActivity activity;

    @Before
    public void setup() {
        // activity = Robolectric.buildActivity(WelcomeActivity.class).create().get();
        activity = Robolectric.buildActivity(WelcomeActivity.class).get();
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        // assertNotNull("WelcomeActivity is not instantiated", activity);
        assertThat(activity).isNotNull();
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
        assertTrue("TextView contains incorrect text", activity.getTitle().toString().equals("Deckard"));
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
        assertThat(text).isNotNull();
        assertThat(text.getText().toString()).isEqualTo("Welcome");
    }

    @Test
    public void testClickAddButton_withPositiveValues() {
        WelcomeActivity calculator = Robolectric.setupActivity(WelcomeActivity.class);
        calculator.getFirstNumber().setText("1");
        calculator.getSecondNumber().setText("2");
        calculator.getAddButton().performClick();
        assertEquals("Total = 3", calculator.getTotal().getText().toString());
    }

    @Test
    public void testClickAddButton_withEmptyValue() {
        WelcomeActivity calculator = Robolectric.setupActivity(WelcomeActivity.class);

        // calculator.onCreate(new Bundle());
        calculator.getFirstNumber().setText("");
        calculator.getSecondNumber().setText("");
        calculator.getAddButton().performClick();
        assertEquals("Total = 0", calculator.getTotal().getText().toString());
    }


}