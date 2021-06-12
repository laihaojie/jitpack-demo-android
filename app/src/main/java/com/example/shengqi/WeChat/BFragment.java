package com.example.shengqi.WeChat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shengqi.R;
import com.ruffian.library.widget.RTextView;

public class BFragment extends Fragment {
    private TextView t1;
    private RTextView rView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bfragment,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rView = (RTextView) view.findViewById(R.id.tv_partner);
//        rView.setOnLongClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        //获取Helper
//        RBaseHelper helper = rView.getHelper();
//        helper.setBackgroundColorNormal(getResources().getColor(R.color.c_red))
//                .setBorderColorNormal(getResources().getColor(R.color.c_red))
//                .setBorderWidthNormal(12)
//                .setCornerRadius(25);

    }


}
