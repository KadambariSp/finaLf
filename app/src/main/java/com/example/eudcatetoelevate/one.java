package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class one extends AppCompatActivity {
    PDFView pdfone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        pdfone=(PDFView)findViewById(R.id.pdfone);
        pdfone.fromAsset("fy1.pdf").load();
    }
}
