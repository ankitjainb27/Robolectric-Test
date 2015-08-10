package com.ankit.welcome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ankitjain on 10/08/15.
 */
public class LoginActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.textView);
                EditText editText = (EditText) findViewById(R.id.editText);

                textView.setText(String.format("Hello, %s!", editText.getText()));
            }
        });

    }
}
