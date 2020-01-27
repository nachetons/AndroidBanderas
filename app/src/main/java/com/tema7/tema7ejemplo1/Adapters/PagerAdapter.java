package com.tema7.tema7ejemplo1.Adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tema7.tema7ejemplo1.Fragments.FirstFragment;
import com.tema7.tema7ejemplo1.Fragments.SecondFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;


    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}