package edu.wmich.lab3jvandyk5713;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/*
*************************************
* Programmer: John VanDyke
* Class ID: jvandyk5713
* Lab #3: Sensory Explosion
* CIS 2610: Business Mobile Programming
* Fall 2015
* Due date: 11/12/15
* Date completed: 11/12/15
*************************************
* The SplashActivity.java shows the app logo for 3 seconds and then redirects to MainActivity.java.
* The way the activity accomplishes this is by setting a TimeTask.  The TimerTask tells the application
* to "kill" the app after 3000 milliseconds so the page isn't loaded when the user opens the application
* at a later time, assuming they didn't completely close the application.
*************************************
*/

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //creating the TimerTask to load the page
        TimerTask loading = new TimerTask( ){

            @Override
            public void run() {
                //finish will kill the application and put it at the bottom of the stack
                finish();
                //this method tells the application to open the MainActivity after the SplashActivity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        };

        //Timer is where the time is set.  A new Timer is created on a schedule of 3000 milliseconds
        Timer opening = new Timer( );
        opening.schedule(loading, 3000);
    }
}

