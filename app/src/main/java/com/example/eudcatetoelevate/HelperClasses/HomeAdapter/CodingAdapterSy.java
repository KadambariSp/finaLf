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

public class CodingAdapterSy extends RecyclerView.Adapter<CodingAdapterSy.CodingViewHolderSy> {
    ArrayList<CodingHelperClassSy> codingSyLocations;

    public CodingAdapterSy(ArrayList<CodingHelperClassSy> codingSyLocations) {
        this.codingSyLocations = codingSyLocations;
    }

    @NonNull
    @Override
    public CodingViewHolderSy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coding_recyler_view_sy, parent, false);
        CodingViewHolderSy codingViewHolderSy = new CodingViewHolderSy(view);
        return codingViewHolderSy;
    }

    @Override
    public void onBindViewHolder(@NonNull CodingViewHolderSy holder, int position) {
        CodingHelperClassSy codingSyHelperClass = codingSyLocations.get(position);

        holder.imageSy.setImageResource(codingSyHelperClass.getImage());
        holder.titleSy.setText(codingSyHelperClass.getTitle());
        holder.descSy.setText(codingSyHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return codingSyLocations.size();
    }

    public static class CodingViewHolderSy extends RecyclerView.ViewHolder  {
        ImageView imageSy;
        TextView titleSy, descSy;

        public CodingViewHolderSy(@NonNull View itemView) {
            super(itemView);

            imageSy = itemView.findViewById(R.id.codingSyImage);
            titleSy = itemView.findViewById(R.id.codingSyTitle);
            descSy = itemView.findViewById(R.id.codingSyDescription);
        }
    }
}
