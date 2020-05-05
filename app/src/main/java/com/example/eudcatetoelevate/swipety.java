package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class swipety extends AppCompatActivity {
    ViewPager viewPager3;
    Adapterty  adapterty;
    List<Modelty> modelty;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluatorty = new ArgbEvaluator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipety);
        modelty = new ArrayList<>();
        modelty.add(new Modelty(R.drawable.curiifinal, "Curriculum", "Curriculum for Third Year Both shifts"));
        modelty.add(new Modelty(R.drawable.academiccal, "Academic Calendar", "Academic Calender for All academical activities , exam schedules , PTM and many more!"));
        modelty.add(new Modelty(R.drawable.finalno, "Notice", "Notices in the Form of Images"));
        modelty.add(new Modelty(R.drawable.dlist, "Question Paper", "Set of Question papers to solve ! Just for your practice"));
        modelty.add(new Modelty(R.drawable.marksss, "Text Notice", "Small form of Notices , (Text Format)"));
        modelty.add(new Modelty(R.drawable.softwareengineer, "Pdf Notice", "Notices in the form of PDFs like updated timetable for exam , any Cirular etc"));
        modelty.add(new Modelty(R.drawable.coesa, "Other Activities", "Includes COESA forms"));
        adapterty = new Adapterty(modelty, this);

        viewPager3 = findViewById(R.id.viewPager3);
        viewPager3.setAdapter(adapterty);
        viewPager3.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),





        };

        colors = colors_temp;

        viewPager3.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapterty.getCount() -1) && position < (colors.length - 1)) {
                    viewPager3.setBackgroundColor(

                            (Integer) argbEvaluatorty.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager3.setBackgroundColor(colors[colors.length - 1]);
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
}
