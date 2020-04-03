package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowTextPostActivityStudents extends AppCompatActivity {

    public class FirebaseHelper1{
        DatabaseReference db;
        Boolean saved;
        ArrayList<AddTextPostTeacher> addTextPostTeachers=new ArrayList<>();
        ListView mListView;
        android.content.Context c;
        public FirebaseHelper1(DatabaseReference db, android.content.Context context, ListView mListView){
            this.db=db;
            this.c=context;
            this.mListView=mListView;
            this.retrieve();
        }
        public boolean save(AddTextPostTeacher addTextPostTeacher){
            if (addTextPostTeacher==null){
                saved=false;
            }else{
                try{
                    db.child("AddTextPostTeacher").push().setValue(addTextPostTeacher);
                    saved=true;
                }catch(DatabaseException e){
                    e.printStackTrace();
                    saved=false;}
            }
            return saved;
        }
        public ArrayList<AddTextPostTeacher>retrieve(){
            db.child("AddTextPostTeacher").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    addTextPostTeachers.clear();
                    if (dataSnapshot.exists() && dataSnapshot.getChildrenCount()>0){
                        for(DataSnapshot ds:dataSnapshot.getChildren()){
                            AddTextPostTeacher addTextPostTeacher=ds.getValue(AddTextPostTeacher.class);
                            addTextPostTeachers.add(addTextPostTeacher);
                        }
                        adapter=new CustomAdapter1(c,addTextPostTeachers);
                        mListView.setAdapter(adapter);
                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                mListView.smoothScrollToPosition(addTextPostTeachers.size());
                            }
                        });
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d("mTAG",databaseError.getMessage());

                }
            });
            return addTextPostTeachers;

        }
    }

    class CustomAdapter1 extends BaseAdapter {
        android.content.Context c;
        ArrayList<AddTextPostTeacher>addTextPostTeachers;
        public CustomAdapter1(Context c, ArrayList<AddTextPostTeacher>addTextPostTeachers){
            this.c=c;
            this.addTextPostTeachers=addTextPostTeachers;
        }

        @Override
        public int getCount() {
            return addTextPostTeachers.size();
        }

        @Override
        public Object getItem(int position) {
            return addTextPostTeachers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
            }
            TextView nameTextView=convertView.findViewById(R.id.nameTextView);
            TextView quoteTextView=convertView.findViewById(R.id.quoteTextView);
            TextView descriptionTextView=convertView.findViewById(R.id.descriptionTextView);
            final AddTextPostTeacher s=(AddTextPostTeacher) this.getItem(position);
            nameTextView.setText(s.getName());
            quoteTextView.setText(s.getPropellant());
            descriptionTextView.setText(s.getDescription());
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c, s.getName(), Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }
    }
    DatabaseReference db;
    FirebaseHelper1 helper;
    CustomAdapter1 adapter;
    ListView mListView;
    EditText nameEditText,quoteEditText,descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text_post_students);
        mListView=(ListView)findViewById(R.id.myListView);
        db= FirebaseDatabase.getInstance().getReference();
        helper=new FirebaseHelper1(db,this,mListView);
    }
}
