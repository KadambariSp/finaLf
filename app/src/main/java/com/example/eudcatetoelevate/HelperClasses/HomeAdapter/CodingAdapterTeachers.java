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

public class CodingAdapterTeachers extends RecyclerView.Adapter<CodingAdapterTeachers.CodingViewHolderTeacher> {
    ArrayList<CodingTeacherHelperClass> codingTeacherLocations;

    public CodingAdapterTeachers(ArrayList<CodingTeacherHelperClass> codingTeacherLocations) {
        this.codingTeacherLocations = codingTeacherLocations;
    }

    @NonNull
    @Override
    public CodingViewHolderTeacher onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coding_recyler_view_teachers, parent, false);
        CodingViewHolderTeacher codingViewHolderTeacher = new CodingViewHolderTeacher(view);
        return codingViewHolderTeacher;
    }

    @Override
    public void onBindViewHolder(@NonNull CodingViewHolderTeacher holder, int position) {
        CodingTeacherHelperClass codingTeacherHelperClass = codingTeacherLocations.get(position);

        holder.imageT.setImageResource(codingTeacherHelperClass.getImage());
        holder.titleT.setText(codingTeacherHelperClass.getTitle());
        holder.descT.setText(codingTeacherHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return codingTeacherLocations.size();
    }

    public static class CodingViewHolderTeacher extends RecyclerView.ViewHolder {
        ImageView imageT;
        TextView titleT, descT;

        public CodingViewHolderTeacher(@NonNull View itemView) {
            super(itemView);

            imageT = itemView.findViewById(R.id.codingTeacherImage);
            titleT = itemView.findViewById(R.id.codingTeacherTitle);
            descT = itemView.findViewById(R.id.codingTeacherDescription);
        }
    }
}
