package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutTy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_ty);
        FirebaseAuth.getInstance().signOut();
        Intent logout = new Intent(LogoutTy.this,PanelSelection.class);
        Toast.makeText(LogoutTy.this,"Logging Out From Third Year...",Toast.LENGTH_SHORT).show();
        startActivity(logout);
    }
}
