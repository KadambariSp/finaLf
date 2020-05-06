package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class five extends AppCompatActivity {
    PDFView pdffive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_five);
        pdffive=(PDFView)findViewById(R.id.pdffive);
        pdffive.fromAsset("fifth.pdf").load();
    }
}
