package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutFy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_fy);
        FirebaseAuth.getInstance().signOut();
        Intent logout = new Intent(LogoutFy.this,PanelSelection.class);
        Toast.makeText(LogoutFy.this,"Logging Out From First Year...",Toast.LENGTH_SHORT).show();
        startActivity(logout);
    }
}
