package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eudcatetoelevate.Model.MobileNumbersStudent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class
PhoneNumberCheckStudent extends AppCompatActivity {
EditText enrollFY,mobileFY;
Button buttonNext;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_check_student);
        enrollFY=(EditText)findViewById(R.id.enrollFY);
        mobileFY=(EditText)findViewById(R.id.mobileFY);
        buttonNext=(Button)findViewById(R.id.buttonNextFY);
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_Phone=database.getReference("MobileNumbersFY");
        mobileFY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_Phone.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(enrollFY.getText().toString()).exists()){


                            MobileNumbersStudent mobileNumbersStudent =dataSnapshot.child(enrollFY.getText().toString().trim()).getValue(MobileNumbersStudent.class);
                            if (mobileNumbersStudent.getMobile().equals(mobileFY.getText().toString())){
                                Toast.makeText(PhoneNumberCheckStudent.this, "CORRECT MOBILE NUMBER!!!!", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(PhoneNumberCheckStudent.this,VerifyPhone.class);
                                st=mobileFY.getText().toString();
                                i.putExtra("Value",st);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(PhoneNumberCheckStudent.this, "Something went Wrong!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(PhoneNumberCheckStudent.this, "User Dose not exists!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });




    }
}
