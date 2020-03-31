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

public class CodingAdapterFy extends RecyclerView.Adapter<CodingAdapterFy.CodingViewHolderFy> {
    ArrayList<CodingFyHelperClass> codingFyLocations;

    public CodingAdapterFy(ArrayList<CodingFyHelperClass> codingFyLocations) {
        this.codingFyLocations = codingFyLocations;
    }

    @NonNull
    @Override
    public CodingViewHolderFy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coding_recycler_view_fy, parent, false);
        CodingViewHolderFy codingViewHolderFy = new CodingViewHolderFy(view);
        return codingViewHolderFy;
    }

    @Override
    public void onBindViewHolder(@NonNull CodingViewHolderFy holder, int position) {
        CodingFyHelperClass codingFyHelperClass = codingFyLocations.get(position);

        holder.imagefy.setImageResource(codingFyHelperClass.getImage());
        holder.titlefy.setText(codingFyHelperClass.getTitle());
        holder.descfy.setText(codingFyHelperClass.getDescription());


    }

    @Override
    public int getItemCount() {

        return codingFyLocations.size();
    }


    public static class CodingViewHolderFy extends RecyclerView.ViewHolder {
        ImageView imagefy;
        TextView titlefy, descfy;

        public CodingViewHolderFy(@NonNull View itemView) {
            super(itemView);

            imagefy = itemView.findViewById(R.id.codingFyImage);
            titlefy = itemView.findViewById(R.id.codingFyTitle);
            descfy = itemView.findViewById(R.id.codingFyDescription);
        }
    }


}
