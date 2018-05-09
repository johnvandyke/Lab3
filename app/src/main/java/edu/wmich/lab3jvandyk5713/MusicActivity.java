package edu.wmich.lab3jvandyk5713;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MusicActivity extends AppCompatActivity {
    Button btnPlayCardinals, btnPlayCigarettesAndSaints;
    MediaPlayer mpCardinals, mpCigarettesAndSaints;
    int playing;

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
* This Activity is responsible for playing the music that is apart of the app via a MediaPlayer.
*************************************
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        //btnPlayCardinals is the variable for the button that plays the first song
        btnPlayCardinals = (Button) findViewById(R.id.buttonPlayCardinals);
        //btnPlayCigarettesAndSaints is the variable for the button that plays the second song
        btnPlayCigarettesAndSaints = (Button) findViewById(R.id.buttonPlayCigarettesAndSaints);
        //bPlayCardinals is the onClickListener for the first song so the button has functionality
        btnPlayCardinals.setOnClickListener(bPlayCardinals);
        //bPlayCigarettesAndSaints arms the btnCigarettesAndSaints butto so it can be clicked
        btnPlayCigarettesAndSaints.setOnClickListener(bPlayCigarettesAndSaints);
        mpCardinals = new MediaPlayer();
        mpCardinals = MediaPlayer.create(this, R.raw.cardinals);
        mpCigarettesAndSaints = new MediaPlayer();
        mpCigarettesAndSaints = MediaPlayer.create(this, R.raw.cigarettesandsaints);
        playing = 0;
        }

        Button.OnClickListener bPlayCardinals= new Button.OnClickListener(){
            @Override
        public void onClick (View v) {
                switch(playing) {
                    case 0:
                        //this variable tells the MediaPlayer to play the song
                        mpCardinals.start();
                        playing = 1;
                        //sets the text in the button to tell the user to pause the song
                        btnPlayCardinals.setText("Pause Cardinals");
                        //sets the button for the second song as invisible so only one song can be played
                        btnPlayCigarettesAndSaints.setVisibility(View.INVISIBLE);
                        //Toast message to tell the user that they are listing to the song
                        Toast.makeText(MusicActivity.this, "You are now listening to Cardinals", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //pauses the song that is being played
                        mpCardinals.pause();
                        playing =0;
                        //when paused, the text in the button is set to tell the user to play the song
                        btnPlayCardinals.setText("Play Cardinals");
                        //sets the play button for the second song as visible when the first song is paused
                        btnPlayCigarettesAndSaints.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };
        //onClickListener for the second song on the page
        Button.OnClickListener bPlayCigarettesAndSaints= new Button.OnClickListener() {
            @Override
        public void onClick (View v) {
                //this switch makes decisions for what is done when the user plays or pauses the second song
                switch(playing) {
                    case 0:
                        //tells the media player to start the song
                        mpCigarettesAndSaints.start();
                        playing = 1;
                        //sets text to tell the user to pause the song
                        btnPlayCigarettesAndSaints.setText("Pause Cigarettes & Saints");
                        //sets the visibility of the button for the first song as invisible
                        btnPlayCardinals.setVisibility(View.INVISIBLE);
                        //Toast notification to let the user know what song they are listening to
                        Toast.makeText(MusicActivity.this, "You are now listening to Cigarettes and Saints",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //pauses the second song when the user clicks the button
                        mpCigarettesAndSaints.pause();
                        playing =0;
                        //setting the text of the button to tell the user they can keep playing
                        btnPlayCigarettesAndSaints.setText("Play Cigarettes & Saints");
                        //setting the visibility of the play button for the first song to invisible
                        //to avoid the user playing two songs at once
                        btnPlayCardinals.setVisibility(View.VISIBLE);
                        break;
                }

            }
        };
    }

