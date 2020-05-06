package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;

public class sec extends AppCompatActivity {
    TextView text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sec);
        text3=(TextView)findViewById(R.id.text3);
        text3.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
