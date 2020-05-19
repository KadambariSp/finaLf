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

public class Adapterfy extends PagerAdapter {
    private List<Modelfy> modelfy;
    private LayoutInflater layoutInflaterfy;
    private Context contextfy;

    public Adapterfy(List<Modelfy> modelfy, Context contextfy) {
        this.modelfy = modelfy;
        this.contextfy = contextfy;
    }

    @Override
    public int getCount() {
        return modelfy.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        layoutInflaterfy = LayoutInflater.from(contextfy);
        View view = layoutInflaterfy.inflate(R.layout.itemfy, container, false);

        ImageView imageView1;
        TextView title1, desc1;

        imageView1 = view.findViewById(R.id.image1);
        title1 = view.findViewById(R.id.title1);
        desc1 = view.findViewById(R.id.desc1);

        imageView1.setImageResource(modelfy.get(position).getImage());
        title1.setText(modelfy.get(position).getTitle());
        desc1.setText(modelfy.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){
                    Intent intent = new Intent(contextfy,currify.class);
                    contextfy.startActivity(intent);
                }
                else if(position == 1){
                    Intent i=new Intent(contextfy,acapdf.class);
                    contextfy.startActivity(i);
                }
                else if(position==2){
                    Intent i1=new Intent(contextfy,PostListActivityStudentAndParent.class);
                    contextfy.startActivity(i1);
                }

                else if(position==3){
                    Intent iy=new Intent(contextfy,questionpaper.class);
                    contextfy.startActivity(iy);
                }
                else if(position==4){
                    Intent iy=new Intent(contextfy,ShowTextPostActivityStudents.class);
                    contextfy.startActivity(iy);
                }
                else if(position==5){
                    Intent intent= new Intent(contextfy,listcurrify.class);
                    contextfy.startActivity(intent);}
                      else if(position==6){
                        Intent intent4= new Intent(contextfy,coesa.class);
                        contextfy.startActivity(intent4);

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
