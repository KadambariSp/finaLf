package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class coesa extends AppCompatActivity {
    LinearLayout primaryitem,secondaryitem,thirditem,fouritem,fiveitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coesa);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_coesa);
        primaryitem=(LinearLayout)findViewById(R.id.primaryitem);
        primaryitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(coesa.this,pres.class);
                startActivity(intent);
            }
        });
        secondaryitem=(LinearLayout)findViewById(R.id.secondaryitem);
        secondaryitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(coesa.this,sec.class);
                startActivity(intent);
            }
        });
        thirditem=(LinearLayout)findViewById(R.id.thirditem);
        thirditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(coesa.this,hop.class);
                startActivity(intent);
            }
        });
        fouritem=(LinearLayout)findViewById(R.id.fouritem);
        fouritem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(coesa.this,tech.class);
                startActivity(intent);
            }
        });
        fiveitem=(LinearLayout)findViewById(R.id.fiveitem);
        fiveitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(coesa.this,evemang.class);
                startActivity(intent);
            }
        });

    }
}


