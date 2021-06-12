package com.example.shengqi.Grid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.shengqi.R;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    private RecyclerView r1;
    private List<GridData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initData();
        r1 = findViewById(R.id.re_grid);
        r1.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        r1.addItemDecoration(new MyDecoration());
        r1.setAdapter(new GridAdapter(list));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.GridHeight));
        }
    }

    public void initData(){
        GridData data1 = new GridData(R.drawable.mao,"#228B22");
        list.add(data1);
        GridData data2 = new GridData(R.drawable.mao,"#8B7500");
        list.add(data2);
        GridData data3 = new GridData(R.drawable.mao,"#EE9A49");
        list.add(data3);
        GridData data4 = new GridData(R.drawable.mao,"#FF0000");
        list.add(data4);
        GridData data5 = new GridData(R.drawable.mao,"#D02090");
        list.add(data5);
        GridData data6 = new GridData(R.drawable.mao,"#8B4C39");
        list.add(data6);
        GridData data7 = new GridData(R.drawable.mao,"#8B0000");
        list.add(data7);
        GridData data8 = new GridData(R.drawable.mao,"#FF6347");
        list.add(data8);
        GridData data9 = new GridData(R.drawable.mao,"#CD8C95");
        list.add(data9);
//        GridData data10 = new GridData(R.drawable.mao,"#ccc");
//        list.add(data10);


    }
}