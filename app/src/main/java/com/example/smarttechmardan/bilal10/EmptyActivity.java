package com.example.smarttechmardan.bilal10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        ////////////////////////////////////////////////////////
        Thread splash = new Thread() {

            public void run() {
                try {
                    sleep(3 * 1000);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();

                } catch (Exception e) {
                }
            }
        };

        splash.start();
    }
}
///////////////////////////////////////////////////////////////