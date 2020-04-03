package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;

public class evemang extends AppCompatActivity {
    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_evemang);
        text2=(TextView)findViewById(R.id.text2);
        text2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}