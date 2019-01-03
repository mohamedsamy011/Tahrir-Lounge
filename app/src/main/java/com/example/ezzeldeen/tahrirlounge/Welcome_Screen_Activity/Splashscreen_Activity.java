package com.example.ezzeldeen.tahrirlounge.Welcome_Screen_Activity;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ezzeldeen.tahrirlounge.NavigationDrawer_fragments.NavigationDrawer;
import com.example.ezzeldeen.tahrirlounge.R;

public class Splashscreen_Activity extends AppCompatActivity {


    private TextView textView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.welcome);

        imageView = (ImageView) findViewById(R.id.image);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slpash_animation);
        textView.startAnimation(animation);
        imageView.startAnimation(animation);


        //rotate logo
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setInterpolator(new

                LinearInterpolator());
        rotateAnimation.setDuration(3000);

        findViewById(R.id.image).

                startAnimation(rotateAnimation);

        //move to event fragment after 4 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(Splashscreen_Activity.this, NavigationDrawer.class);
                Splashscreen_Activity.this.startActivity(mainIntent);
                Splashscreen_Activity.this.finish();
            }
        }, 4000);


    }
}

















