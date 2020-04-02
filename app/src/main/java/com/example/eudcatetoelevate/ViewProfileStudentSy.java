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
    EditText name, emailid, phoneno, city, qualification, collegename, passingyear, fieldofinterest;
    TextView profilemessage, personal, quadet;
    ImageView profileImage;
    //firebase variables declaration
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference rootRef, userRef, userIdRef, profileRef;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile_student_sy);
        profilemessage = findViewById(R.id.student_home_profile_msg_sy);
        name = findViewById(R.id.student_home_info_name_sy);
        emailid = findViewById(R.id.student_home_info_email_sy);
        phoneno = findViewById(R.id.student_home_info_phoneno_sy);
        city = findViewById(R.id.student_home_info_city_sy);
        qualification = findViewById(R.id.student_home_info_qualification_sy);
        collegename = findViewById(R.id.student_home_info_clgname_sy);
        passingyear = findViewById(R.id.student_home_info_passingyear_sy);
        fieldofinterest = findViewById(R.id.student_home_info_INTEREST_sy);
        personal = findViewById(R.id.student_home_profile_personal_sy);
        quadet = findViewById(R.id.student_home_profile_qualification_sy);

        //ImageView
        profileImage = findViewById(R.id.student_home_profile_image_sy);

        //database initialization
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        rootRef = firebaseDatabase.getReference();
        userRef = rootRef.child("studentSecondYearProfile");
        userid = firebaseAuth.getCurrentUser().getUid();
        userIdRef = userRef.child(userid);
        profileRef = userIdRef.child("profile");

        profileRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String Name = dataSnapshot.child("name").getValue().toString();
                    String email = dataSnapshot.child("email").getValue().toString();
                    String phone = dataSnapshot.child("phone").getValue().toString();
                    String City = dataSnapshot.child("city").getValue().toString();
                    String Qualification = dataSnapshot.child("qualification").getValue().toString();
                    String Collegename = dataSnapshot.child("collegeName").getValue().toString();
                    String Passingyear = dataSnapshot.child("passingYear").getValue().toString();
                    String field = dataSnapshot.child("fields").getValue().toString();

                    //setting visibility of profile
                    profilemessage.setVisibility(View.INVISIBLE);
                    name.setVisibility(View.VISIBLE);
                    emailid.setVisibility(View.VISIBLE);
                    phoneno.setVisibility(View.VISIBLE);
                    city.setVisibility(View.VISIBLE);
                    qualification.setVisibility(View.VISIBLE);
                    collegename.setVisibility(View.VISIBLE);
                    passingyear.setVisibility(View.VISIBLE);
                    fieldofinterest.setVisibility(View.VISIBLE);
                    personal.setVisibility(View.VISIBLE);
                    quadet.setVisibility(View.VISIBLE);
                    profileImage.setVisibility(View.VISIBLE);


                    //assigning values
                    name.setText("Name : " + Name);
                    emailid.setText("Email : " + email);
                    phoneno.setText("Phone : " + phone);
                    city.setText("City : " + City);
                    qualification.setText("Qualification : " + Qualification);
                    collegename.setText("College Name : " + Collegename);
                    passingyear.setText("Passing Year : " + Passingyear);
                    fieldofinterest.setText("Field : " + field);


                } else {
                    profilemessage.setText("Please Create Your Profile");
                    name.setVisibility(View.INVISIBLE);
                    emailid.setVisibility(View.INVISIBLE);
                    phoneno.setVisibility(View.INVISIBLE);
                    city.setVisibility(View.INVISIBLE);
                    qualification.setVisibility(View.INVISIBLE);
                    collegename.setVisibility(View.INVISIBLE);
                    passingyear.setVisibility(View.INVISIBLE);
                    fieldofinterest.setVisibility(View.INVISIBLE);

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
