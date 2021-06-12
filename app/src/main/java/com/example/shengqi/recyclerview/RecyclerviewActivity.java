package com.example.shengqi.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shengqi.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewActivity extends AppCompatActivity {

    private RecyclerView re;
    private List<itemObject> itemObjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        getList();
        re = findViewById(R.id.re_view);
        re.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(itemObjects);

        re.setAdapter(adapter);




//        getList();

//        re = findViewById(R.id.re_view);
//        re.setLayoutManager(new LinearLayoutManager(this));
//        re.addItemDecoration(new MyDecoration());

//        Integer[] intArray = new Integer[] {2,1,2,1,3,9,7,7};
//        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(intArray));

//        re.setAdapter(new LinearAdapter(itemObjects, new LinearAdapter.OnItemClick() {
//            @Override
//            public void Onclick(int pos) {
//                Toast.makeText(RecyclerviewActivity.this, "" + pos, Toast.LENGTH_SHORT).show();
//            }
//        }));

    }

//    class MyDecoration extends RecyclerView.ItemDecoration{
//        @Override
//        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//            super.getItemOffsets(outRect, view, parent, state);
//            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerhHeight));
//        }
//    }

    public void getList () {

            itemObject itemObject1 = new itemObject("张三", R.drawable.mao);
            itemObjects.add(itemObject1);

            itemObject itemObject2 = new itemObject("李四", R.drawable.mao);
            itemObjects.add(itemObject2);

            itemObject itemObject3 = new itemObject("王五", R.drawable.mao);
            itemObjects.add(itemObject3);


    }
}