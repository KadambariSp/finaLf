package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

import java.security.ProtectionDomain;

public class first extends AppCompatActivity {
    PDFView pdffirst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_first);
        pdffirst=(PDFView)findViewById(R.id.pdffirst);
        pdffirst.fromAsset("1sem.pdf").load();
    }
}
