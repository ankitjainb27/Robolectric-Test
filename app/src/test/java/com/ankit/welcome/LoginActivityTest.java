package com.ankit.welcome;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by ankitjain on 10/08/15.
 * file:///Users/ankitjain/AndroidStudioProjects/Welcome/app/build/reports/tests/debug/classes/com.ankit.welcome.LoginActivityTest.html
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginActivityTest {

    private LoginActivity Lactivity;

    @Before
    public void setup() {
        Lactivity = Robolectric.buildActivity(LoginActivity.class).get();
    }

    @Test
    public void shouldNotBeNull() {
        LoginActivity Lactivity = Robolectric.setupActivity(LoginActivity.class);
        assertThat(Lactivity).isNotNull();

        TextView textView = (TextView) Lactivity.findViewById(R.id.textView);
        assertThat(textView).isNotNull();

        Button button = (Button) Lactivity.findViewById(R.id.button);
        assertThat(button).isNotNull();

        EditText editText = (EditText) Lactivity.findViewById(R.id.editText);
        assertThat(editText).isNotNull();
    }

    @Test
    public void shouldProduceGreetingWhenButtonPressed() {
        LoginActivity Lactivity = Robolectric.setupActivity(LoginActivity.class);

        TextView textView = (TextView) Lactivity.findViewById(R.id.textView);
        Button button = (Button) Lactivity.findViewById(R.id.button);
        EditText editText = (EditText) Lactivity.findViewById(R.id.editText);

        editText.setText("Peter");
        button.performClick();
        assertEquals("Hello, Peter!", textView.getText().toString());
        assertThat(textView.getText().toString()).isEqualTo("Hello, Peter!");
        assertThat(textView.getText().toString()).contains("Hello, Peter!");

    }


}
