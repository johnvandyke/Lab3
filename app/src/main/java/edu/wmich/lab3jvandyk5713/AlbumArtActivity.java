package edu.wmich.lab3jvandyk5713;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
* There is nothing done in this Java file, besides setting the view to the XML layout file, where
* a background image is being set.
*************************************
*/
public class AlbumArtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView is how the layout file is connected to the Activity
        setContentView(R.layout.activity_album_art);
    }
}
