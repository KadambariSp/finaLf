package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;

public class pres extends AppCompatActivity {
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_pres);

        text1=(TextView)findViewById(R.id.text1);
        text1.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
