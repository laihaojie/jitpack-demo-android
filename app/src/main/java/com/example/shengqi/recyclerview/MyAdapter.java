package com.example.shengqi.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shengqi.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.AdapterViewholer> {
    private List<itemObject> list;

    public MyAdapter(List<itemObject> list) {
        this.list = list;
    }

    class AdapterViewholer extends RecyclerView.ViewHolder {
        private TextView t1;
        private ImageView m1;
        public AdapterViewholer(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.re_item);
            m1 = itemView.findViewById(R.id.re_image);
        }
    }


    @NonNull
    @Override
    public AdapterViewholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterViewholer(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewholer holder, int position) {
        itemObject itemObject = list.get(position);

        holder.t1.setText(itemObject.getName());
        holder.m1.setImageResource(itemObject.getImageId());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
