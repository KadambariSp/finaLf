package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class swipesy extends AppCompatActivity {
    ViewPager viewPager2;
    Adaptersy  adaptersy;
    List<Modelsy> modelsy;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluatorsy = new ArgbEvaluator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipesy);
        modelsy = new ArrayList<>();
        modelsy.add(new Modelsy(R.drawable.curiifinal, "Curriculum", "Curriculum for Second Year Both shifts"));
        modelsy.add(new Modelsy(R.drawable.academiccal, "Academic Calendar", "Academic Calender for All academical activities , exam schedules , PTM and many more!"));
        modelsy.add(new Modelsy(R.drawable.finalno, "Notice", "Notices in the Form of Images"));
        modelsy.add(new Modelsy(R.drawable.dlist, "Question Paper", "Set of Question papers to solve ! Just for your practice"));
        modelsy.add(new Modelsy(R.drawable.marksss, "Text Notice", "Small form of Notices , (Text Format)"));
        modelsy.add(new Modelsy(R.drawable.softwareengineer, "Pdf Notice", "Notices in the form of PDFs like updated timetable for exam , any Cirular etc"));
        modelsy.add(new Modelsy(R.drawable.coesa, "Other Activities", "Includes COESA forms"));
        adaptersy = new Adaptersy(modelsy, this);

        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(adaptersy);
        viewPager2.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),





        };

        colors = colors_temp;

        viewPager2.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adaptersy.getCount() -1) && position < (colors.length - 1)) {
                    viewPager2.setBackgroundColor(

                            (Integer) argbEvaluatorsy.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager2.setBackgroundColor(colors[colors.length - 1]);
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
