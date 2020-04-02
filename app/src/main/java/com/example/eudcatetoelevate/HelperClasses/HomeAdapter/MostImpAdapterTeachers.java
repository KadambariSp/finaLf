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

public class MostImpAdapterTeachers extends RecyclerView.Adapter<MostImpAdapterTeachers.MostImpViewHolderTeachers> {
    ArrayList<MostImpHelperClassTeacher> mostImpTeacherLocations;

    public MostImpAdapterTeachers(ArrayList<MostImpHelperClassTeacher> mostImpTeacherLocations) {

        this.mostImpTeacherLocations = mostImpTeacherLocations;
    }

    @NonNull
    @Override
    public MostImpViewHolderTeachers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_important_card_teachers, parent, false);
        MostImpViewHolderTeachers mostImpViewHolderTeachers = new MostImpViewHolderTeachers(view);
        return mostImpViewHolderTeachers;
    }

    @Override
    public void onBindViewHolder(@NonNull MostImpViewHolderTeachers holder, int position) {
        MostImpHelperClassTeacher mostImpHelperClassTeacher =mostImpTeacherLocations.get(position);

        holder.impimageT.setImageResource(mostImpHelperClassTeacher.getImage());
        holder.imptitleT.setText(mostImpHelperClassTeacher.getTitle());
        holder.impdescT.setText(mostImpHelperClassTeacher.getDescription());
    }

    @Override
    public int getItemCount() {
        return mostImpTeacherLocations.size();
    }

    public static class MostImpViewHolderTeachers extends RecyclerView.ViewHolder {
        ImageView impimageT;
        TextView imptitleT, impdescT;

        public MostImpViewHolderTeachers(@NonNull View itemView) {
            super(itemView);

            impimageT = itemView.findViewById(R.id.mImp_ImageT);
            imptitleT = itemView.findViewById(R.id.mImp_TitleT);
            impdescT = itemView.findViewById(R.id.mImp_DescT);
        }
    }
}
