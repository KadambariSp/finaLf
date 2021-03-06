package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class listcurrify extends AppCompatActivity {
    ListView myPDFListView;
    DatabaseReference databaseReference;
    List<getsetfy> uploadPDFS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcurrify);
        myPDFListView=(ListView)findViewById(R.id.listViewcurrify);
        uploadPDFS= new ArrayList<>();
        viewAllFiles();

        myPDFListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                getsetfy uploadPDF=uploadPDFS.get(position);

                Intent intent= new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uploadPDF.getUrl()));
                startActivity(intent);
            }
        });

    }

    private void viewAllFiles()
    {
        databaseReference= FirebaseDatabase.getInstance().getReference("uploadsfy");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    getsetfy uploadPDF=postSnapshot.getValue(com.example.eudcatetoelevate.getsetfy.class);
                    uploadPDFS.add(uploadPDF);

                }
                String[] uploads=new String[uploadPDFS.size()];
                for(int i=0;i<uploads.length;i++){
                    uploads[i]=uploadPDFS.get(i).getName();
                }
                ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(),R.layout.listtv,uploads){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view=super.getView(position,convertView,parent);

                        return view;
                    }
                };
                myPDFListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
