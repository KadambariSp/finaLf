package com.example.eudcatetoelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.animation.ArgbEvaluator;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class swipefy extends AppCompatActivity {
    ViewPager viewPager1;
    Adapterfy  adapterfy;
    List<Modelfy> modelfy;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluatorfy = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipefy);
        modelfy = new ArrayList<>();
        modelfy.add(new Modelfy(R.drawable.curiifinal, "Curriculum", ""));
        modelfy.add(new Modelfy(R.drawable.academiccal, "Academic Calendar", ""));
        modelfy.add(new Modelfy(R.drawable.finalno, "Notice", ""));
        modelfy.add(new Modelfy(R.drawable.dlist, "Question Papers", ""));
        modelfy.add(new Modelfy(R.drawable.marksss, "Text Notice", ""));
        modelfy.add(new Modelfy(R.drawable.coesa, "Pdf Notice", ""));
        modelfy.add(new Modelfy(R.drawable.coesa, "Other Activities", ""));


        adapterfy = new Adapterfy(modelfy, this);

        viewPager1 = findViewById(R.id.viewPager1);
        viewPager1.setAdapter(adapterfy);
        viewPager1.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),





        };

        colors = colors_temp;

        viewPager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapterfy.getCount() -1) && position < (colors.length - 1)) {
                    viewPager1.setBackgroundColor(

                            (Integer) argbEvaluatorfy.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager1.setBackgroundColor(colors[colors.length - 1]);
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
