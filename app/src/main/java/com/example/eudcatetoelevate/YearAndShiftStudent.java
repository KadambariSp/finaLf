package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class YearAndShiftStudent extends AppCompatActivity {
    LinearLayout fy,sy,ty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_and_shift_student);
        fy=(LinearLayout)findViewById(R.id.fy);
        sy=(LinearLayout)findViewById(R.id.sy);
        ty=(LinearLayout)findViewById(R.id.ty);
        fy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(YearAndShiftStudent.this,LoginStudentFy.class);
                startActivity(i);
            }
        });
        sy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(YearAndShiftStudent.this,LoginStudentSy.class);
                startActivity(i2);
            }
        });
        ty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(YearAndShiftStudent.this,LoginStudentTy.class);
                startActivity(i3);
            }
        });

    }
}
