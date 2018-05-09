package edu.wmich.lab3jvandyk5713;

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
*This Activity contains a gridView to display 6 different pictures that the user selects.  When the
* user selects a picture, a custom class sets the picture in an ImageView at the bottom of the screen.
* All of the pictures are stored in an array, which is used to populate the pictures in the gridView.  This
* allows for the gridView to have more pictures added to it, or taken from it, very easily.  This
* activity also uses an ImageAdapter, which provides the view AdapterView access to the data
* that is stored in the array.  In addition, a switch is used in this Activity to display a custom
* Toast notification for each picture that is in the array.  This is in the setOnItemClickListener
* so when the user selects a picture, the Toast notification that is assigned to its position is displayed.
*************************************
*/

import android.content.Context;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class OtherAlbumsActivity extends ActionBarActivity {

    //instantiating the array and the ImageView for use in the onItemClickListener and custom class
    Integer[ ] Albums = {R.drawable.thegreatestgeneration, R.drawable.suburbia, R.drawable.theupsides,
            R.drawable.sleepingontrash, R.drawable.wontbepatheticforever, R.drawable.getstokedonit};
    ImageView imgAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_albums);

        //declaring the variable for the GridView so it's recognized by the adapter
        GridView gridAlbums = (GridView)findViewById(R.id.gridViewAlbums);
        //declaring the imageView variable so an image can be set in the string
        final ImageView albumCover = (ImageView) findViewById(R.id.imgAlbum);

        //setting the ImageAdapter and the AdapterView so the pictures in the array are displayed
        //in the GridView
        gridAlbums.setAdapter(new ImageAdapter(this));
        gridAlbums.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //this switch makes the decision on what Toast notification is displayed, based on the position in the array
                switch (position) {
                    case 0:
                        Toast.makeText(OtherAlbumsActivity.this, "You have selected The Greatest Generation",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(OtherAlbumsActivity.this, "You have selected Suburbia, " +
                                "I've Given You All And Now I'm Nothing", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(OtherAlbumsActivity.this, "You have selected The Upsides",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(OtherAlbumsActivity.this, "You have selected Sleeping on Trash",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(OtherAlbumsActivity.this, "You have selected Won't Be Pathetic Forever",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(OtherAlbumsActivity.this, "You have selected Get Stoked On It",
                                Toast.LENGTH_SHORT).show();
                        break;
                }

                //the albumCover variable is the ImageView that is displayed in the XML, and this sets
                //the picture as the image
                albumCover.setImageResource(Albums[position]);
            }
        });
    }

    //Custom class for the ImageAdapter
    public class ImageAdapter extends BaseAdapter {
        //creating a constructor with the variable imgSet.  Context is how the class recognizes the ImageAdapter
        private Context imgSet;
        public ImageAdapter(Context c) {
            imgSet=c;
        }

        //Getting the number of values in the array
        @Override
        public int getCount(){
            return Albums.length;
        }

        //Getting the position of the pictures in the array
        @Override
        public Object getItem(int position) {
            return null;
        }

        //Getting the position of the pictures in the array
        @Override
        public long getItemId(int position) {
            return 0;
        }

        //Here is where the image is being set in the view, which is being set into the imgAlbum string
        //which displays the selected picture on the screen
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            imgAlbum = new ImageView(imgSet);
            imgAlbum.setImageResource(Albums[position]);
            imgAlbum.setScaleType(ImageView.ScaleType.FIT_XY);
            imgAlbum.setLayoutParams(new GridView.LayoutParams(210, 210));
            return imgAlbum;
        }
    }
}
