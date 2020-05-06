package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class fourth extends AppCompatActivity {
    PDFView pdffour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fourth);

        pdffour=(PDFView)findViewById(R.id.pdffour);
        pdffour.fromAsset("sy2.pdf").load();
    }
}
