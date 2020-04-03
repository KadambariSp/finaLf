package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pdf extends AppCompatActivity {
    Button five,six;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pdf.this,five.class);
                startActivity(intent);

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pdf.this,sixth.class);
                startActivity(intent);

            }
        });

    }
}