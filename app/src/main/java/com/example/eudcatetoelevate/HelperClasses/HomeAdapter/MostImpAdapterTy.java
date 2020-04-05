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

public class MostImpAdapterTy extends RecyclerView.Adapter<MostImpAdapterTy.MostImpViewHolderTy> {
    ArrayList<MostImphelperClassTy> mostImpTyLocations;

    public MostImpAdapterTy(ArrayList<MostImphelperClassTy> mostImpTyLocations) {
        this.mostImpTyLocations = mostImpTyLocations;
    }

    @NonNull
    @Override
    public MostImpViewHolderTy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_important_card_ty, parent, false);
       MostImpViewHolderTy mostImpViewHolderTy = new MostImpViewHolderTy(view);
        return mostImpViewHolderTy;
    }

    @Override
    public void onBindViewHolder(@NonNull MostImpViewHolderTy holder, int position) {
        MostImphelperClassTy mostImpHelperClassTy =mostImpTyLocations.get(position);

        holder.impimageTy.setImageResource(mostImpHelperClassTy.getImage());
        holder.imptitleTy.setText(mostImpHelperClassTy.getTitle());
        holder.impdescTy.setText(mostImpHelperClassTy.getDescription());

    }

    @Override
    public int getItemCount() {
        return mostImpTyLocations.size();
    }

    public static class MostImpViewHolderTy extends RecyclerView.ViewHolder {
        ImageView impimageTy;
        TextView imptitleTy, impdescTy;

        public MostImpViewHolderTy(@NonNull View itemView) {
            super(itemView);

            impimageTy = itemView.findViewById(R.id.mImp_ImageTy);
            imptitleTy = itemView.findViewById(R.id.mImp_TitleTy);
            impdescTy = itemView.findViewById(R.id.mImp_DescTy);
        }
    }
}
