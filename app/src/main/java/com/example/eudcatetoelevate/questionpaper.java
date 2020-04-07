package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class questionpaper extends AppCompatActivity {
    Button first,second,third,fourth,fifth,sixth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionpaper);
        first=(Button)findViewById(R.id.first);
        second=(Button)findViewById(R.id.second);
        third=(Button)findViewById(R.id.third);
        fourth=(Button)findViewById(R.id.fourth);
        fifth=(Button)findViewById(R.id.fifth);
        sixth=(Button)findViewById(R.id.sixth);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(questionpaper.this,first.class);
                startActivity(i);

            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(questionpaper.this,second.class);
                startActivity(i2);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(questionpaper.this,third1.class);
                startActivity(i);

            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(questionpaper.this,fourth1.class);
                startActivity(i2);
            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(questionpaper.this,fifth.class);
                startActivity(i);

            }
        });
        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(questionpaper.this,sixth1.class);
                startActivity(i2);
            }
        });




    }
}
