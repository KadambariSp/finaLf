package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingAdapterFy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingAdapterTeachers;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingFyHelperClass;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingTeacherHelperClass;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpAdapterTeachers;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpHelperClassTeacher;
import com.example.eudcatetoelevate.Model.MobileNumbersTeacher;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dmax.dialog.SpotsDialog;

public class
NavigationTeachers extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView navTeachersClick;
    LinearLayout contentView;
    RecyclerView codingRecyclerViewTeachers;
    RecyclerView mostImpFyRecyclerViewTeachers;
    RecyclerView.Adapter adapterMostImpTeachers;
    RecyclerView.Adapter adapterTeacher;
    static final float END_SCALE = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_navigation_teachers);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_teacher);
        navigationView = (NavigationView) findViewById(R.id.nav_view_teachers);
        navTeachersClick = (ImageView) findViewById(R.id.navclickteacher);
        contentView = (LinearLayout) findViewById(R.id.content);
        codingRecyclerViewTeachers = (RecyclerView) findViewById(R.id.codingRecyclerViewTeacher);
        mostImpFyRecyclerViewTeachers = (RecyclerView) findViewById(R.id.mostImpRecyclerViewTeacher);
        mostImpFyRecyclerView();
        codingRecyclerView();
        navigationDrawerOpen();


    }

    private void mostImpFyRecyclerView() {
        mostImpFyRecyclerViewTeachers.setHasFixedSize(true);
        mostImpFyRecyclerViewTeachers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostImpHelperClassTeacher> mostImpTeacherLocations = new ArrayList<>();
        mostImpTeacherLocations.add(new MostImpHelperClassTeacher(R.drawable.spinner, "Substitute for College Website", "As you know we already have a website of our whole institute but it's no sufficient also , website might cause server-down issues that's the reason behind this project!!"));
        mostImpTeacherLocations.add(new MostImpHelperClassTeacher(R.drawable.coder, "Parent will be notified every time ", "Many students especially hostel students , don't tell their parents about detention list or may be Backlogs so our application will help to solve this issue parents will be notified in case of PTM , or detention of their children"));
        adapterMostImpTeachers = new MostImpAdapterTeachers(mostImpTeacherLocations);
        mostImpFyRecyclerViewTeachers.setAdapter(adapterMostImpTeachers);

    }

    private void codingRecyclerView() {
        codingRecyclerViewTeachers.setHasFixedSize(true);
        codingRecyclerViewTeachers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<CodingTeacherHelperClass> codingTeacherLocations = new ArrayList<>();
        codingTeacherLocations.add(new CodingTeacherHelperClass(R.drawable.dribbble, "Easy to Use", "If you have any Query about how to use this application? you can Simply ask learn forward team!"));
        codingTeacherLocations.add(new CodingTeacherHelperClass(R.drawable.security, "Secure", "No person other than from CO-dept can logged in into this Application"));
        codingTeacherLocations.add(new CodingTeacherHelperClass(R.drawable.creative, "Responsive User Interface", "GUI of learn forward is so User friendly anybody can use it"));
        codingTeacherLocations.add(new CodingTeacherHelperClass(R.drawable.verify_phone, "Material design Implementation", "As you all can see our application has all new color themes with NoActionBar Style with fabulous Fonts as well as Illustration Images!  "));
        adapterTeacher = new CodingAdapterTeachers(codingTeacherLocations);
        codingRecyclerViewTeachers.setAdapter(adapterTeacher);
    }

    //Navigation Drawer Function
    private void navigationDrawerOpen() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home_teachers);
        navTeachersClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else
                    drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        animateNavigationDrawer();


    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home_teachers:
                Intent i = new Intent(NavigationTeachers.this, PanelSelection.class);
                startActivity(i);
                break;
            case R.id.nav_explore_teachers:
                Intent i1 = new Intent(NavigationTeachers.this, swipeteacher.class);
                startActivity(i1);
                break;
            case R.id.nav_aboutus_teachers:
                Intent abt = new Intent(NavigationTeachers.this, aboutus.class);
                startActivity(abt);
                break;
            case R.id.nav_logout_teacher:
                Intent logout_t = new Intent(NavigationTeachers.this, LogoutTeacher.class);
                startActivity(logout_t);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
