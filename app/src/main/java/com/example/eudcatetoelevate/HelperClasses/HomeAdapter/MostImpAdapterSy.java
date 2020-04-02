package com.example.eudcatetoelevate.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eudcatetoelevate.R;

import java.util.ArrayList;

public class MostImpAdapterSy extends RecyclerView.Adapter<MostImpAdapterSy.MostImpViewHolderSy> {
    ArrayList<MostImpHelperClassSy> mostImpSyLocations;

    public MostImpAdapterSy(ArrayList<MostImpHelperClassSy> mostImpSyLocations) {
        this.mostImpSyLocations = mostImpSyLocations;
    }

    @NonNull
    @Override
    public MostImpViewHolderSy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_important_recyler_view_sy, parent, false);
       MostImpViewHolderSy mostImpViewHolderSy = new MostImpViewHolderSy(view);
        return mostImpViewHolderSy;
    }

    @Override
    public void onBindViewHolder(@NonNull MostImpViewHolderSy holder, int position) {
        MostImpHelperClassSy mostImpHelperClassSy =mostImpSyLocations.get(position);

        holder.impimageSy.setImageResource(mostImpHelperClassSy.getImage());
        holder.imptitleSy.setText(mostImpHelperClassSy.getTitle());
        holder.impdescSy.setText(mostImpHelperClassSy.getDescription());

    }

    @Override
    public int getItemCount() {
       return mostImpSyLocations.size();
    }

    public static class MostImpViewHolderSy extends RecyclerView.ViewHolder {
        ImageView impimageSy;
        TextView imptitleSy, impdescSy;

        public MostImpViewHolderSy(@NonNull View itemView) {
            super(itemView);

            impimageSy = itemView.findViewById(R.id.mImp_ImageSy);
            imptitleSy = itemView.findViewById(R.id.mImp_TitleSy);
            impdescSy = itemView.findViewById(R.id.mImp_DescSy);
        }
    }
}
