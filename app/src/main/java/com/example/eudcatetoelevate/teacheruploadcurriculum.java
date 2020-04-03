package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class teacheruploadcurriculum extends AppCompatActivity {
    Button currify,currisy,currity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacheruploadcurriculum);
        currify=(Button) findViewById(R.id.currify);
        currisy=(Button)findViewById(R.id.currisy);
        currity=(Button)findViewById(R.id.currity);
        currify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(teacheruploadcurriculum.this,uploadcurrify.class);
                startActivity(intent);
            }
        });
        currisy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(teacheruploadcurriculum.this,uploadcurrisy.class);
                startActivity(intent);
            }
        });
        currity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(teacheruploadcurriculum.this,uploadcurrity.class);
                startActivity(intent);
            }
        });

    }
}

