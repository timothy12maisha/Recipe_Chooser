package com.example.recipechooser.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.example.recipechooser.models.Business;
import com.example.recipechooser.ui.FoodDetailFragment;

import java.util.List;

public class FoodPagerAdapter extends FragmentPagerAdapter {
    private List<Business> mFoods;

    public FoodPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Business> foods) {
        super(fm, behavior);
        mFoods = foods;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FoodDetailFragment.newInstance(mFoods.get(position));
    }

    @Override
    public int getCount() {
        return mFoods.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFoods.get(position).getName();
    }
}