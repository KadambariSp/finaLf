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
import com.example.eudcatetoelevate.Model.MobileNumbersTeacher;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PhoneNumberCheckTeachers extends AppCompatActivity {
    EditText enrollTeacher,mobileTeacher;
    Button buttonNextTeacher;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_check_teachers);
        enrollTeacher=(EditText)findViewById(R.id.enrollTeacher);
        mobileTeacher=(EditText)findViewById(R.id.mobileTeacher);
        buttonNextTeacher=(Button)findViewById(R.id.buttonNextTeacher);
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_Phone_teachers=database.getReference("MobileNumbersTeachers");
        mobileTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_Phone_teachers.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(enrollTeacher.getText().toString()).exists()){


                            MobileNumbersTeacher mobileNumbersTeacher =dataSnapshot.child(enrollTeacher.getText().toString().trim()).getValue(MobileNumbersTeacher.class);
                            if (mobileNumbersTeacher.getMobile().equals(mobileTeacher.getText().toString())){
                                Toast.makeText(PhoneNumberCheckTeachers.this, "Correct credentials", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(PhoneNumberCheckTeachers.this,VerifyPhoneTeachers.class);
                                st=mobileTeacher.getText().toString();
                                i.putExtra("Value",st);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(PhoneNumberCheckTeachers.this, "Oopss..Something went Wrong....Check Your Internet Connection!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(PhoneNumberCheckTeachers.this, "User Dose not exists!", Toast.LENGTH_SHORT).show();
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
