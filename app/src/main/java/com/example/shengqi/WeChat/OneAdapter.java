package com.example.shengqi.WeChat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shengqi.R;

import java.util.List;


public class OneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<oneModel> list;
    private OnItemClick click;
    private int type;

    public OneAdapter(List<oneModel> list, OnItemClick click) {
        this.list = list;
        this.click = click;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 1){
            return new AdapterViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false));

        }else{
            return new AdapterViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
        }
    }

    @Override
    public int getItemViewType(int position) {

        if(position < 5){
            return 1;

        }else {
            return 2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof AdapterViewHolder1){
            AdapterViewHolder1 holder1 = (AdapterViewHolder1) holder;
            oneModel model = list.get(position);
            holder1.m1.setImageResource(model.getImageId());
            holder1.t1.setText(model.getName());
            holder1.t2.setText(model.getText());
            holder1.t2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click.onclick(model);
                }
            });
        }else{
            AdapterViewHolder2 holder2 = (AdapterViewHolder2) holder;
            oneModel model = list.get(position);
            holder2.m1.setImageResource(model.getImageId());
            holder2.t1.setText(model.getName());
            holder2.t1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click.onclick(model);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class AdapterViewHolder1 extends RecyclerView.ViewHolder{

        private TextView t1;
        private TextView t2;
        private ImageView m1;

        public AdapterViewHolder1(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.message_name);
            t2 = itemView.findViewById(R.id.message_text);
            m1 = itemView.findViewById(R.id.message_img);

        }
    }


    static class AdapterViewHolder2 extends RecyclerView.ViewHolder{

        private TextView t1;
        private ImageView m1;

        public AdapterViewHolder2(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.re_item);
            m1 = itemView.findViewById(R.id.re_image);
        }
    }



    public interface OnItemClick{
        void onclick(oneModel model);
    }
}
