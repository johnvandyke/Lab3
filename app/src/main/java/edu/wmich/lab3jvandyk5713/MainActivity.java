package edu.wmich.lab3jvandyk5713;

import android.app.ListActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
* The MainActivity.java file is the Activity that is displayed after SplashActivity.  This Activity
* uses a ListView to display links to other activities.  It uses an array to populate the ListView
* that is in activity_main.xml.  There is a switch in onListItemClick that decides where each item
* in the ListView goes.
*************************************
*/

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this array is where the values are stored for use in the ListView
        String[ ] previewItems={"Buy No Closer To Heaven on Amazon",
                "Buy No Closer To Heaven on Google Play Music",
        "Listen to Music from No Closer to Heaven", "See The Wonder Years on tour",
                "Other Releases from The Wonder Years"};

        //this setListAdapter is used to create a custom view for the ListActivity
        setListAdapter(new ArrayAdapter<>(this, R.layout.activity_main, R.id.previewListItems, previewItems));
    }

    //onListItemClick is the method that makes an action when the user taps each part of the list
    protected void onListItemClick (ListView i, View v, int position, long id) {
        //this switch does the decision making for where each link goes to
        switch(position){
            case 0:
                //startActivity is how the program knows to go to a new Activity or URI.
                //this case uses a URI to open the internet browser to go to a web page
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com/No-Closer-Heaven-Wonder-Years/dp/B00ZZ3VWFO/ref=tmm_msc_swatch_0?_encoding=UTF8&qid=&sr=")));
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/music/album/The_Wonder_Years_No_Closer_To_Heaven?id=Bmbkyzueoqcxfixunrom4kiq24u")));
                break;
            case 2:
                //the rest of the cases use a new intent to open a new activity
                startActivity(new Intent(MainActivity.this, MusicActivity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, AlbumArtActivity.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, OtherAlbumsActivity.class));
                break;
        }
    }
}
