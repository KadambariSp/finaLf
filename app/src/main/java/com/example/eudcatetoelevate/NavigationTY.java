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
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingAdapterTy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingFyHelperClass;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.CodingTyHelperClass;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpAdapterFy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpAdapterTy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImpHelperClassFy;
import com.example.eudcatetoelevate.HelperClasses.HomeAdapter.MostImphelperClassTy;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NavigationTY extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayoutTY;
    NavigationView navigationViewTY;
    ImageView navTyClick;
    LinearLayout contentViewTY;
    RecyclerView codingRecyclerViewTY;
    RecyclerView mostImpFyRecyclerViewTY;
    RecyclerView.Adapter adapterMostImpTy;
    RecyclerView.Adapter adapterTy;
    static final float END_SCALE = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_navigation_t_y);
        drawerLayoutTY = (DrawerLayout) findViewById(R.id.drawer_ty);
        navigationViewTY = (NavigationView) findViewById(R.id.nav_view_ty);
        navTyClick = (ImageView) findViewById(R.id.navclickty);
        contentViewTY = (LinearLayout) findViewById(R.id.contentty);
        codingRecyclerViewTY = (RecyclerView) findViewById(R.id.codingRecyclerViewTY);
        mostImpFyRecyclerViewTY = (RecyclerView) findViewById(R.id.mostImpRecyclerViewTy);
        mostImpFyRecyclerView();
        codingRecyclerView();
        navigationDrawerOpen();
    }

    private void mostImpFyRecyclerView() {
        mostImpFyRecyclerViewTY.setHasFixedSize(true);
        mostImpFyRecyclerViewTY.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostImphelperClassTy> mostImpTyLocations = new ArrayList<>();
        mostImpTyLocations.add(new MostImphelperClassTy(R.drawable.project, "Topic Selection", "You first need to research on every topics that you are comfortable with also , the project should not be repeated and copied from Net !!"));
        mostImpTyLocations.add(new MostImphelperClassTy(R.drawable.library1, "Group Members Participation is Must ", "Everyone who is in your team should have maximum participation and Involvement!"));
        mostImpTyLocations.add(new MostImphelperClassTy(R.drawable.coder, "Project FLow", "Never think that you can do Project in one week or month , you have to start it from your Fifth Sem beacuse the last semester is too small to do whole project"));
        adapterMostImpTy = new MostImpAdapterTy(mostImpTyLocations);
        mostImpFyRecyclerViewTY.setAdapter(adapterMostImpTy);

    }

    private void codingRecyclerView() {
        codingRecyclerViewTY.setHasFixedSize(true);
        codingRecyclerViewTY.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<CodingTyHelperClass> codingTyLocations = new ArrayList<>();
        codingTyLocations.add(new CodingTyHelperClass(R.drawable.security, "Computer Security", "As you know to Learn Anything you first have to clear it's base so just Do it!"));
        codingTyLocations.add(new CodingTyHelperClass(R.drawable.project, "Advanced Java", "Assembly Language is powerful yet difficult , So c comes into picture!!"));
        codingTyLocations.add(new CodingTyHelperClass(R.drawable.csy, "vbdc", "C++ Object oriented Programming it is Advanced Version Of C !"));
        codingTyLocations.add(new CodingTyHelperClass(R.drawable.htmllang1, "HTML", "Web Development is huge place for one who loves to do creative yet techy things !"));
        adapterTy = new CodingAdapterTy(codingTyLocations);
        codingRecyclerViewTY.setAdapter(adapterTy);

    }

    private void navigationDrawerOpen() {
        navigationViewTY.bringToFront();
        navigationViewTY.setNavigationItemSelectedListener(this);
        navigationViewTY.setCheckedItem(R.id.nav_home_ty);
        navTyClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayoutTY.isDrawerVisible(GravityCompat.START))
                    drawerLayoutTY.closeDrawer(GravityCompat.START);
                else
                    drawerLayoutTY.openDrawer(GravityCompat.START);

            }
        });
        animateNavigationDrawer();


    }

    private void animateNavigationDrawer() {
        drawerLayoutTY.setBackgroundDrawable(getResources().getDrawable(R.drawable.student1));
        drawerLayoutTY.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentViewTY.setScaleX(offsetScale);
                contentViewTY.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentViewTY.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentViewTY.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayoutTY.isDrawerVisible(GravityCompat.START)) {
            drawerLayoutTY.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home_ty:
                Intent i = new Intent(NavigationTY.this, PanelSelection.class);
                startActivity(i);
                break;
            // case R.id.nav_profile_ty:
            //   Intent i2 = new Intent(NavigationTY.this, ProfileActivityStudentFY.class);
            // startActivity(i2);
            //break;
           /* case R.id.nav_account_ty:
                Intent i3 = new Intent(NavigationTY.this, ViewProfileStudentFY.class);
                startActivity(i3);*/
            case R.id.nav_explore_fy:
                Intent ie = new Intent(NavigationTY.this, swipety.class);
                startActivity(ie);
                break;
           /* case R.id.nav_logout_ty:
                Intent ii=new Intent(NavigationTY.this,LogoutFy.class);
                startActivity(ii);*/

        }
        drawerLayoutTY.closeDrawer(GravityCompat.START);
        return true;
    }
}
