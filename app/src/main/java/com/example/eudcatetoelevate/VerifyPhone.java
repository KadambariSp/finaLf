package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class VerifyPhone extends AppCompatActivity {
    private Spinner spinnerFY;
    private EditText editTextMobileCheckFy;


    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);

        editTextMobileCheckFy = (EditText) findViewById(R.id.editTextMobileCheckFy);
        spinnerFY = findViewById(R.id.spinnerFY);
        spinnerFY.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
        findViewById(R.id.buttonSendOtpFy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinnerFY.getSelectedItemPosition()];

                String number = editTextMobileCheckFy.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editTextMobileCheckFy.setError("Valid number is required");
                    editTextMobileCheckFy.requestFocus();
                    return;
                }

                String phoneNumber = "+" + code + number;

                Intent intent = new Intent(VerifyPhone.this, otpcheck.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);
            }
        });
        st = getIntent().getExtras().getString("Value");
        editTextMobileCheckFy.setText(st);


    }
}
