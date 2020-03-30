package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView logoapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoapp=findViewById(R.id.logoapp);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransition);

        logoapp.startAnimation(myanim);
        final Intent i=new Intent(this,PanelSelection.class);


        Thread timer=new Thread(){
            public void run (){
                try {
                    sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }

            }

        };
        timer.start();

    }
}
