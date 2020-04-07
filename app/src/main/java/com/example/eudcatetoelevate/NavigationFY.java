package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingAdapterFy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingFyHelperClass;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpAdapterFy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpHelperClassFy;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NavigationFY extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView navFyClick;
    LinearLayout contentView;
    RecyclerView codingRecyclerView;
    RecyclerView mostImpFyRecyclerView;
    RecyclerView.Adapter adapterMostImpFy;
    RecyclerView.Adapter adapterFy;
    static final float END_SCALE = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_f_y);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_fy);
        navigationView = (NavigationView) findViewById(R.id.nav_view_fy);

        navFyClick = (ImageView) findViewById(R.id.navclickfy);
        contentView = (LinearLayout) findViewById(R.id.contentfy);
        codingRecyclerView = (RecyclerView) findViewById(R.id.codingRecyclerView);
        mostImpFyRecyclerView = (RecyclerView) findViewById(R.id.mostImpRecyclerViewFy);
        mostImpFyRecyclerView();
        codingRecyclerView();
        navigationDrawerOpen();
    }

    private void mostImpFyRecyclerView() {
        mostImpFyRecyclerView.setHasFixedSize(true);
        mostImpFyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostImpHelperClassFy> mostImpFyLocations = new ArrayList<>();
        mostImpFyLocations.add(new MostImpHelperClassFy(R.drawable.internet1, "Internet is all you need", "As you All know that internet is wide resource to  Learn anything! Go and do it now!"));
        mostImpFyLocations.add(new MostImpHelperClassFy(R.drawable.library1, "C programming Books ", "Our Curriculum has bunch of options to explore knowledge! go and check books from libraryy!!"));
        mostImpFyLocations.add(new MostImpHelperClassFy(R.drawable.coder, "All IDE's , text Editors", "Practical Knowledge is Way better than Therotical one!! if you sincerely do all practicals by your own then nobody will stop you!! "));
        adapterMostImpFy = new MostImpAdapterFy(mostImpFyLocations);
        mostImpFyRecyclerView.setAdapter(adapterMostImpFy);
    }

    private void codingRecyclerView() {
        codingRecyclerView.setHasFixedSize(true);
        codingRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<CodingFyHelperClass> codingFyLocations = new ArrayList<>();
        codingFyLocations.add(new CodingFyHelperClass(R.drawable.basics, "start from Basic!", "As you know to Learn Anything you first have to clear it's base so just Do it!"));
        codingFyLocations.add(new CodingFyHelperClass(R.drawable.clang, "C Language ", "Assembly Language is powerful yet difficult , So c comes into picture!!"));
        codingFyLocations.add(new CodingFyHelperClass(R.drawable.csy, "C ++", "C++ Object oriented Programming it is Advanced Version Of C !"));
        codingFyLocations.add(new CodingFyHelperClass(R.drawable.htmllang1, "HTML", "Web Development is huge place for one who loves to do creative yet techy things !"));
        adapterFy = new CodingAdapterFy(codingFyLocations);
        codingRecyclerView.setAdapter(adapterFy);
    }


    //Navigation Drawer Function
    private void navigationDrawerOpen() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home_fy);
        navFyClick.setOnClickListener(new View.OnClickListener() {
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
        drawerLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.student1));
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
            case R.id.nav_home_fy:
                Intent i = new Intent(NavigationFY.this, PanelSelection.class);
                startActivity(i);
                break;
            case R.id.nav_profile_fy:
                Intent i2 = new Intent(NavigationFY.this, ProfileActivityStudentFY.class);
                startActivity(i2);
                break;
            case R.id.nav_account_fy:
                Intent i3 = new Intent(NavigationFY.this, ViewProfileStudentFY.class);
                startActivity(i3);
            case R.id.nav_explore_fy:
                Intent ie = new Intent(NavigationFY.this, swipefy.class);
                startActivity(ie);
                break;
            case R.id.nav_aboutus_fy:
                Intent intent= new Intent(NavigationFY.this,aboutus.class);
                startActivity(intent);
                break;
            case R.id.nav_logout_fy:
                Intent ii=new Intent(NavigationFY.this,LogoutFy.class);
                startActivity(ii);

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;


    }
}