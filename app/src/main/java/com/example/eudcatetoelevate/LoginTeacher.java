package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

public class LoginTeacher extends AppCompatActivity {
    EditText txtEmail, txtPassword;
    ProgressBar progressBar;
    Button btn_student_Login;
    private TextView Student_signup;
    private FirebaseAuth mAuth;
    private TextView forgotPassword;
    private FirebaseDatabase database;
    private DatabaseReference rootRef, userRef, useridRef;
    private String userEmail, sameEmail, loginEmail;


    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
            if (firebaseUser != null) {
                String userid = firebaseUser.getUid();
                userEmail = firebaseUser.getEmail();
                userRef = rootRef.child("TEACHERS");
                useridRef = userRef.child(userid);
                final ProgressDialog pd = new ProgressDialog(LoginTeacher.this);
                pd.setTitle("Logging Teacher");
                pd.setMessage("Wait for a while...");
                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd.setIcon(R.drawable.loading);

                pd.show();

                useridRef.child("username").child("username").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        sameEmail = (String) dataSnapshot.getValue();
                        if (Objects.equals(userEmail, sameEmail)) {
                            Intent intent = new Intent(LoginTeacher.this, NavigationTeachers.class);
                            startActivity(intent);
                            pd.dismiss();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // error message
                    }
                });

            } else {
                Toast.makeText(LoginTeacher.this, "It Seems that You haven't logged in!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);
        txtEmail = (EditText) findViewById(R.id.editTextUsernameTeacher);
        txtPassword = (EditText) findViewById(R.id.editTextPasswordTeacher);
        btn_student_Login = (Button) findViewById(R.id.buttonLoginTeacher);
        Student_signup = (TextView) findViewById(R.id.TvRegisterTeachers);
        progressBar = (ProgressBar) findViewById(R.id.progressBarTeacherLogin);
        mAuth = getInstance();
        database = FirebaseDatabase.getInstance();
        rootRef = database.getReference();
        btn_student_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginTeacher.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginTeacher.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(LoginTeacher.this, "Password is Very Short", Toast.LENGTH_SHORT).show();
                }
                final ProgressDialog pd = new ProgressDialog(LoginTeacher.this);
                pd.setTitle("Wait for Sometime...");
                pd.setMessage("Authenticating User");
                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd.show();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginTeacher.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    if (mAuth.getCurrentUser().isEmailVerified()) {
                                        String userid = mAuth.getCurrentUser().getUid();
                                        userRef = rootRef.child("TEACHERS");
                                        useridRef = userRef.child(userid);
                                        useridRef.child("username").child("username");
                                        useridRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                loginEmail = (String) dataSnapshot.getValue();
                                                if (Objects.equals(email, loginEmail)) {
                                                    startActivity(new Intent(LoginTeacher.this, NavigationTeachers.class));
                                                    pd.dismiss();
                                                } else {
                                                    FirebaseAuth.getInstance().signOut();
                                                    Toast.makeText(LoginTeacher.this, "You are not authorized as Parent Please Log in using Parent", Toast.LENGTH_SHORT).show();
                                                    finish();
                                                    pd.dismiss();
                                                    startActivity(new Intent(LoginTeacher.this, LoginTeacher.class));
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                                //error message
                                            }
                                        });
                                    } else {
                                        Toast.makeText(LoginTeacher.this, "Please verify your email address Ma'am", Toast.LENGTH_SHORT).show();


                                    }
                                } else {
                                    Toast.makeText(LoginTeacher.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    pd.dismiss();

                                }

                                // ...
                            }
                        });
            }
        });

        Student_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginTeacher.this, RegisterTeachers.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(authStateListener);
    }
}
