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
import com.example.eudcatetoelevate.Model.MobileNumbersSy;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PhoneNumberCheckStudentSy extends AppCompatActivity {
    EditText enrollSY,mobileSY;
    Button buttonNextSY;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_check_student_sy);
        enrollSY=(EditText)findViewById(R.id.enrollSY);
        mobileSY=(EditText)findViewById(R.id.mobileSY);
        buttonNextSY=(Button)findViewById(R.id.buttonNextSY);
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_Phone1=database.getReference("MobileNumbersSy");
        mobileSY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_Phone1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(enrollSY.getText().toString()).exists()){

MobileNumbersSy mobileNumbersSy=dataSnapshot.child(enrollSY.getText().toString().trim()).getValue(MobileNumbersSy.class);
                          //  MobileNumbersStudent mobileNumbersSy =dataSnapshot.child(enrollSY.getText().toString().trim()).getValue(MobileNumbersStudent.class);
                            if (mobileNumbersSy.getMobile().equals(mobileSY.getText().toString())){
                                Toast.makeText(PhoneNumberCheckStudentSy.this, "CORRECT MOBILE NUMBER!!!!", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(PhoneNumberCheckStudentSy.this,VerifyPhoneSy.class);
                                st=mobileSY.getText().toString();
                                i.putExtra("Value",st);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(PhoneNumberCheckStudentSy.this, "Something went Wrong!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(PhoneNumberCheckStudentSy.this, "User Dose not exists!", Toast.LENGTH_SHORT).show();
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
