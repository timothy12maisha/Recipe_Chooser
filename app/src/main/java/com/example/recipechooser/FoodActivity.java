package com.example.recipechooser;


import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FoodActivity extends AppCompatActivity {

    Integer[] imgid ={
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        GridView gridview =(GridView)findViewById(R.id.baseGridView);

        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(),
                        "Ginger Champagne" + (position + 1) +
                                "ingredients: " +
                                "champagne," +
                                "ginger, " +
                                "ice, " +
                                "vodka",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
    public class ImageAdapter extends BaseAdapter
    {
        private Context context;
        public ImageAdapter(Context c)
        {
            context = c;
        }
        //---returns the number of images---
        public int getCount() {
            return imgid.length;
        }
        //---returns the item---
        public Object getItem(int position) {
            return position;
        }
        //---returns the ID of an item---
        public long getItemId(int position) {
            return position;
        }
        //---returns an ImageView view---
        public View getView(int position, View convertView,
                            ViewGroup parent)
        {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new
                        GridView.LayoutParams(360, 450));
                imageView.setScaleType(
                        ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(5, 5, 5, 5);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(imgid[position]);
            return imageView;
        }
    }
}