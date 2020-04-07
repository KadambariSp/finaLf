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

public class Adaptersy extends PagerAdapter {
    private List<Modelsy> modelsy;
    private LayoutInflater layoutInflatersy;
    private Context contextsy;
    public Adaptersy(List<Modelsy> modelsy, Context contextsy) {
        this.modelsy = modelsy;
        this.contextsy = contextsy;
    }
    @Override
    public int getCount() {
        return modelsy.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflatersy = LayoutInflater.from(contextsy);
        View view = layoutInflatersy.inflate(R.layout.itemsy, container, false);

        ImageView imageView2;
        TextView title2, desc2;

        imageView2 = view.findViewById(R.id.image2);
        title2 = view.findViewById(R.id.title2);
        desc2 = view.findViewById(R.id.desc2);

        imageView2.setImageResource(modelsy.get(position).getImage());
        title2.setText(modelsy.get(position).getTitle());
        desc2.setText(modelsy.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){
                    Intent intent = new Intent(contextsy,currisy.class);
                    contextsy.startActivity(intent);
                }
                else if(position == 1){
                    Intent i=new Intent(contextsy,acapdf.class);
                    contextsy.startActivity(i);
                }
                else if(position==2){
                    Intent i1=new Intent(contextsy,PostListActivityStudentAndParent.class);
                    contextsy.startActivity(i1);
                }

                else if(position==3){
                    Intent iy=new Intent(contextsy,questionpaper.class);
                    contextsy.startActivity(iy);
                }
                else if(position==4){
                    Intent iy=new Intent(contextsy,ShowTextPostActivityStudents.class);
                    contextsy.startActivity(iy);
                }
                else if(position==5){
                    Intent iy=new Intent(contextsy,viewpdfstudent.class);
                    contextsy.startActivity(iy);
                }
                else if(position==6){
                    Intent iy=new Intent(contextsy,coesa.class);
                    contextsy.startActivity(iy);
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