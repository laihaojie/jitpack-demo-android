package com.example.shengqi.Lianxi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shengqi.R;
import com.example.shengqi.recyclerview.itemObject;

import java.util.List;

public class LianxiAdapter extends RecyclerView.Adapter<LianxiAdapter.LinearViewHolder> {
    private List<DataObject> list;

    public LianxiAdapter(List<DataObject> list){
        this.list = list;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView t1;
        private TextView t2;
        private ImageView m1;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.l_name);
            t2 = itemView.findViewById(R.id.l_text);
            m1 = itemView.findViewById(R.id.l_image);
        }
    }

    @Override
    public LianxiAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lianxi_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
        DataObject object = list.get(position);
        holder.t1.setText(object.getName());
        holder.t2.setText(object.getText());
        holder.m1.setImageResource(object.getImageid());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
