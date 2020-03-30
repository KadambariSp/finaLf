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

public class RegisterStudentTy extends AppCompatActivity {
   /* EditText txtUser,txtEmail,txtPassword,txtRetypePassword;
    ProgressBar progressBar;
    private Button SignUp;
    TextView signIn;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    private DatabaseReference rootRef, userRef, useridRef;
    */@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student_ty);
      /*  txtUser=findViewById(R.id.etUsernameTy);
        txtEmail=findViewById(R.id.etConfirmUsernameTy);
        signIn=findViewById(R.id.SignInTy);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterStudentTy.this,LoginStudentTy.class);
                startActivity(i);
            }
        });
        txtPassword=findViewById(R.id.etPasswordTy);
        txtRetypePassword=findViewById(R.id.etConfirmPasswordTy);
        SignUp=findViewById(R.id.buttonRegisterStudentTy);
        progressBar=findViewById(R.id.progressBarTy);
        firebaseAuth=FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        rootRef = database.getReference();
        userRef = rootRef.child("THIRD YEAR");
        SignUp.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v){
                                            final String username=txtUser.getText().toString().trim();
                                            String email =txtEmail.getText().toString().trim();
                                            String password=txtPassword.getText().toString().trim();
                                            String confirmPassword=txtRetypePassword.getText().toString().trim();
                                            if(TextUtils.isEmpty(username)){
                                                Toast.makeText(RegisterStudentTy.this, "Please enter username", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            if(TextUtils.isEmpty(email)){
                                                Toast.makeText(RegisterStudentTy.this, "Please enter email", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            if(TextUtils.isEmpty(password)){
                                                Toast.makeText(RegisterStudentTy.this, "Please enter password", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            if(TextUtils.isEmpty(confirmPassword)){
                                                Toast.makeText(RegisterStudentTy.this, "Please enter confirm password", Toast.LENGTH_SHORT).show();
                                                return;
                                            }

                                            if(password.length()<6){
                                                Toast.makeText(RegisterStudentTy.this, "Password too short", Toast.LENGTH_SHORT).show();
                                            }

                                            progressBar.setVisibility(View.VISIBLE);
                                            if(password.equals(confirmPassword)){
                                                firebaseAuth.createUserWithEmailAndPassword(email, password)
                                                        .addOnCompleteListener(RegisterStudentTy.this, new OnCompleteListener<AuthResult>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                                progressBar.setVisibility(View.GONE);
                                                                if (task.isSuccessful()) {
                                                                    firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                        @Override
                                                                        public void onComplete(@NonNull Task<Void> task) {
                                                                            if (task.isSuccessful()) {
                                                                                Toast.makeText(RegisterStudentTy.this, "Registration Successfully.Please chcek your email for verification", Toast.LENGTH_SHORT).show();
                                                                                txtUser.setText("");
                                                                                txtEmail.setText("");
                                                                                txtPassword.setText("");
                                                                                txtRetypePassword.setText("");
                                                                                String userId = firebaseAuth.getCurrentUser().getUid();
                                                                                useridRef = userRef.child(userId);
                                                                                useridRef.child("username").child("username").setValue(username);
                                                                            }else{
                                                                                Toast.makeText(RegisterStudentTy.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                            }
                                                                        }
                                                                    });
                                                                    startActivity(new Intent(RegisterStudentTy.this,LoginStudentTy.class));

                                                                } else {
                                                                    Toast.makeText(RegisterStudentTy.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                }

                                                                // ...
                                                            }
                                                        });

                                            }


                                        }

                                    }


        );
*/    }
}
