package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class two extends AppCompatActivity {
    PDFView pdftwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        pdftwo=(PDFView)findViewById(R.id.pdftwo);
        pdftwo.fromAsset("fy2.pdf").load();
    }
}
