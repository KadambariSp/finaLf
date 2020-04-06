package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewProfileStudentSy extends AppCompatActivity {
    EditText name,emailid,phoneno,year,term,shift,batch,enroll;
    TextView profilemessage,personal,quadet;
    ImageView profileImage;
    //firebase variables declaration
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference rootRef,userRef,userIdRef,profileRef;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile_student_sy);
        profilemessage = findViewById(R.id.student_home_profile_msg_student_sy);
        name=findViewById(R.id.student_home_info_name_student_sy);
        emailid=findViewById(R.id.student_home_info_email_student_sy);
        phoneno=findViewById(R.id.student_home_info_phoneno_student_sy);
        year =findViewById(R.id.student_home_info_year_student_sy);
        term=findViewById(R.id.student_home_info_term_student_sy);
        shift=findViewById(R.id.student_home_info_shift_student_sy);
        batch=findViewById(R.id.student_home_info_batch_student_sy);
        enroll=findViewById(R.id.student_home_info_enroll_sy);
        personal =findViewById(R.id.student_home_profile_personal_student_sy);
        quadet = findViewById(R.id.student_home_profile_qualification_student_sy);

        //ImageView
        profileImage =findViewById(R.id.student_home_profile_image);

        //database initialization
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        rootRef = firebaseDatabase.getReference();
        userRef = rootRef.child("SYProfiles");
        userid = firebaseAuth.getCurrentUser().getUid();
        userIdRef = userRef.child(userid);
        profileRef = userIdRef.child("profile");
        profileRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String Name = dataSnapshot.child("name").getValue().toString();
                    String email = dataSnapshot.child("email").getValue().toString();
                    String phone = dataSnapshot.child("phone").getValue().toString();
                    String Year = dataSnapshot.child("year").getValue().toString();
                    String Term = dataSnapshot.child("term").getValue().toString();
                    String Shift = dataSnapshot.child("shift").getValue().toString();
                    String Batch = dataSnapshot.child("batch").getValue().toString();
                    String EnrollmentNumber = dataSnapshot.child("enroll").getValue().toString();

                    //setting visibility of profile
                    profilemessage.setVisibility(View.INVISIBLE);
                    name.setVisibility(View.VISIBLE);
                    emailid.setVisibility(View.VISIBLE);
                    phoneno.setVisibility(View.VISIBLE);
                    year.setVisibility(View.VISIBLE);
                    term.setVisibility(View.VISIBLE);
                    shift.setVisibility(View.VISIBLE);
                    batch.setVisibility(View.VISIBLE);
                    enroll.setVisibility(View.VISIBLE);
                    personal.setVisibility(View.VISIBLE);
                    quadet.setVisibility(View.VISIBLE);
                    profileImage.setVisibility(View.VISIBLE);


                    //assigning values
                    name.setText("Name : "+Name);
                    emailid.setText("Email : "+email);
                    phoneno.setText("Phone : "+phone);
                    year.setText("Academic Year  : "+Year);
                    term.setText("Term : "+Term);
                    shift.setText("Shift : "+Shift);
                    batch.setText("Batch : "+Batch);
                    enroll.setText("Enrollment Number : "+EnrollmentNumber);


                }else{
                    profilemessage.setText("Please Create Your Profile First");
                    name.setVisibility(View.INVISIBLE);
                    emailid.setVisibility(View.INVISIBLE);
                    phoneno.setVisibility(View.INVISIBLE);
                    year.setVisibility(View.INVISIBLE);
                    term.setVisibility(View.INVISIBLE);
                    shift.setVisibility(View.INVISIBLE);
                    batch.setVisibility(View.INVISIBLE);
                    enroll.setVisibility(View.INVISIBLE);

                    profileImage.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ViewProfileStudentSy.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
