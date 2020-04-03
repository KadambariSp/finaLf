package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;

public class hop extends AppCompatActivity {
    TextView text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_hop);
        text4=(TextView)findViewById(R.id.text4);
        text4.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
