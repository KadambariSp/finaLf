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

public class MostImpAdapterFy extends RecyclerView.Adapter<MostImpAdapterFy.MostImpViewHolderFy> {
    ArrayList<MostImpHelperClassFy> mostImpFyLocations;
    public MostImpAdapterFy(ArrayList<MostImpHelperClassFy>mostImpFyLocations) {
        this.mostImpFyLocations = mostImpFyLocations;
    }

    @NonNull
    @Override
    public MostImpViewHolderFy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_important_card_fy, parent, false);
        MostImpViewHolderFy mostImpViewHolderFy = new MostImpViewHolderFy(view);
        return mostImpViewHolderFy;
    }

    @Override
    public void onBindViewHolder(@NonNull MostImpViewHolderFy holder, int position) {
       MostImpHelperClassFy mostImpHelperClassFy =mostImpFyLocations.get(position);

        holder.impimagefy.setImageResource(mostImpHelperClassFy.getImage());
        holder.imptitlefy.setText(mostImpHelperClassFy.getTitle());
        holder.impdescfy.setText(mostImpHelperClassFy.getDescription());

    }

    @Override
    public int getItemCount() {
        return mostImpFyLocations.size();
    }

    public static class MostImpViewHolderFy extends RecyclerView.ViewHolder {
        ImageView impimagefy;
        TextView imptitlefy, impdescfy;

        public MostImpViewHolderFy(@NonNull View itemView) {
            super(itemView);

            impimagefy = itemView.findViewById(R.id.mImp_ImageFy);
            imptitlefy = itemView.findViewById(R.id.mImp_TitleFy);
            impdescfy = itemView.findViewById(R.id.mImp_DescFy);
        }
    }

}

