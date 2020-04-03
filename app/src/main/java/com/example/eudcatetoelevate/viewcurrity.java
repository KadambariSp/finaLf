package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class viewcurrity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcurrity);
    }

    public void btn_actioncurrity(View view) {
        startActivity(new Intent(getApplicationContext(),listcurrity.class));
    }
}
