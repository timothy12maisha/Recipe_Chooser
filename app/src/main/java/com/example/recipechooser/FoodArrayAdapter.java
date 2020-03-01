package com.example.recipechooser;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;

public class FoodArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mFoods;
    private String[] mIngredients;

    public FoodArrayAdapter(Context mContext, int resource, String[] mFoods, String[] mIngredients) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mFoods = mFoods;
        this.mIngredients = mIngredients;
    }
    @Override
    public Object getItem(int position) {
        String foods = mFoods[position];
        String ingredients= mIngredients[position];
        return String.format("%s \nServes great: %s", foods, ingredients);
    }

    @Override
    public int getCount() {
        return mFoods.length;
    }
}