package com.example.eudcatetoelevate;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class second extends AppCompatActivity {
    PDFView pdfsecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_second);
        pdfsecond=(PDFView)findViewById(R.id.pdfsecond);
        pdfsecond.fromAsset("2sem.pdf").load();
    }
}