package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_teacher);
        FirebaseAuth.getInstance().signOut();
        Intent logout = new Intent(LogoutTeacher.this,PanelSelection.class);
        Toast.makeText(LogoutTeacher.this,"Logging Out From Teacher Panel...",Toast.LENGTH_SHORT).show();
        startActivity(logout);
    }
}
