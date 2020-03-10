package com.example.recipechooser.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyFoodArrayAdapter extends ArrayAdapter{
    private Context mContext;
    private String[] mFoods;
    private String[] mCuisines;


    public MyFoodArrayAdapter(Context mContext, int resource, String[] mFoods, String[] mRecipes){
        super(mContext, resource);
        this.mContext = mContext;
        this.mCuisines= mCuisines;
        this.mFoods = mFoods;

    }

    @Override
    public Object getItem(int position){
        String food = mFoods[position];
        String recipe = mCuisines[position];
        return String.format("%s \n serves great: %s", food, recipe);
    }

    @Override
    public int getCount(){
        return mFoods.length;
    }



}
