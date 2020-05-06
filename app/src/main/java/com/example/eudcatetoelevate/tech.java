package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;

public class tech extends AppCompatActivity {
    TextView text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tech);
        text5=(TextView)findViewById(R.id.text5);
        text5.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
