package com.example.shengqi.Lianxi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.shengqi.R;

import java.util.ArrayList;
import java.util.List;

public class LianxiActivity extends AppCompatActivity {
    private RecyclerView r1;
    private List<DataObject> list =  new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lianxi);
        Initdata();
        r1 = findViewById(R.id.re_lianxi);
        r1.setLayoutManager(new LinearLayoutManager(this));
        r1.addItemDecoration(new MyDecoration());
        r1.setAdapter(new LianxiAdapter(list));

    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.LianxiHeight));
        }
    }
    public void Initdata () {
        DataObject object1 = new DataObject("卢浩杰","我是卢浩杰,你好",R.drawable.mao);
        list.add(object1);

        DataObject object2 = new DataObject("陈舒慧","我是陈舒慧,你好",R.drawable.mao);
        list.add(object2);

        DataObject object3 = new DataObject("徐相磊","我是徐相磊,你好",R.drawable.mao);
        list.add(object3);
    }
}