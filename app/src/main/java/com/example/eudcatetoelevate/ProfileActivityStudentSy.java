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
import com.example.eudcatetoelevate.Model.StoreStudentProfileSY;
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
    EditText student_profile_username,student_profile_email,student_profile_phonenumber,student_profile_year,student_profile_term;
    EditText student_profile_shift,student_profile_batch,student_profile_enroll;
    Button student_profile_save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_student_sy);
        final TextView textView = findViewById(R.id.text_profile_student);
        student_profile_username=findViewById(R.id.student_profile_username_sy);
        student_profile_email=findViewById(R.id.student_profile_email_sy);
        student_profile_phonenumber=findViewById(R.id.student_profile_phonenumber_sy);
        student_profile_year=findViewById(R.id.student_profile_year_sy);
        student_profile_term=findViewById(R.id.student_profile_term_sy);
        student_profile_shift=findViewById(R.id.student_profile_shift_sy);
        student_profile_batch=findViewById(R.id.student_profile_batch_sy);
        student_profile_enroll=findViewById(R.id.student_profile_enroll_sy);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseStorage = FirebaseStorage.getInstance();
        final StorageReference storageReference = firebaseStorage.getReference();
        StorageReference userReference = storageReference.child("SYProfiles/");
        String userid = firebaseAuth.getCurrentUser().getUid().toString();
        useridReference = userReference.child(userid + "/");
        StorageReference ProfileRef = useridReference.child("profile/");
        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");



        firebaseAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
        rootRef = firebaseDatabase.getReference();
        userRef = rootRef.child("SYProfiles");
        String userId = firebaseAuth.getCurrentUser().getUid().toString();
        userIdRef = userRef.child(userId);
        profileRef = userIdRef.child("profile");
        student_profile_save_button = findViewById(R.id.student_profile_save_sy);



        profileRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String Name = dataSnapshot.child("name").getValue().toString();
                    String email = dataSnapshot.child("email").getValue().toString();
                    String phone = dataSnapshot.child("phone").getValue().toString();
                    String Year = dataSnapshot.child("year").getValue().toString();
                    String Term= dataSnapshot.child("term").getValue().toString();
                    String Shift = dataSnapshot.child("shift").getValue().toString();
                    String Batch = dataSnapshot.child("batch").getValue().toString();
                    String EnrollmentNumber = dataSnapshot.child("enroll").getValue().toString();


                    student_profile_username.setText(Name);
                    student_profile_email.setText(email);
                    student_profile_phonenumber.setText(phone);
                    student_profile_year.setText(Year);
                    student_profile_year.setText(Year);
                    student_profile_term.setText(Term);
                    student_profile_shift.setText(Shift);
                    student_profile_batch.setText(Batch);
                    student_profile_enroll.setText(EnrollmentNumber);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
student_profile_save_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final String name, email, phone, year,term, shift, batch, enroll;
        name = student_profile_username.getText().toString();
        email = student_profile_email.getText().toString();
        phone = student_profile_phonenumber.getText().toString();
        year= student_profile_year.getText().toString();
        term = student_profile_term.getText().toString();
        shift = student_profile_shift.getText().toString();
        batch = student_profile_batch.getText().toString();
        enroll = student_profile_enroll.getText().toString();
        StoreStudentProfileSY storeStudentProfileSY = new StoreStudentProfileSY(name,email,phone,year,term,shift,batch,enroll);
        profileRef.setValue(storeStudentProfileSY).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ProfileActivityStudentSy.this, "Profile Saved Successfully!!", Toast.LENGTH_SHORT).show();
            }
        });

    }


});





    }

}




