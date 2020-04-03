package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class sixth1 extends AppCompatActivity {
    PDFView pdfsixth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_sixth1);
        pdfsixth=(PDFView)findViewById(R.id.pdfsixth);
        pdfsixth.fromAsset("6sem.pdf").load();
    }
}
