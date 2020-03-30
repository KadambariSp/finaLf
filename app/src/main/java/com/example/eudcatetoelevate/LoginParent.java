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

public class LoginParent extends AppCompatActivity {
    EditText txtEmail,txtPassword;
    ProgressBar progressBarParent;
    Button btn_student_Login;
    private TextView Student_signup;
    private FirebaseAuth mAuth;
    private TextView forgotPassword;
    private FirebaseDatabase database;
    private DatabaseReference rootRef, userRef, useridRef;
    private String userEmail, sameEmail, loginEmail;
    //for one time login

    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
            if (firebaseUser != null) {
                String userid=firebaseUser.getUid();
                userEmail = firebaseUser.getEmail();
                userRef=rootRef.child("PARENTS");
                useridRef = userRef.child(userid);
                final ProgressDialog pd = new ProgressDialog(LoginParent.this);
                pd.setTitle("Logging As Parent");
                pd.setMessage("Please wait logging in");
                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd.show();

                useridRef.child("username").child("username").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        sameEmail = (String) dataSnapshot.getValue();
                        if (Objects.equals(userEmail, sameEmail)) {
                            Intent intent = new Intent(LoginParent.this,NavigationParents.class);
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

            }
            else{
                Toast.makeText(LoginParent.this, "Please Sign in ", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_parent);
        txtEmail=(EditText) findViewById(R.id.editTextUsernameParent);
        txtPassword=(EditText)findViewById(R.id.editTextPasswordParent);
        btn_student_Login   = (Button) findViewById(R.id.buttonLoginParent);
        Student_signup=(TextView)findViewById(R.id.TvRegisterParents);
        progressBarParent=(ProgressBar) findViewById(R.id.progressBarParentLogin);
        mAuth = getInstance();
        database = FirebaseDatabase.getInstance();
        rootRef = database.getReference();
        btn_student_Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String email =txtEmail.getText().toString().trim();
                String password=txtPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(LoginParent.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LoginParent.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length()<6){
                    Toast.makeText(LoginParent.this, "Password too short", Toast.LENGTH_SHORT).show();
                }
                final ProgressDialog pd = new ProgressDialog(LoginParent.this);
                pd.setTitle("Logging Parent..");
                pd.setMessage("Please wait validating credentials and logging in......");
                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd.show();
                mAuth .signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginParent.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBarParent.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    if(mAuth.getCurrentUser().isEmailVerified()) {
                                        String userid = mAuth.getCurrentUser().getUid();
                                        userRef = rootRef.child("PARENTS");
                                        useridRef = userRef.child(userid);
                                        useridRef.child("username").child("username");
                                        useridRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                loginEmail = (String) dataSnapshot.getValue();
                                                if (Objects.equals(email, loginEmail)) {
                                                    startActivity(new Intent(LoginParent.this, NavigationParents.class));
                                                    pd.dismiss();
                                                } else {
                                                    FirebaseAuth.getInstance().signOut();
                                                    Toast.makeText(LoginParent.this, "Please login using a Parent account only ", Toast.LENGTH_SHORT).show();
                                                    finish();
                                                    pd.dismiss();
                                                    startActivity(new Intent(LoginParent.this,LoginParent.class));
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                                //error message
                                            }
                                        });
                                    }else{
                                        Toast.makeText(LoginParent.this,"Dear user, Please Verify Your Email Address First",Toast.LENGTH_SHORT).show();


                                    }
                                } else {
                                    Toast.makeText(LoginParent.this, task.getException().getMessage(),Toast.LENGTH_LONG).show();
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
                startActivity(new Intent(LoginParent.this,RegisterParent.class));
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
