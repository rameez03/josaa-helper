package com.mc.josaahelper;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.ItemViewHolder> {
    ArrayList<CollegeDetails>details;

    public CollegeAdapter(ArrayList<CollegeDetails>details)
    {
        this.details = details;
    }

    @NonNull
    @Override
    public CollegeAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.predicted_college,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeAdapter.ItemViewHolder holder, int position) {
        holder.collegename.setText(details.get(holder.getAdapterPosition()).getCollegename());
        holder.closerank.setText(Integer.toString(details.get(holder.getAdapterPosition()).getCloserank()));
        holder.openrank.setText(Integer.toString(details.get(holder.getAdapterPosition()).getOpenrank()));
        holder.branch.setText(details.get(holder.getAdapterPosition()).getBranch());
    }

    public void update(ArrayList<CollegeDetails> collegeDetails)
    {
        details.clear();
        Collections.copy(details,collegeDetails);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        Log.i("Item Count",Integer.toString(details.size()));
        return details.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView collegename,branch,openrank,closerank;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            collegename = itemView.findViewById(R.id.collegeName);
            branch = itemView.findViewById(R.id.branch);
            openrank = itemView.findViewById(R.id.openRank1);
            closerank = itemView.findViewById(R.id.closeRank1);
        }
    }
}
