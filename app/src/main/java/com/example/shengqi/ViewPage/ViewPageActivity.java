package com.example.shengqi.ViewPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.shengqi.R;

import java.util.ArrayList;

public class ViewPageActivity extends AppCompatActivity {
    private ViewPager vpager_one;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        vpager_one = (ViewPager) findViewById(R.id.view_page);

        LayoutInflater li = getLayoutInflater();

        aList = new ArrayList<View>();
        View v = li.inflate(R.layout.view_one,null,false);
        ((TextView) v.findViewById(R.id.t_one)).setText("33333333");
        aList.add(v);
        aList.add(li.inflate(R.layout.view_two,null,false));
        aList.add(li.inflate(R.layout.view_three,null,false));

        mAdapter = new MyPagerAdapter(aList);

        vpager_one.setAdapter(mAdapter);




    }
}