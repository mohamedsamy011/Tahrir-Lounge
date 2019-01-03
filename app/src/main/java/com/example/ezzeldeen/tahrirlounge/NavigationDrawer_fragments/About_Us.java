package com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ezzeldeen.tahrirlounge.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_Us extends Fragment {


    public About_Us() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

                View view= inflater.inflate(R.layout.fragment_about__us, container, false);


        ImageView imageView=(ImageView)view.findViewById(R.id.about_us_image);


       imageView.setScaleType(ImageView.ScaleType.FIT_XY);



return view;


    }

}
