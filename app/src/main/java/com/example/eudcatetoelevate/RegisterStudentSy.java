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

public class RegisterStudentSy extends AppCompatActivity {
   EditText txtUser,txtEmail,txtPassword,txtRetypePassword;
    ProgressBar progressBar;
    private Button SignUp;
    TextView signIn;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    private DatabaseReference rootRef, userRef, useridRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student_sy);
       txtUser=findViewById(R.id.etUsernameSy);
        txtEmail=findViewById(R.id.etConfirmUsernameSy);
        signIn=findViewById(R.id.SignInSy);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterStudentSy.this,LoginStudentSy.class);
                startActivity(i);
            }
        });
        txtPassword=findViewById(R.id.etPasswordSy);
        txtRetypePassword=findViewById(R.id.etConfirmPasswordSy);
        SignUp=findViewById(R.id.buttonRegisterStudentSy);
        progressBar=findViewById(R.id.progressBarSy);
        firebaseAuth=FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        rootRef = database.getReference();
        userRef = rootRef.child("SECOND YEAR");
        SignUp.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v){
                                          final String username=txtUser.getText().toString().trim();
                                          String email =txtEmail.getText().toString().trim();
                                          String password=txtPassword.getText().toString().trim();
                                          String confirmPassword=txtRetypePassword.getText().toString().trim();
                                          if(TextUtils.isEmpty(username)){
                                              Toast.makeText(RegisterStudentSy.this, "Please enter username", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if(TextUtils.isEmpty(email)){
                                              Toast.makeText(RegisterStudentSy.this, "Please enter email", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if(TextUtils.isEmpty(password)){
                                              Toast.makeText(RegisterStudentSy.this, "Please enter password", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if(TextUtils.isEmpty(confirmPassword)){
                                              Toast.makeText(RegisterStudentSy.this, "Please enter confirm password", Toast.LENGTH_SHORT).show();
                                              return;
                                          }

                                          if(password.length()<6){
                                              Toast.makeText(RegisterStudentSy.this, "Password too short", Toast.LENGTH_SHORT).show();
                                          }

                                          progressBar.setVisibility(View.VISIBLE);
                                          if(password.equals(confirmPassword)){
                                              firebaseAuth.createUserWithEmailAndPassword(email, password)
                                                      .addOnCompleteListener(RegisterStudentSy.this, new OnCompleteListener<AuthResult>() {
                                                          @Override
                                                          public void onComplete(@NonNull Task<AuthResult> task) {
                                                              progressBar.setVisibility(View.GONE);
                                                              if (task.isSuccessful()) {
                                                                  firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                      @Override
                                                                      public void onComplete(@NonNull Task<Void> task) {
                                                                          if (task.isSuccessful()) {
                                                                              Toast.makeText(RegisterStudentSy.this, "Registration Successfully.Please chcek your email for verification", Toast.LENGTH_SHORT).show();
                                                                              txtUser.setText("");
                                                                              txtEmail.setText("");
                                                                              txtPassword.setText("");
                                                                              txtRetypePassword.setText("");
                                                                              String userId = firebaseAuth.getCurrentUser().getUid();
                                                                              useridRef = userRef.child(userId);
                                                                              useridRef.child("username").child("username").setValue(username);
                                                                          }else{
                                                                              Toast.makeText(RegisterStudentSy.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                          }
                                                                      }
                                                                  });
                                                                  startActivity(new Intent(RegisterStudentSy.this,PhoneNumberCheckStudentSy.class));

                                                              } else {
                                                                  Toast.makeText(RegisterStudentSy.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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
