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

public class Adapterp extends PagerAdapter {
    private List<Modelp> modelp;
    private LayoutInflater layoutInflaterp;
    private Context contextp;

    public Adapterp(List<Modelp> modelp, Context contextp) {
        this.modelp = modelp;
        this.contextp = contextp;
    }

    @Override
    public int getCount() {
        return modelp.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflaterp = LayoutInflater.from(contextp);
        View view = layoutInflaterp.inflate(R.layout.itemp, container, false);

        ImageView imageView4;
        TextView title4, desc4;
        TextView nav;
        imageView4 = view.findViewById(R.id.image4);
        title4 = view.findViewById(R.id.title4);
        desc4 = view.findViewById(R.id.desc4);

        imageView4.setImageResource(modelp.get(position).getImage());
        title4.setText(modelp.get(position).getTitle());
        desc4.setText(modelp.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){
                    Intent intent = new Intent(contextp,PostListActivityStudentAndParent.class);
                    contextp.startActivity(intent);
                }
                else if(position == 1){
                    Intent i=new Intent(contextp,acapdf.class);
                    contextp.startActivity(i);
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

