package com.example.ahill.higherorlower;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class HigherOrLowerActivity extends AppCompatActivity {

    /** The random number the user is to guess */
    private int randomNumber = 0;

    public void userGuess(View view) {
        Log.i("Info", "My number is " + randomNumber);

        // get the users EditText and check if it's null
        EditText userInput = (EditText) findViewById(R.id.usersNumber);

        if(isNullOrEmpty(userInput)) {
            // if the user hasn't entered a text let them know and return from this method
            Toast.makeText(getApplicationContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        // retrieve the users guess from the text input
        int userGuessed = Integer.parseInt(userInput.getText().toString());

        // declare a string to display to the user
        String displayToUser = "";

        if(userGuessed < randomNumber) {
            // the user guessed too low
            displayToUser = "My number is higher!";

        } else if(userGuessed > randomNumber) {
            // the user guess too high
            displayToUser = "My number is lower!";

        } else {
            // the user got the correct answer
            displayToUser = "You guessed it!";

            // create a new random number
            setRandomNumber();
        }

        // display our message to the user
        Toast.makeText(getApplicationContext(), displayToUser, Toast.LENGTH_LONG).show();
    }

    /**
     * Checks to see if the given {@link EditText} is null or has a null value.
     * @param editText
     * @return
     */
    private boolean isNullOrEmpty(EditText editText) {
        return editText == null || editText.getText() == null || editText.getText().toString().equals("");
    }

    /**
     * Sets the random number to be guessed by the user
     */
    private void setRandomNumber() {
        randomNumber = new Random().nextInt(20) + 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_higher_or_lower);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // create our random number for this game
        setRandomNumber();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_higher_or_lower, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
