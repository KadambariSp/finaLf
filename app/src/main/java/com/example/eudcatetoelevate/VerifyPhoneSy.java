package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class VerifyPhoneSy extends AppCompatActivity {
    private Spinner spinnerSY;
    String st;
    private EditText editTextMobileCheckSy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_sy);
        editTextMobileCheckSy=(EditText) findViewById(R.id.editTextMobileCheckSy);
        spinnerSY = findViewById(R.id.spinnerSY);
        spinnerSY.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
        findViewById(R.id.buttonSendOtpSy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinnerSY.getSelectedItemPosition()];

                String number = editTextMobileCheckSy.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editTextMobileCheckSy.setError("Valid number is required");
                    editTextMobileCheckSy.requestFocus();
                    return;
                }

                String phoneNumber = "+" + code + number;

                Intent intent = new Intent(VerifyPhoneSy.this, otpcheckSy.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);

            }
        });
        st=getIntent().getExtras().getString("Value");
        editTextMobileCheckSy.setText(st);

    }
}
