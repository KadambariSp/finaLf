package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class fifth extends AppCompatActivity {
    PDFView pdffifth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fifth);
        pdffifth=(PDFView)findViewById(R.id.pdffifth);
        pdffifth.fromAsset("5sem.pdf").load();
    }
}
