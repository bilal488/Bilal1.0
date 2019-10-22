package com.example.smarttechmardan.bilal10;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class HyperspacejumpActivity extends AppCompatActivity {

    ImageView image;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyperspacejump);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /////////////////////////////////////////////
        image = (ImageView)findViewById(R.id.imageView2);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation hyperspaceJump = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hyperspace_jump);
                image.startAnimation(hyperspaceJump);
                mHandler.postDelayed(mUpdateTimeTask, 1600);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }///////////////////////////on create end/////////

    private Runnable mUpdateTimeTask = new Runnable() {
        @Override
        public void run() {

            Intent i = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(i);
        }
    };

}
