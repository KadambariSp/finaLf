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

public class CodingAdapterTy extends RecyclerView.Adapter<CodingAdapterTy.CodingViewHolderTy>{
    ArrayList<CodingTyHelperClass> codingTyLocations;

    public CodingAdapterTy(ArrayList<CodingTyHelperClass> codingTyLocations) {
        this.codingTyLocations = codingTyLocations;
    }

    @NonNull
    @Override
    public CodingViewHolderTy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coding_recyler_view_ty, parent, false);
       CodingViewHolderTy codingViewHolderTy = new CodingViewHolderTy(view);
        return codingViewHolderTy;
    }

    @Override
    public void onBindViewHolder(@NonNull CodingViewHolderTy holder, int position) {
        CodingTyHelperClass codingTyHelperClass = codingTyLocations.get(position);

        holder.imageTy.setImageResource(codingTyHelperClass.getImage());
        holder.titleTy.setText(codingTyHelperClass.getTitle());
        holder.descTy.setText(codingTyHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return codingTyLocations.size();
    }


    public static class CodingViewHolderTy extends RecyclerView.ViewHolder {
        ImageView imageTy;
        TextView titleTy, descTy;

        public CodingViewHolderTy(@NonNull View itemView) {
            super(itemView);

            imageTy = itemView.findViewById(R.id.codingTyImage);
            titleTy = itemView.findViewById(R.id.codingTyTitle);
            descTy = itemView.findViewById(R.id.codingTyDescription);
        }
    }

}
