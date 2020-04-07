package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class viewpdfstudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpdfstudent);
    }

    public void btn_action(View view) {
        startActivity(new Intent(getApplicationContext(),ViewPdf1.class));

    }
}
