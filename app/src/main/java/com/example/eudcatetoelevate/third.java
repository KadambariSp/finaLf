package com.example.eudcatetoelevate;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class third extends AppCompatActivity {
    PDFView pdfthree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_third);
        pdfthree=(PDFView)findViewById(R.id.pdfthree);
        pdfthree.fromAsset("sy1.pdf").load();
    }
}
