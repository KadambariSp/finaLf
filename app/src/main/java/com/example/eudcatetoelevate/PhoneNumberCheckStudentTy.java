package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eudcatetoelevate.Model.MobileNumberTy;
import com.example.eudcatetoelevate.Model.MobileNumbersSy;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PhoneNumberCheckStudentTy extends AppCompatActivity {
    EditText enrollTY,mobileTY;
    Button buttonNextTY;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_check_student_ty);
        enrollTY=(EditText)findViewById(R.id.enrollTY);
        mobileTY=(EditText)findViewById(R.id.mobileTY);
        buttonNextTY=(Button)findViewById(R.id.buttonNextTY);
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_Phone2=database.getReference("MobileNumberTy");
        mobileTY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_Phone2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(enrollTY.getText().toString()).exists()){

                            MobileNumberTy mobileNumbersTy=dataSnapshot.child(enrollTY.getText().toString().trim()).getValue(MobileNumberTy.class);
                            //  MobileNumbersStudent mobileNumbersSy =dataSnapshot.child(enrollSY.getText().toString().trim()).getValue(MobileNumbersStudent.class);
                            if (mobileNumbersTy.getMobile().equals(mobileTY.getText().toString())){
                                Toast.makeText(PhoneNumberCheckStudentTy.this, "CORRECT MOBILE NUMBER!!!!", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(PhoneNumberCheckStudentTy.this,VerifyPhoneTy.class);
                                st=mobileTY.getText().toString();
                                i.putExtra("Value",st);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(PhoneNumberCheckStudentTy.this, "Something went Wrong! Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(PhoneNumberCheckStudentTy.this, "Your input should no contain any spaces as well as it is case-sensitive", Toast.LENGTH_SHORT).show();
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

