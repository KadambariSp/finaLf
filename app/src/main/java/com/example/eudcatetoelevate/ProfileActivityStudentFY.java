package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eudcatetoelevate.Model.StoreStudentProfileFY;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ProfileActivityStudentFY extends AppCompatActivity {

   // private ImageView profileImage;
    //   private ImageView navprofileImage;
    // private FloatingActionButton selectImage ;
    // private int GALLERY = 1 , CAMERA = 2;
    FirebaseAuth firebaseAuth;
    private FirebaseStorage firebaseStorage;
    private StorageReference useridReference, mStorageRef;
    private FirebaseUser firebaseUser;
    private String profileName;
    private String userid;
    private Button saveProfile;
    private ProgressDialog progressDialog;
   // private ProgressBar mProgressBar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference profileRef, rootRef, userRef, userIdRef, mDatabaseRef;
    //Uri filePath;
    //ImageView studentProfile;
    //Button btnupload;
    //private StorageTask mUploadTask;
    EditText student_profile_username;
    EditText student_profile_email;
    EditText student_profile_phonenumber;
    EditText student_profile_city;
    EditText student_profile_qualification;
    EditText student_profile_collegename;
    EditText student_profile_passing_year;
    EditText student_profile_fields;
    Button student_profile_resumesavebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_student_f_y);
        final TextView textView = findViewById(R.id.text_profile_student);
        student_profile_username = findViewById(R.id.student_profile_username);
        student_profile_email = findViewById(R.id.student_profile_email);
        student_profile_phonenumber = findViewById(R.id.student_profile_phonenumber);
        student_profile_city = findViewById(R.id.student_profile_city);
        student_profile_qualification = findViewById(R.id.student_profile_qualification);
        student_profile_collegename = findViewById(R.id.student_profile_collegename);
        student_profile_passing_year = findViewById(R.id.student_profile_passing_year);
        student_profile_fields = findViewById(R.id.student_profile_fields);
      //  mProgressBar = findViewById(R.id.progress_bar);

        //  profileImage=findViewById(R.id.student_profile_imageView);

        // saveProfile = (Button)root.findViewById(R.id.student_profile_resumesavebutton);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseStorage = FirebaseStorage.getInstance();
        StorageReference storageReference = firebaseStorage.getReference();
        StorageReference userReference = storageReference.child("student/");
        String userid = firebaseAuth.getCurrentUser().getUid().toString();
        useridReference = userReference.child(userid + "/");
        StorageReference ProfileRef = useridReference.child("profile/");
        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");
      /*  btnupload=findViewById(R.id.student_profile_uploadbutton);


        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUploadTask != null && mUploadTask.isInProgress()) {
                    Toast.makeText(ProfileActivityStudentFY.this, "Upload in Progress..", Toast.LENGTH_SHORT).show();
                } else {

                    uploadImage();
                }
            }
        });
        selectImage=findViewById(R.id.student_profile_floatingActionButton);
        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
            }
        });
*/
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
        rootRef = firebaseDatabase.getReference();
        userRef = rootRef.child("student");
        String userId = firebaseAuth.getCurrentUser().getUid().toString();
        userIdRef = userRef.child(userId);
        profileRef = userIdRef.child("profile");
        student_profile_resumesavebutton = findViewById(R.id.student_profile_resumesavebutton);

        profileRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String Name = dataSnapshot.child("name").getValue().toString();
                    String email = dataSnapshot.child("email").getValue().toString();
                    String phone = dataSnapshot.child("phone").getValue().toString();
                    String City = dataSnapshot.child("city").getValue().toString();
                    String Qualification = dataSnapshot.child("qualification").getValue().toString();
                    String Collegename = dataSnapshot.child("collegeName").getValue().toString();
                    String Passingyear = dataSnapshot.child("passingYear").getValue().toString();
                    String field = dataSnapshot.child("fields").getValue().toString();


                    student_profile_username.setText(Name);
                    student_profile_email.setText(email);
                    student_profile_phonenumber.setText(phone);
                    student_profile_city.setText(City);
                    student_profile_city.setText(City);
                    student_profile_qualification.setText(Qualification);
                    student_profile_collegename.setText(Collegename);
                    student_profile_passing_year.setText(Passingyear);
                    student_profile_fields.setText(field);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        student_profile_resumesavebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name, email, phone, city, qualification, collegeName, passingYear, fields;
                name = student_profile_username.getText().toString();
                email = student_profile_email.getText().toString();
                phone = student_profile_phonenumber.getText().toString();
                city = student_profile_city.getText().toString();
                qualification = student_profile_qualification.getText().toString();
                collegeName = student_profile_collegename.getText().toString();
                passingYear = student_profile_passing_year.getText().toString();
                fields = student_profile_fields.getText().toString();
           //     profileImage = findViewById(R.id.student_profile_imageView);


                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(ProfileActivityStudentFY.this, "Please enter Full name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(ProfileActivityStudentFY.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(ProfileActivityStudentFY.this, "Please enter phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(city)) {
                    Toast.makeText(ProfileActivityStudentFY.this, "Please enter company name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(qualification)) {
                    Toast.makeText(ProfileActivityStudentFY.this, "Please enter company location", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(collegeName)) {
                    Toast.makeText(ProfileActivityStudentFY.this, "Please enter company location", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passingYear)) {
                    Toast.makeText(ProfileActivityStudentFY.this, "Please enter company location", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fields)) {
                    Toast.makeText(ProfileActivityStudentFY.this, "Please enter fields of Interest", Toast.LENGTH_SHORT).show();
                    return;
                }
                student_profile_resumesavebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // uploadImage();
                    }
                });


                StoreStudentProfileFY ssp = new StoreStudentProfileFY(name, email, phone, city, qualification, collegeName, passingYear, fields);
                profileRef.setValue(ssp).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ProfileActivityStudentFY.this, "Profile Saved Successfully", Toast.LENGTH_SHORT).show();
                    }
                });

            }


        });


    }
    /*

    //FUNCTION FOR TAKING PHOTO FROM CAMERA INTENT
    private void takePhotoFromCamera() {
        if (ContextCompat.checkSelfPermission(ProfileActivityStudentFY.this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 10);

        }
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    //FUNCTION FOR CHOOSING IMAGE FROM GALLERY INTENT
    private void choosePhotoFromGallary() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY);
    }

    //ALERT DIALOG ASKING GALLERY OR CAMERA INTENT
    public void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select   Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();


    }

    //For storing data in imageview of student profile
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY && resultCode == RESULT_OK
                && data != null && data.getData() != null
        ) {
            filePath = data.getData();
            Picasso.get().load(filePath).into(profileImage);

        }

//        if (resultCode == Activity.RESULT_CANCELED) {
//            return;
//        }
//        if (requestCode == GALLERY && resultCode==RESULT_OK){
//            if (data != null) {
//                filePath= data.getData();
//                try {
//                    Bitmap imgbitmap = MediaStore.Images.Media.getBitmap(this.getContext().getContentResolver(), filePath);
//
//                    Toast.makeText(getActivity(), "Image Saved!", Toast.LENGTH_SHORT).show();
//                    profileImage.setImageBitmap(imgbitmap);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    Toast.makeText(getActivity(), "Failed!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//        } else if (requestCode == CAMERA && resultCode==RESULT_OK) {
//            Uri contentURI = data.getData();
//
//
//            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
//            profileImage.setImageBitmap(thumbnail);
//
//                }
//
//
//            Toast.makeText(getActivity(), "Image Saved!", Toast.LENGTH_SHORT).show();
    }
    private String getFileExtension(Uri uri) {
        ContentResolver cr = ProfileActivityStudentFY.this.getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }

    //uploading image
    private void uploadImage() {
        if (filePath != null) {
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(filePath));
            mUploadTask= fileReference.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);
                                }
                            }, 500);
                            Toast.makeText(ProfileActivityStudentFY.this, "SUCCESSFULLY !", Toast.LENGTH_SHORT).show();
//                           Upload upload=new Upload(mEditTextFileName.getText().toString().trim(),
//                                    taskSnapshot.getUploadSessionUri().toString());
//                            String uploadID=mDatabaseRef.push().getKey();
//                            mDatabaseRef.child(uploadID).setValue(upload);
                            Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                            while (!urlTask.isSuccessful()) ;
                            Uri downloadUrl = urlTask.getResult();
                            StudentProfileUpload upload = new StudentProfileUpload(downloadUrl.toString());
                            mDatabaseRef.child(mDatabaseRef.push().getKey()).setValue(upload);
                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(upload);



                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ProfileActivityStudentFY.this, e.getMessage(), Toast.LENGTH_LONG).show();


                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar.setProgress((int) progress);

                        }
                    });

        } else {
            Toast.makeText(ProfileActivityStudentFY.this, "Please select image", Toast.LENGTH_SHORT).show();
        }
*/






}













