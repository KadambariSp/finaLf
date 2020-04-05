package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutParents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_parents);
        FirebaseAuth.getInstance().signOut();
        Intent logout = new Intent(LogoutParents.this,PanelSelection.class);
        Toast.makeText(LogoutParents.this,"Logging Out From Parents Panel...",Toast.LENGTH_SHORT).show();
        startActivity(logout);
    }
}
