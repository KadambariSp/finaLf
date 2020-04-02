package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class VerifyPhoneTy extends AppCompatActivity {
    private Spinner spinnerTY;
    String st;
    private EditText editTextMobileCheckTy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_ty);
        editTextMobileCheckTy=(EditText) findViewById(R.id.editTextMobileCheckTy);
        spinnerTY = findViewById(R.id.spinnerTY);
        spinnerTY.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
        findViewById(R.id.buttonSendOtpTy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinnerTY.getSelectedItemPosition()];

                String number = editTextMobileCheckTy.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editTextMobileCheckTy.setError("Valid number is required");
                    editTextMobileCheckTy.requestFocus();
                    return;
                }

                String phoneNumber = "+" + code + number;

                Intent intent = new Intent(VerifyPhoneTy.this, otpcheckTy.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);

            }
        });
        st=getIntent().getExtras().getString("Value");
        editTextMobileCheckTy.setText(st);


    }
}
