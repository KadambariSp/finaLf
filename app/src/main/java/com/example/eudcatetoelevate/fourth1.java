package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class fourth1 extends AppCompatActivity {
    PDFView pdffourth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_fourth1);
        pdffourth=(PDFView)findViewById(R.id.pdffourth);
        pdffourth.fromAsset("4sem.pdf").load();
    }
}

