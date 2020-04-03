package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class viewcurrify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcurrify);
    }

    public void btn_actioncurrify(View view) {
        startActivity(new Intent(getApplicationContext(),listcurrify.class));
    }
}