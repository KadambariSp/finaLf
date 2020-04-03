package com.example.eudcatetoelevate;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class sixth extends AppCompatActivity {
    PDFView pdfsix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_sixth);
        pdfsix=(PDFView)findViewById(R.id.pdfsix);
        pdfsix.fromAsset("sixth.pdf").load();

    }
}