package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PanelSelection extends AppCompatActivity {
    CardView studentPanelSelection,teacherPanelSelection,parentPanelSelection;
    TextView studentPanel,teacherPanel,parentPanel;
    TextView studInfo,teachInfo,parentInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_selection);
        studentPanelSelection=(CardView)findViewById(R.id.studentPanelSelection);
        parentPanelSelection=(CardView)findViewById(R.id.parentPanelSelection);
        teacherPanelSelection=(CardView)findViewById(R.id.teacherPanelSelection);
        studentPanelSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PanelSelection.this,YearAndShiftStudent.class);
                startActivity(i);
            }
        });
        teacherPanelSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PanelSelection.this,LoginTeacher.class);
                startActivity(i);
            }
        });
        parentPanelSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PanelSelection.this,LoginParent.class);
                startActivity(i);
            }
        });
        studentPanel=(findViewById(R.id.studentPanel));

        teacherPanel=findViewById(R.id.teacherPanel);
        parentPanel=findViewById(R.id.parentPanel);
        studInfo=findViewById(R.id.studInfo);
        teachInfo=findViewById(R.id.teachInfo);
        parentInfo=findViewById(R.id.parentInfo);
        teacherPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PanelSelection.this,LoginTeacher.class);
                startActivity(i);
            }
        });
        parentPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PanelSelection.this,LoginParent.class);
                startActivity(i);
            }
        });
        studentPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PanelSelection.this,YearAndShiftStudent.class);
                startActivity(i);
            }
        });
    }
}
