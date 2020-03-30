package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class VerifyPhoneTeachers extends AppCompatActivity {
    private Spinner spinnerTeachers;
    private EditText editTextMobileCheckTeachers;


    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_teachers);
        editTextMobileCheckTeachers = (EditText) findViewById(R.id.editTextMobileCheckTeachers);
        spinnerTeachers = findViewById(R.id.spinnerTeachers);
        spinnerTeachers.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
        findViewById(R.id.buttonSendOtpTeachers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinnerTeachers.getSelectedItemPosition()];

                String number = editTextMobileCheckTeachers.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editTextMobileCheckTeachers.setError("Valid number is required");
                    editTextMobileCheckTeachers.requestFocus();
                    return;
                }

                String phoneNumber = "+" + code + number;

                Intent intent = new Intent(VerifyPhoneTeachers.this, otpcheckTeachers.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);
            }
        });
        st = getIntent().getExtras().getString("Value");
        editTextMobileCheckTeachers.setText(st);


    }
}
