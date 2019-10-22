package com.example.smarttechmardan.bilal10;

import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class RadioActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox m,f;
    Switch s;
    ToggleButton t;
    MediaPlayer mysound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /////////////////////////Font Change/////////////////////
        TextView abc=(TextView)findViewById(R.id.textViewgender);
        Typeface type=Typeface.createFromAsset(getAssets(),"fonts/androidnation.ttf");
        abc.setTypeface(type);
        ///////////////////////////////////////////////////////////

        /////////////////////////Switch////////////////////////////
        s=(Switch)findViewById(R.id.switchmusic);
        s.setChecked(false);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    mysound=MediaPlayer.create(RadioActivity.this,R.raw.buttonclick);
                    mysound.start();
                    Toast.makeText(RadioActivity.this, "Music On", Toast.LENGTH_SHORT).show();
                    s.setText("Music On");

                }
                else{
                   mysound.release();
                    Toast.makeText(RadioActivity.this, "Music Off", Toast.LENGTH_SHORT).show();
                    s.setText("Music Off");

                }
            }
        });
        //////////////////////////////////////////////////////////////

        //////////////////////////////Toggle Button/////////////////////
        t=(ToggleButton)findViewById(R.id.toggleButton);
        t.setChecked(false);
        t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Toast.makeText(RadioActivity.this, "Light On", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RadioActivity.this, "Light Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //////////////////////////////////////////////////////////////////


        /////////////////////////Radio Group//////////////////////////
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.setbackground);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RelativeLayout r1=(RelativeLayout)findViewById(R.id.r1);

                if (checkedId==R.id.radioButtonwhite){
                    Toast.makeText(RadioActivity.this, "clear background", Toast.LENGTH_SHORT).show();
                    r1.setBackgroundColor(Color.WHITE);
                }
                if (checkedId==R.id.radioButtonRed){
                    Toast.makeText(RadioActivity.this, "red background", Toast.LENGTH_SHORT).show();
                    r1.setBackgroundColor(Color.RED);
                }
                if (checkedId==R.id.radioButtonGreen){
                    Toast.makeText(RadioActivity.this, "green background", Toast.LENGTH_SHORT).show();
                    r1.setBackgroundColor(Color.GREEN);
                }
                if (checkedId==R.id.radioButtonpic){
                    Toast.makeText(RadioActivity.this, "Image on background", Toast.LENGTH_SHORT).show();
                    r1.setBackgroundResource(R.drawable.ccc);
                }
            }
        });
        ///////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////Check Box///////////////////////////////
        m=(CheckBox)findViewById(R.id.checkBoxmale);
        f=(CheckBox)findViewById(R.id.checkBoxfemale);
        m.setOnClickListener(this);
        f.setOnClickListener(this);
        ////////////////////////////////////////////////////////////////////////////


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //////////////////////////////////////////////////////////////////////////

    @Override
    public void onClick(View v) {
        switch (v.getId())

        {
            case R.id.checkBoxmale:
                if(m.isChecked())
                {

                    f.setChecked(false);
                }
            case R.id.checkBoxfemale:
                if(f.isChecked())
                {
                    m.setChecked(false);
                }
        }
    }
    ///////////////////////////////////////////////////////////////////////////
}
