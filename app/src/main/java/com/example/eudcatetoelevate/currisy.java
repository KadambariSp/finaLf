package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class currisy extends AppCompatActivity {
    Button three,four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_currisy);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(currisy.this,third.class);
                startActivity(i);

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(currisy.this,fourth.class);
                startActivity(i2);
            }
        });

    }
}