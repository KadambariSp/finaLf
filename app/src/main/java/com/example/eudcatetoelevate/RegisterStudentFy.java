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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Objects;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

public class RegisterStudentFy extends AppCompatActivity {
    EditText txtUser, txtEmail, txtPassword, txtRetypePassword;
    ProgressBar progressBar;
   // private FirebaseAuth mAuth;
    //private TextView forgotPassword;
    private FirebaseDatabase database;
    private DatabaseReference rootRef, userRef, useridRef;
    //private String userEmail, sameEmail, loginEmail;
    private Button SignUp;
    TextView signIn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student_fy);
        txtUser = findViewById(R.id.etUsernameFy);
        txtEmail = findViewById(R.id.etConfirmUsernameFy);
        signIn = findViewById(R.id.SignInFy);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterStudentFy.this, LoginStudentFy.class);
                startActivity(i);
            }
        });
        txtPassword = findViewById(R.id.etPasswordFy);
        txtRetypePassword = findViewById(R.id.etConfirmPasswordFy);
        SignUp = findViewById(R.id.buttonRegisterStudentFy);
        progressBar = findViewById(R.id.progressBarFy);
        firebaseAuth = FirebaseAuth.getInstance();
        //mAuth = getInstance();
        database = FirebaseDatabase.getInstance();
        rootRef = database.getReference();

        // database = FirebaseDatabase.getInstance();
        //rootRef = database.getReference();
        userRef = rootRef.child("FIRST YEAR");
        SignUp.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          final String username = txtUser.getText().toString().trim();
                                          String email = txtEmail.getText().toString().trim();
                                          String password = txtPassword.getText().toString().trim();
                                          String confirmPassword = txtRetypePassword.getText().toString().trim();
                                          if (TextUtils.isEmpty(username)) {
                                              Toast.makeText(RegisterStudentFy.this, "Please enter username", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if (TextUtils.isEmpty(email)) {
                                              Toast.makeText(RegisterStudentFy.this, "Please enter email", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if (TextUtils.isEmpty(password)) {
                                              Toast.makeText(RegisterStudentFy.this, "Please enter password", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                          if (TextUtils.isEmpty(confirmPassword)) {
                                              Toast.makeText(RegisterStudentFy.this, "Please enter confirm password", Toast.LENGTH_SHORT).show();
                                              return;
                                          }

                                          if (password.length() < 6) {
                                              Toast.makeText(RegisterStudentFy.this, "Password too short", Toast.LENGTH_SHORT).show();
                                          }

                                          progressBar.setVisibility(View.VISIBLE);
                                          if (password.equals(confirmPassword)) {
                                              firebaseAuth.createUserWithEmailAndPassword(email, password)
                                                      .addOnCompleteListener(RegisterStudentFy.this, new OnCompleteListener<AuthResult>() {
                                                          @Override
                                                          public void onComplete(@NonNull Task<AuthResult> task) {
                                                              progressBar.setVisibility(View.GONE);
                                                              if (task.isSuccessful()) {
                                                                  firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                      @Override
                                                                      public void onComplete(@NonNull Task<Void> task) {
                                                                          if (task.isSuccessful()) {
                                                                              Toast.makeText(RegisterStudentFy.this, "Registration Successfully.Please check your email for verification", Toast.LENGTH_SHORT).show();
                                                                              txtUser.setText("");
                                                                              txtEmail.setText("");
                                                                              txtPassword.setText("");
                                                                              txtRetypePassword.setText("");
                                                                              String userId = firebaseAuth.getCurrentUser().getUid();
                                                                              useridRef = userRef.child(userId);
                                                                              useridRef.child("username").child("username").setValue(username);
                                                                          } else {
                                                                              Toast.makeText(RegisterStudentFy.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                          }
                                                                      }
                                                                  });
                                                                  startActivity(new Intent(RegisterStudentFy.this, PhoneNumberCheckStudent.class));

                                                              } else {
                                                                  Toast.makeText(RegisterStudentFy.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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
