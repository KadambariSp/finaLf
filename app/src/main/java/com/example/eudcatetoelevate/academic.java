package com.example.eudcatetoelevate;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;
public class academic extends AppCompatActivity {
    PDFView acapd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_academic);
        acapd=(PDFView) findViewById(R.id.acapd);
        acapd.fromAsset("academic.pdf").load();
    }
}