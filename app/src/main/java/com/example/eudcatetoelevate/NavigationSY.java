package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingAdapterFy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingAdapterSy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingFyHelperClass;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingHelperClassSy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpAdapterFy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpAdapterSy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpHelperClassFy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpHelperClassSy;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NavigationSY extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView navSyClick;
    LinearLayout contentViewSy;
    RecyclerView codingRecyclerViewSy;
    RecyclerView mostImpFyRecyclerViewSy;
    RecyclerView.Adapter adapterMostImpSy;
    RecyclerView.Adapter adapterSy;
    static final float END_SCALE = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_s_y);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_sy);
        navigationView = (NavigationView) findViewById(R.id.nav_view_sy);

        navSyClick = (ImageView) findViewById(R.id.navclicksy);
        contentViewSy = (LinearLayout) findViewById(R.id.contentsy);
        codingRecyclerViewSy = (RecyclerView) findViewById(R.id.codingRecyclerViewSY);
        mostImpFyRecyclerViewSy = (RecyclerView) findViewById(R.id.mostImpRecyclerViewSy);

        mostImpFyRecyclerView();
        codingRecyclerView();
        navigationDrawerOpen();
    }

    private void mostImpFyRecyclerView() {
        mostImpFyRecyclerViewSy.setHasFixedSize(true);
        mostImpFyRecyclerViewSy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostImpHelperClassSy> mostImpSyLocations = new ArrayList<>();
        mostImpSyLocations.add(new MostImpHelperClassSy(R.drawable.internet1, "Internet is all you need", "As you All know that internet is wide resource to  Learn anything! Go and do it now!"));
        mostImpSyLocations.add(new MostImpHelperClassSy(R.drawable.library1, "C programming Books ", "Our Curriculum has bunch of options to explore knowledge! go and check books from libraryy!!"));
        mostImpSyLocations.add(new MostImpHelperClassSy(R.drawable.coder, "All IDE's , text Editors", "Practical Knowledge is Way better than Therotical one!! if you sincerely do all practicals by your own then nobody will stop you!! "));
        adapterMostImpSy = new MostImpAdapterSy(mostImpSyLocations);
        mostImpFyRecyclerViewSy.setAdapter(adapterMostImpSy);
    }

    private void codingRecyclerView() {
        codingRecyclerViewSy.setHasFixedSize(true);
        codingRecyclerViewSy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<CodingHelperClassSy> codingSyLocations = new ArrayList<>();
        codingSyLocations.add(new CodingHelperClassSy(R.drawable.basics, "start from Basic!", "As you know to Learn Anything you first have to clear it's base so just Do it!"));
        codingSyLocations.add(new CodingHelperClassSy(R.drawable.clang, "C Language ", "Assembly Language is powerful yet difficult , So c comes into picture!!"));
        codingSyLocations.add(new CodingHelperClassSy(R.drawable.csy, "C ++", "C++ Object oriented Programming it is Advanced Version Of C !"));
        codingSyLocations.add(new CodingHelperClassSy(R.drawable.htmllang1, "HTML", "Web Development is huge place for one who loves to do creative yet techy things !"));
        adapterSy = new CodingAdapterSy(codingSyLocations);
        codingRecyclerViewSy.setAdapter(adapterSy);
    }


    //Navigation Drawer Function
    private void navigationDrawerOpen() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home_sy);
        navSyClick.setOnClickListener(new View.OnClickListener() {
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
        drawerLayout.setScrimColor(getResources().getColor(R.color.color2));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentViewSy.setScaleX(offsetScale);
                contentViewSy.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentViewSy.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentViewSy.setTranslationX(xTranslation);
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
            case R.id.nav_home_sy:
                break;
            case R.id.nav_profile_sy:
                Intent i = new Intent(NavigationSY.this, ProfileActivityStudentSy.class);
                startActivity(i);
                break;
            case R.id.nav_account_sy:
                Intent i1 = new Intent(NavigationSY.this, ViewProfileStudentSy.class);
                startActivity(i1);
                break;
            case R.id.nav_explore_sy:
                Intent i4 = new Intent(NavigationSY.this,swipesy.class);
                startActivity(i4);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
