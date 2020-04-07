package com.example.eudcatetoelevate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapterty extends PagerAdapter {
    private List<Modelty> modelty;
    private LayoutInflater layoutInflaterty;
    private Context contextty;

    public Adapterty(List<Modelty> modelty, Context contextty) {
        this.modelty = modelty;
        this.contextty = contextty;
    }

    @Override
    public int getCount() {
        return modelty.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflaterty = LayoutInflater.from(contextty);
        View view = layoutInflaterty.inflate(R.layout.itemty, container, false);

        ImageView imageView3;
        TextView title3, desc3;

        imageView3 = view.findViewById(R.id.image3);
        title3 = view.findViewById(R.id.title3);
        desc3 = view.findViewById(R.id.desc3);

        imageView3.setImageResource(modelty.get(position).getImage());
        title3.setText(modelty.get(position).getTitle());
        desc3.setText(modelty.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){
                    Intent intent = new Intent(contextty,pdf.class);
                    contextty.startActivity(intent);
                }
                else if(position == 1){
                    Intent i=new Intent(contextty,acapdf.class);
                    contextty.startActivity(i);
                }
                else if(position==2){
                    Intent i1=new Intent(contextty,PostListActivityStudentAndParent.class);
                    contextty.startActivity(i1);
                }

                else if(position==3){
                    Intent iy=new Intent(contextty,questionpaper.class);
                    contextty.startActivity(iy);
                }
                else if(position==4){
                    Intent iy=new Intent(contextty,ShowTextPostActivityStudents.class);
                    contextty.startActivity(iy);
                }
                else if(position==5){
                    Intent iy=new Intent(contextty,viewcurrity.class);
                    contextty.startActivity(iy);
                }
                else if(position==6){
                    Intent iy=new Intent(contextty,coesa.class);
                    contextty.startActivity(iy);
                }


            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
