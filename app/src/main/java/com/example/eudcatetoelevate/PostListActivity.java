package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayOutputStream;

import static com.google.firebase.storage.FirebaseStorage.getInstance;

public class PostListActivity extends AppCompatActivity {
    LinearLayoutManager mLayoutManager;
    SharedPreferences mSharedPref;
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    FirebaseRecyclerAdapter<model,ViewHolder>firebaseRecyclerAdapter;
    FirebaseRecyclerOptions <model>options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Posts List");
        mSharedPref=getSharedPreferences("SortSettings",MODE_PRIVATE);
        String mSorting=mSharedPref.getString("Sort","newest");
        if(mSorting.equals("newest")){
            mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setReverseLayout(true);
            mLayoutManager.setStackFromEnd(true);
        }
        else if(mSorting.equals("oldest")){
            mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setReverseLayout(false);
            mLayoutManager.setStackFromEnd(false);
        }
        mRecyclerView=findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mRef=mFirebaseDatabase.getReference("Data");
        showData();
    }


    private void showDeleteDataDialog(final String currentTitle, final String currentImage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(PostListActivity.this);
        builder.setTitle("Delete");
        builder.setMessage("Are you sure you want to delete this Notice ??");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Query mQuery = mRef.orderByChild("title").equalTo(currentTitle);
                mQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds: dataSnapshot.getChildren()) {
                            ds.getRef().removeValue();
                        }
                        Toast.makeText(PostListActivity.this, "Notice deleted successfully...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(PostListActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                StorageReference mPictureRefe = getInstance().getReferenceFromUrl(currentImage);
                mPictureRefe.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(PostListActivity.this, "Image from database deleted successfully...", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PostListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void showData(){
        options =new FirebaseRecyclerOptions.Builder<model>().setQuery(mRef,model.class).build();

        firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<model, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull model model) {
                holder.setDetails(getApplicationContext(),model.getTitle(),model.getDescription(),model.getImage());

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
                ViewHolder viewHolder=new ViewHolder(itemView);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String mTitle=getItem(position).getTitle();
                        String mDesc=getItem(position).getDescription();
                        String mImage=getItem(position).getImage();

                        Intent intent =new Intent (view.getContext(),PostDetailActivity.class);
                        intent.putExtra("title",mTitle);
                        intent.putExtra("description",mDesc);
                        intent.putExtra("image",mImage);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemlongClick(View view, int position) {
                        final String cTitle = getItem(position).getTitle();
                        final String cDescr = getItem(position).getDescription();
                        final String cImage = getItem(position).getImage();
                        AlertDialog.Builder builder = new AlertDialog.Builder(PostListActivity.this);
                        builder.setTitle("What action you want to perform?");
                        String[] options = {"Update", "Delete"};
                        builder.setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == 0) {
                                    Intent intent = new Intent(PostListActivity.this, AddPostActivity.class);
                                    intent.putExtra("cTitle", cTitle);
                                    intent.putExtra("cDescr", cDescr);
                                    intent.putExtra("cImage", cImage);
                                    startActivity(intent);
                                }
                                if (which == 1) {
                                    showDeleteDataDialog(cTitle, cImage);
                                }
                            }
                        });
                        builder.create().show();

                    }
                });
                return viewHolder;
            }
        };

        mRecyclerView.setLayoutManager(mLayoutManager);
        firebaseRecyclerAdapter.startListening();
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    private void firebaseSearch(String searchText){


        String query=searchText.toLowerCase();
        Query firebaseSearchQuery=mRef.orderByChild("search").startAt(query).endAt(query,"\uf8ff");
        options =new FirebaseRecyclerOptions.Builder<model>().setQuery(firebaseSearchQuery,model.class).build();

        firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<model, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull model model) {
                holder.setDetails(getApplicationContext(),model.getTitle(),model.getDescription(),model.getImage());

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
                ViewHolder viewHolder=new ViewHolder(itemView);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String mTitle=getItem(position).getTitle();
                        String mDesc=getItem(position).getDescription();
                        String mImage=getItem(position).getImage();

                        Intent intent =new Intent (view.getContext(),PostDetailActivity.class);
                        intent.putExtra("title",mTitle);
                        intent.putExtra("description",mDesc);
                        intent.putExtra("image",mImage);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemlongClick(View view, int position) {
                        final String cTitle = getItem(position).getTitle();
                        final String cDescr = getItem(position).getDescription();
                        final String cImage = getItem(position).getImage();
                        AlertDialog.Builder builder = new AlertDialog.Builder(PostListActivity.this);
                        builder.setTitle("What action you want to perform??");
                        String[] options = {"Update", "Delete"};
                        builder.setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == 0) {
                                    Intent intent = new Intent(PostListActivity.this, AddPostActivity.class);
                                    intent.putExtra("cTitle", cTitle);
                                    intent.putExtra("cDescr", cDescr);
                                    intent.putExtra("cImage", cImage);
                                    startActivity(intent);
                                }
                                if (which == 1) {
                                    showDeleteDataDialog(cTitle, cImage);
                                }
                            }
                        });
                        builder.create().show();
                    }
                });
                return viewHolder;
            }
        };

        mRecyclerView.setLayoutManager(mLayoutManager);
        firebaseRecyclerAdapter.startListening();
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);




    }


    @Override
    protected void onStart() {
        super.onStart();
        if (firebaseRecyclerAdapter!=null){
            firebaseRecyclerAdapter.startListening();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebaseSearch(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                firebaseSearch(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_sort){
            showSortDialog();
            return true;
        }
        if(id==R.id.action_add){
            startActivity(new Intent(PostListActivity.this, AddPostActivity.class));
            return true;
        }




        return super.onOptionsItemSelected(item);
    }

    private void showSortDialog() {
        String[] sortOptions={"Newest","Oldest"};
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Sort by ?")
                .setIcon(R.drawable.sort)
                .setItems(sortOptions, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if (which == 0) {
                            SharedPreferences.Editor editor=mSharedPref.edit();
                            editor.putString("Sort","newest");
                            editor.apply();
                            recreate();
                        }
                        else if(which == 1) {
                            {
                                SharedPreferences.Editor editor=mSharedPref.edit();
                                editor.putString("Sort","oldest");
                                editor.apply();
                                recreate();

                            }
                        }
                    }
                });
        builder.show();

    }
}
