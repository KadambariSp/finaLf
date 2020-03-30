package com.example.eudcatetoelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

public class NavigationFY extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView navFyClick;
    LinearLayout contentView;
    static final float END_SCALE = 0.7f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_f_y);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_fy);
        navigationView = (NavigationView) findViewById(R.id.nav_view_fy);
        navFyClick = (ImageView) findViewById(R.id.navclickfy);
        contentView = (LinearLayout) findViewById(R.id.contentfy);


        navigationDrawerOpen();}


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


            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;


}}