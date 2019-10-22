package com.example.smarttechmardan.bilal10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Flipper2Activity extends AppCompatActivity {

    private static final int FLIP_DURATION = 3000;
    private ViewFlipper viewFlipper1;
    private boolean isSlideshowOn = false;
    //private float lastx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper2);

        viewFlipper1 = (ViewFlipper)findViewById(R.id.viewFlipper1);
        viewFlipper1.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in));
        viewFlipper1.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_out));

        ImageView leftArrowButton = (ImageView)findViewById(R.id.left_button);
        leftArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSlideshowOn){
                    viewFlipper1.showPrevious();
                }
            }
        });

        ImageView rightArrowButton = (ImageView)findViewById(R.id.right_button);
        rightArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSlideshowOn){
                    viewFlipper1.showNext();
                }
            }
        });

        final Button slideshowButton = (Button)findViewById(R.id.buttonSlideshow);
        slideshowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSlideshowOn) {
                    isSlideshowOn = false;
                    slideshowButton.setText("Turn Slide Show On");
                } else {
                    isSlideshowOn = true;
                    slideshowButton.setText("Turn Slide Show Off");
                }
                if (isSlideshowOn){
                    startSlideshow();
                    animateSlideshow();
                }else{
                    stopSlideshow();
                }
            }

        });
    }

    private void startSlideshow(){
        if (!viewFlipper1.isFlipping()){
            viewFlipper1.setAutoStart(true);
            viewFlipper1.setFlipInterval(FLIP_DURATION);
            viewFlipper1.startFlipping();
        }
    }
    private void animateSlideshow(){
        viewFlipper1.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    private void stopSlideshow(){
        if (viewFlipper1.isFlipping()){
            viewFlipper1.stopFlipping();
        }
    }
    ////////////////////////////////////////////////////////
    /*public boolean onTouchEvent(MotionEvent touchevent){
        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastx = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();

                //Handling left to right screen swap
                if (lastx<currentX){

                    if (viewFlipper1.getDisplayedChild() == 0)
                        break;

                    viewFlipper1.setInAnimation(this,R.anim.slide_in_from_left);

                    viewFlipper1.setOutAnimation(this,R.anim.slide_out_to_right);


                    viewFlipper1.showNext();

                }


                if (lastx>currentX){

                    if (viewFlipper1.getDisplayedChild() == 1)
                        break;

                    viewFlipper1.setInAnimation(this,R.anim.slide_in_from_right);

                    viewFlipper1.setOutAnimation(this,R.anim.slide_out_to_left);

                    viewFlipper1.showPrevious();
                }
                break;
        }
        return false;
    }*/
}
