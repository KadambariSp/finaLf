package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterTeachers extends AppCompatActivity {
    EditText txtUser, txtEmail, txtPassword, txtRetypePassword;
    ProgressBar progressBar;
    private FirebaseDatabase database;
    private DatabaseReference rootRef, userRef, useridRef;
    private Button SignUp;
    TextView signIn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_teachers);
        txtUser = findViewById(R.id.etUsernameTeacher);
        txtEmail = findViewById(R.id.etConfirmUsernameTeacher);
        signIn = findViewById(R.id.SignInTeacher);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterTeachers.this, LoginTeacher.class);
                startActivity(i);
            }
        });
        txtPassword = findViewById(R.id.etPasswordTeacher);
        txtRetypePassword = findViewById(R.id.etConfirmPasswordTeacher);
        SignUp = findViewById(R.id.buttonRegisterTeacher);
        progressBar = findViewById(R.id.progressBarTeacher);
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        rootRef = database.getReference();
        userRef = rootRef.child("TEACHERS");
        SignUp.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          final String username = txtUser.getText().toString().trim();
                                          String email = txtEmail.getText().toString().trim();
                                          String password = txtPassword.getText().toString().trim();
                                          String confirmPassword = txtRetypePassword.getText().toString().trim();
                                          if (TextUtils.isEmpty(username)) {
                                              Toast.makeText(RegisterTeachers.this, "Username is Empty", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if (TextUtils.isEmpty(email)) {
                                              Toast.makeText(RegisterTeachers.this, "Email is empty", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if (TextUtils.isEmpty(password)) {
                                              Toast.makeText(RegisterTeachers.this, "You have to enter password first to register", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if (TextUtils.isEmpty(confirmPassword)) {
                                              Toast.makeText(RegisterTeachers.this, " enter confirm password", Toast.LENGTH_SHORT).show();
                                              return;
                                          }

                                          if (password.length() < 6) {
                                              Toast.makeText(RegisterTeachers.this, "Password too short", Toast.LENGTH_SHORT).show();
                                          }

                                          progressBar.setVisibility(View.VISIBLE);
                                          if (password.equals(confirmPassword)) {
                                              firebaseAuth.createUserWithEmailAndPassword(email, password)
                                                      .addOnCompleteListener(RegisterTeachers.this, new OnCompleteListener<AuthResult>() {
                                                          @Override
                                                          public void onComplete(@NonNull Task<AuthResult> task) {
                                                              progressBar.setVisibility(View.GONE);
                                                              if (task.isSuccessful()) {
                                                                  firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                      @Override
                                                                      public void onComplete(@NonNull Task<Void> task) {
                                                                          if (task.isSuccessful()) {
                                                                              Toast.makeText(RegisterTeachers.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                                                              txtUser.setText("");
                                                                              txtEmail.setText("");
                                                                              txtPassword.setText("");
                                                                              txtRetypePassword.setText("");
                                                                              String userId = firebaseAuth.getCurrentUser().getUid();
                                                                              useridRef = userRef.child(userId);
                                                                              useridRef.child("username").child("username").setValue(username);
                                                                          } else {
                                                                              Toast.makeText(RegisterTeachers.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                          }
                                                                      }
                                                                  });
                                                                  startActivity(new Intent(RegisterTeachers.this, PhoneNumberCheckTeachers.class));

                                                              } else {
                                                                  Toast.makeText(RegisterTeachers.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                              }

                                                              // ...
                                                          }
                                                      });

                                          }


                                      }

                                  }


        );
    }
}
