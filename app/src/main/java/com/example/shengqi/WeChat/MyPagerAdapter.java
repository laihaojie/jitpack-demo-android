package com.example.shengqi.WeChat;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager fm;
    private ArrayList<Fragment> list;


    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.fm = fm;
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
