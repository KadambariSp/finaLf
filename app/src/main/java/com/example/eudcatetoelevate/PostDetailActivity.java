package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.Manifest;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PostDetailActivity extends AppCompatActivity {
    TextView mTitleTv, mDetailTv;
    ImageView mImageIv;
    Bitmap bitmap;
    Button mSaveBtn,mShareBtn,mWallBtn;
    private static final int WRITE_EXTERNAL_STORAGE_CODE =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Post Detail");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        mTitleTv=findViewById(R.id.titleTv);
        mDetailTv=findViewById(R.id.descriptionTv);
        mImageIv=findViewById(R.id.imageView);
        mSaveBtn=findViewById(R.id.save_btn);


        String image=getIntent().getStringExtra("image");
        String title= getIntent().getStringExtra("title");
        String desc= getIntent().getStringExtra("description");

        mTitleTv.setText(title);
        mDetailTv.setText(desc);
        Picasso.get().load(image).into(mImageIv);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                            PackageManager.PERMISSION_DENIED){
                        String [] permission={Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission,WRITE_EXTERNAL_STORAGE_CODE);
                    }
                    else {
                        saveImage();
                    }
                }
                else {
                    saveImage();
                }

            }
        });

    }

    private void saveImage() {
        bitmap=((BitmapDrawable)mImageIv.getDrawable()).getBitmap();

        String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());
        File path= Environment.getExternalStorageDirectory();
        File dir= new File(path+"/GPMCOLEARNFORWARD/");
        dir.mkdirs();
        String imageName= timeStamp + ".PNG";
        File file= new  File(dir,imageName);
        OutputStream out;
        try{
            out=new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,out);
            out.flush();
            out.close();
            Toast.makeText(this,imageName+"saved to"+ dir,Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case WRITE_EXTERNAL_STORAGE_CODE:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    saveImage();
                }
                else {
                    Toast.makeText(this,"enable permission to save image",Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
}

