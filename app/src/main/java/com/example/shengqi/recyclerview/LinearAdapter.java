package com.example.shengqi.recyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shengqi.R;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private List<itemObject> list;
    private OnItemClick click;

    public LinearAdapter (List<itemObject> list,OnItemClick click){
        this.list = list;
        this.click = click;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView t1;
        private ImageView m1;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.re_item);
            m1 = itemView.findViewById(R.id.re_image);
        }
    }

    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
        itemObject itemObject = list.get(position);
        holder.t1.setText(itemObject.getName());
        holder.m1.setImageResource(itemObject.getImageId());
        holder.m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.Onclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClick{
        void Onclick(int pos);
    }

}
