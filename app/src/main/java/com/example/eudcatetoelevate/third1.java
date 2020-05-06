package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class third1 extends AppCompatActivity {
    PDFView pdfthird;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third1);
        pdfthird=(PDFView)findViewById(R.id.pdfthird);
        pdfthird.fromAsset("3sem.pdf").load();
    }
}

