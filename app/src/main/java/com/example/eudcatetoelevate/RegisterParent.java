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

import com.example.eudcatetoelevate.Model.ParentSecretCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterParent extends AppCompatActivity {
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
        setContentView(R.layout.activity_register_parent);
        txtUser = findViewById(R.id.etUsernameParent);
        txtEmail = findViewById(R.id.etConfirmUsernameParent);
        signIn = findViewById(R.id.SignInParent);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterParent.this, LoginParent.class);
                startActivity(i);
            }
        });
        txtPassword = findViewById(R.id.etPasswordParent);
        txtRetypePassword = findViewById(R.id.etConfirmPasswordParent);
        SignUp = findViewById(R.id.buttonRegisterParent);
        progressBar = findViewById(R.id.progressBarParent);
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        rootRef = database.getReference();
        userRef = rootRef.child("PARENTS");
        SignUp.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          final String username = txtUser.getText().toString().trim();
                                          String email = txtEmail.getText().toString().trim();
                                          String password = txtPassword.getText().toString().trim();
                                          String confirmPassword = txtRetypePassword.getText().toString().trim();
                                          if (TextUtils.isEmpty(username)) {
                                              Toast.makeText(RegisterParent.this, "Username is Empty", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if (TextUtils.isEmpty(email)) {
                                              Toast.makeText(RegisterParent.this, "Email is Empty", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if (TextUtils.isEmpty(password)) {
                                              Toast.makeText(RegisterParent.this, "You have to enter password First to register", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if (TextUtils.isEmpty(confirmPassword)) {
                                              Toast.makeText(RegisterParent.this, "Confirm Password field is Empty", Toast.LENGTH_SHORT).show();
                                              return;
                                          }

                                          if (password.length() < 6) {
                                              Toast.makeText(RegisterParent.this, "Weak Password", Toast.LENGTH_SHORT).show();
                                          }

                                          progressBar.setVisibility(View.VISIBLE);
                                          if (password.equals(confirmPassword)) {
                                              firebaseAuth.createUserWithEmailAndPassword(email, password)
                                                      .addOnCompleteListener(RegisterParent.this, new OnCompleteListener<AuthResult>() {
                                                          @Override
                                                          public void onComplete(@NonNull Task<AuthResult> task) {
                                                              progressBar.setVisibility(View.GONE);
                                                              if (task.isSuccessful()) {
                                                                  firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                      @Override
                                                                      public void onComplete(@NonNull Task<Void> task) {
                                                                          if (task.isSuccessful()) {
                                                                              Toast.makeText(RegisterParent.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                                                              txtUser.setText("");
                                                                              txtEmail.setText("");
                                                                              txtPassword.setText("");
                                                                              txtRetypePassword.setText("");
                                                                              String userId = firebaseAuth.getCurrentUser().getUid();
                                                                              useridRef = userRef.child(userId);
                                                                              useridRef.child("username").child("username").setValue(username);
                                                                          } else {
                                                                              Toast.makeText(RegisterParent.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                          }
                                                                      }
                                                                  });
                                                                  startActivity(new Intent(RegisterParent.this, ParentSecretCodeCheck.class));

                                                              } else {
                                                                  Toast.makeText(RegisterParent.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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
