package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class viewcurrisy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcurrisy);
    }

    public void btn_actioncurrisy(View view) {
        startActivity(new Intent(getApplicationContext(),liscurrisy.class));
    }
}