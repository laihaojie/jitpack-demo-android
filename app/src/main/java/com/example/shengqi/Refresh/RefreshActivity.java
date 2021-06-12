package com.example.shengqi.Refresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.shengqi.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RefreshActivity extends AppCompatActivity {

    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        ButterKnife.bind(this);

//        refresh.setEnableLoadMore(false); //关闭上拉加载
//        refresh.setEnableRefresh(false);
//        refresh.setRefreshHeader(new BezierRadarHeader(this).setEnableHorizontalDrag(true));
//        refresh.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText(RefreshActivity.this, "上拉加载", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable(){
                    public void run(){
                        //execute the task
                        refresh.finishLoadMore();
                    }
                },1000);
            }

        });
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText(RefreshActivity.this, "下拉刷新", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable(){
                    public void run(){
                        //execute the task
                        refresh.finishRefresh();
                    }
                },1000);
            }
        });
    }
}