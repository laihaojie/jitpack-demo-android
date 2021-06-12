package com.example.shengqi.WeChat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.shengqi.R;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

//import com.google.android.material.tabs.TabLayout;


public class WeChatActivity extends AppCompatActivity {

    private SlidingTabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> mFragments;
    private String[] mTitlesArrays ={"微信","通讯录","发现","我"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_we_chat);
        initView();
    }

    private void initView() {
        mTab = (SlidingTabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        mFragments = new ArrayList<>();
        mFragments.add(new OneFragment());
        mFragments.add(new BFragment());
        mFragments.add(new CFragment());
        mFragments.add(new BFragment());

        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), mFragments);
        mVp.setAdapter(pagerAdapter);

        mTab.setViewPager(mVp, mTitlesArrays);//tab和ViewPager进行关联
    }
}