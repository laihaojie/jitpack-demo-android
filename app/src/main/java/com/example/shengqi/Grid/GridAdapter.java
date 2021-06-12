package com.example.shengqi.Grid;

import android.graphics.Color;
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

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private List<GridData> list;

    public GridAdapter(List<GridData> list){
        this.list = list;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        private TextView t1;
        private ImageView m1;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.g_text);
            m1 = itemView.findViewById(R.id.g_image);
        }

        public void setData(GridData object,int position) {
            t1.setText("第" + (position + 1) + "张图片");
            t1.setBackgroundColor(Color.parseColor(object.getColor()));
//            t1.setBackgroundColor(Color.parseColor("#ccc"));
//            t1.setBackgroundColor(Color.rgb(213, 0, 0));
            m1.setImageResource(object.getImageId());

//            ViewGroup.LayoutParams params = m1.getLayoutParams();
//            params.height=900;
//            params.width =900;
//            m1.setLayoutParams(params);
        }
    }

    @Override
    public GridAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.setData(list.get(position),position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
