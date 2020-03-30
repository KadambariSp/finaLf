package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eudcatetoelevate.Model.MobileNumbersStudent;
import com.example.eudcatetoelevate.Model.ParentSecretCodes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ParentSecretCodeCheck extends AppCompatActivity {
    EditText enrollParent,mobileParent;
    Button buttonNextParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_secret_code_check);
        enrollParent=(EditText)findViewById(R.id.enrollParent);
        mobileParent=(EditText)findViewById(R.id.mobile);
        buttonNextParent=(Button)findViewById(R.id.buttonNextParent);
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_Code=database.getReference("ParentSecretCodes");
        buttonNextParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_Code.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(enrollParent.getText().toString()).exists()){


                            ParentSecretCodes parentSecretCodes =dataSnapshot.child(enrollParent.getText().toString().trim()).getValue(ParentSecretCodes.class);
                            if (parentSecretCodes.getCode().equals(mobileParent.getText().toString())){
                                Toast.makeText(ParentSecretCodeCheck.this, "Right Code", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(ParentSecretCodeCheck.this,LoginParent.class);

                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(ParentSecretCodeCheck.this, "Something went Wrong!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(ParentSecretCodeCheck.this, "Wrong Secret Code ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });




    }
}
