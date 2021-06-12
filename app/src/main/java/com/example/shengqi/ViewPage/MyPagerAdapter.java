package com.example.shengqi.ViewPage;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends PagerAdapter {

    private ArrayList<View> viewlist;

    public MyPagerAdapter() {

    }

    public MyPagerAdapter(ArrayList<View> viewlist) {
        super();
        this.viewlist = viewlist;
    }

    @Override
    public int getCount() {
        return viewlist.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View ss =viewlist.get(position);

        container.addView(ss);
        return viewlist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewlist.get(position));
    }


}
