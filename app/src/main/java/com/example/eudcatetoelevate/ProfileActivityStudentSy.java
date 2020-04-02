package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eudcatetoelevate.Model.StoreStudentProfileFY;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ProfileActivityStudentSy extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    private FirebaseStorage firebaseStorage;
    private StorageReference useridReference, mStorageRef;
    private FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference profileRef, rootRef, userRef, userIdRef, mDatabaseRef;
    EditText student_profile_username, student_profile_email, student_profile_phonenumber, student_profile_city, student_profile_qualification;
    EditText student_profile_collegename, student_profile_passing_year, student_profile_fields;
    Button student_profile_resumesavebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_student_sy);
        final TextView textView = findViewById(R.id.text_profile_student);
        student_profile_username = findViewById(R.id.student_profile_username_sy);
        student_profile_email = findViewById(R.id.student_profile_email_sy);
        student_profile_phonenumber = findViewById(R.id.student_profile_phonenumber_sy);
        student_profile_city = findViewById(R.id.student_profile_city_sy);
        student_profile_qualification = findViewById(R.id.student_profile_qualification_sy);
        student_profile_collegename = findViewById(R.id.student_profile_collegename_sy);
        student_profile_passing_year = findViewById(R.id.student_profile_passing_year_sy);
        student_profile_fields = findViewById(R.id.student_profile_fields_sy);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseStorage = FirebaseStorage.getInstance();
        StorageReference storageReference = firebaseStorage.getReference();
        StorageReference userReference = storageReference.child("studentSecondYearProfile/");
        String userid = firebaseAuth.getCurrentUser().getUid().toString();
        useridReference = userReference.child(userid + "/");
        StorageReference ProfileRef = useridReference.child("profile/");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        rootRef = firebaseDatabase.getReference();
        userRef = rootRef.child("studentSecondYearProfile");
        String userId = firebaseAuth.getCurrentUser().getUid().toString();
        userIdRef = userRef.child(userId);
        profileRef = userIdRef.child("profile");
        student_profile_resumesavebutton = findViewById(R.id.student_profile_resumesavebutton_sy);



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


                    student_profile_username.setText(Name);
                    student_profile_email.setText(email);
                    student_profile_phonenumber.setText(phone);
                    student_profile_city.setText(City);
                    student_profile_city.setText(City);
                    student_profile_qualification.setText(Qualification);
                    student_profile_collegename.setText(Collegename);
                    student_profile_passing_year.setText(Passingyear);
                    student_profile_fields.setText(field);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        student_profile_resumesavebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name, email, phone, city, qualification, collegeName, passingYear, fields;
                name = student_profile_username.getText().toString();
                email = student_profile_email.getText().toString();
                phone = student_profile_phonenumber.getText().toString();
                city = student_profile_city.getText().toString();
                qualification = student_profile_qualification.getText().toString();
                collegeName = student_profile_collegename.getText().toString();
                passingYear = student_profile_passing_year.getText().toString();
                fields = student_profile_fields.getText().toString();
                //     profileImage = findViewById(R.id.student_profile_imageView);


                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(ProfileActivityStudentSy.this, "Please enter Full name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(ProfileActivityStudentSy.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(ProfileActivityStudentSy.this, "Please enter phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(city)) {
                    Toast.makeText(ProfileActivityStudentSy.this, "Please enter company name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(qualification)) {
                    Toast.makeText(ProfileActivityStudentSy.this, "Please enter company location", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(collegeName)) {
                    Toast.makeText(ProfileActivityStudentSy.this, "Please enter company location", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passingYear)) {
                    Toast.makeText(ProfileActivityStudentSy.this, "Please enter company location", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fields)) {
                    Toast.makeText(ProfileActivityStudentSy.this, "Please enter fields of Interest", Toast.LENGTH_SHORT).show();
                    return;
                }
                student_profile_resumesavebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // uploadImage();
                    }
                });


                StoreStudentProfileFY ssp = new StoreStudentProfileFY(name, email, phone, city, qualification, collegeName, passingYear, fields);
                profileRef.setValue(ssp).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ProfileActivityStudentSy.this, "Profile Saved Successfully", Toast.LENGTH_SHORT).show();
                    }
                });

            }


        });


    }


}

