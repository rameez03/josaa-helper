package com.mc.josaahelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CollegeProfileAdapter extends RecyclerView.Adapter<CollegeProfileAdapter.MyViewHolder> {

    private static CollegeProfileActivity activity;
    private OnRecyclerViewClickListener listener;
    private List<CollegeModel> modelList;

    public void setfilter(List<CollegeModel> filter){
        this.modelList=filter;
        notifyDataSetChanged();
    }
    public interface OnRecyclerViewClickListener{
        void OnItemClick(int position);
    }
    public void OnRecyclerViewClickListener (OnRecyclerViewClickListener listener){
        this.listener = listener;
    }

    String s="";
    //    public MyAdapter(Context context) {
//        this.context = context;
//    }
    public CollegeProfileAdapter(CollegeProfileActivity activity,List<CollegeModel> modelList){
        this.activity=activity;
        this.modelList=modelList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(activity).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(modelList.get(position).getInstituteCodeName());
        s=modelList.get(position).getAddress();
        Log.d("data"," "+s);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public MyViewHolder(@NonNull View itemView, OnRecyclerViewClickListener listener){
            super(itemView);
            title=itemView.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener !=null && getAdapterPosition()!=RecyclerView.NO_POSITION){
                        listener.OnItemClick(getAdapterPosition());
                    }
                }
            });
        }
        public TextView getCardView() {
            return title;
        }
    }

}
