package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutSY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_s_y);
        FirebaseAuth.getInstance().signOut();
        Intent logout = new Intent(LogoutSY.this,PanelSelection.class);
        Toast.makeText(LogoutSY.this,"Logging Out From Second Year...",Toast.LENGTH_SHORT).show();
        startActivity(logout);
    }
}
