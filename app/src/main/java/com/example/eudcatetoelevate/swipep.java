package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class swipep extends AppCompatActivity {

    ViewPager viewPager4;
    Adapterp  adapterp;
    List<Modelp> modelp;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluatorp = new ArgbEvaluator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipep);
        modelp = new ArrayList<>();
        modelp.add(new Modelp(R.drawable.finalno, "Notice", "All Notices regarding Your Children's Education Most Important PARENT TEACHER MEETINGS and TO CHECK WHETHER YOUR CHILD ATTEND EACH AND EVERY LECTURE OR NOT?"));
        modelp.add(new Modelp(R.drawable.academiccal, "Academic Calender", "Academical Activities!"));
        modelp.add(new Modelp(R.drawable.dlist,"Text Notices","Small form of Notices , (Text Format)"));
         adapterp = new Adapterp(modelp, this);

        viewPager4 = findViewById(R.id.viewPager4);
        viewPager4.setAdapter(adapterp);
        viewPager4.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),






        };

        colors = colors_temp;

        viewPager4.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapterp.getCount() -1) && position < (colors.length - 1)) {
                    viewPager4.setBackgroundColor(

                            (Integer) argbEvaluatorp.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager4.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setSupportActionBar(Toolbar toolbar) {

    }
}
