package com.example.ezzeldeen.tahrirlounge.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments.About_Us;
import com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments.Events_fragments;
import com.example.ezzeldeen.tahrirlounge.ViewPager_Fragments.Our_Partners;

import static com.example.ezzeldeen.tahrirlounge.ViewPager_Fragments.TabFragment.int_items;

/**
 * Created by Admin on 3/1/2017.
 */

public class MyAdapter  extends FragmentPagerAdapter {


    public MyAdapter(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Events_fragments();

            case 1:
                return new Our_Partners();
            case 2:
                return new About_Us();


        }
        return null;
    }

    @Override
    public int getCount() {


        return int_items;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return " Events_fragments";

            case 1:
                return "Our Partners";
            case 2:
                return "About Us";


        }

        return null;
    }
}
