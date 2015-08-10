package com.ankit.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class WelcomeActivity extends ActionBarActivity {
    private EditText firstNumber, secondNumber;
    private TextView total;
    private Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Deckard");


        final View button = findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            }
        });
        firstNumber = (EditText) findViewById(R.id.firstNumber);
        secondNumber = (EditText) findViewById(R.id.secondNumber);
        addButton = (Button) findViewById(R.id.addButton);
        total = (TextView) findViewById(R.id.total);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumberResult = firstNumber.getText().toString();
                String secondNumberResult = secondNumber.getText().toString();
                if(firstNumberResult.equals(""))
                {
                    firstNumberResult = "0";
                }
                if(secondNumberResult.equals(""))
                {
                    secondNumberResult = "0";
                }

                Integer totalResult = Integer.parseInt(firstNumberResult) +
                        Integer.parseInt(secondNumberResult);
                total.setText("Total = " + Integer.toString(totalResult));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                return true;

            case R.id.item2:
                Toast.makeText(this, "Clicked Item 4", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public EditText getFirstNumber() {
        return firstNumber;
    }
    public EditText getSecondNumber() {
        return secondNumber;


    }
    public Button getAddButton() {
        return addButton;
    }
    public TextView getTotal() {
        return total;


    }
}
