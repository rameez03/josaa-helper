package com.mc.josaahelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CollegeProfileAdapter extends RecyclerView.Adapter<CollegeProfileAdapter.CollegeViewHolder> {
    private CollegeProfileActivity activity;
    private List<CollegeModel> mCollegeList;


    public CollegeProfileAdapter(CollegeProfileActivity activity , List<CollegeModel> mCollegeList){
        this.activity = activity;
        this.mCollegeList = mCollegeList;
    }

    @NonNull
    @Override
    public CollegeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.collegelistitem , parent , false);
        return new CollegeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeViewHolder holder, int position) {
        holder.instituteIDTV.setText(mCollegeList.get(position).getInstituteID());
        holder.instituteNameTV.setText(mCollegeList.get(position).getInstituteName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CollegeViewHolder extends RecyclerView.ViewHolder{
        TextView instituteIDTV, instituteNameTV;
        public CollegeViewHolder(@NonNull View v){
            super(v);
            instituteIDTV = v.findViewById(R.id.collegeListID);
            instituteNameTV = v.findViewById(R.id.collegeListName);
        }
    }
}
