package com.example.shengqi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shengqi.Banner.BannerActivity;
import com.example.shengqi.BroadcastReceiver.BroadcastActivity;
import com.example.shengqi.Download.DownloadActivity;
import com.example.shengqi.Eventbus.EventbusActivity;
import com.example.shengqi.Grid.GridActivity;
import com.example.shengqi.LaunchMode.LaunchModeActivity;
import com.example.shengqi.Lianxi.LianxiActivity;
import com.example.shengqi.Refresh.RefreshActivity;
import com.example.shengqi.Room.RoomActivity;
import com.example.shengqi.Rxjava.RxjavaActivity;
import com.example.shengqi.Service.ServiceActivity;
import com.example.shengqi.Thread.ThreadActivity;
import com.example.shengqi.Video.VideoActivity;
import com.example.shengqi.ViewPage.ViewPageActivity;
import com.example.shengqi.WeChat.WeChatActivity;
import com.example.shengqi.WebView.WebViewActivity;
import com.example.shengqi.file.FileActivity;
import com.example.shengqi.fragment.ContainerActivity;
import com.example.shengqi.recyclerview.RecyclerviewActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity {

    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private TextView t5;
    private TextView t6;
    private TextView t7;
    private TextView t8;
    private TextView t9;
    private TextView t10;
    private TextView t11;
    private TextView t12;
    private TextView t13;
    private TextView t14;
    private TextView t15;
    private TextView t16;
    private TextView t17;
    private TextView t18;
    private TextView t19;
    private TextView t20;
    private TextView t21;
    private TextView t22;
    private TextView t23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null){
            actionbar.hide();
        }

        t1 = findViewById(R.id.t_1);
        t2 = findViewById(R.id.t_2);
        t3 = findViewById(R.id.btn_lll);
        t4 = findViewById(R.id.btn_list);
        t5 = findViewById(R.id.btn_re);
        t6 = findViewById(R.id.btn_lx);
        t7 = findViewById(R.id.btn_gr);
        t8 = findViewById(R.id.btn_fr);
        t9 = findViewById(R.id.btn_bd);
        t10 = findViewById(R.id.btn_th);
        t11 = findViewById(R.id.btn_se);
        t12 = findViewById(R.id.btn_dl);
        t13 = findViewById(R.id.btn_fl);
        t14 = findViewById(R.id.btn_wb);
        t15 = findViewById(R.id.btn_rx);
        t16 = findViewById(R.id.btn_rh);
        t17 = findViewById(R.id.btn_bn);
        t18 = findViewById(R.id.btn_ev);
        t19 = findViewById(R.id.btn_rm);
        t20 = findViewById(R.id.btn_wc);
        t21 = findViewById(R.id.btn_vp);
        t22 = findViewById(R.id.btn_video);
        t23 = findViewById(R.id.btn_lm);


        t1.setOnClickListener(new Onclick());
        t3.setOnClickListener(new Onclick());
        t5.setOnClickListener(new Onclick());
        t6.setOnClickListener(new Onclick());
        t7.setOnClickListener(new Onclick());
        t8.setOnClickListener(new Onclick());
        t9.setOnClickListener(new Onclick());
        t10.setOnClickListener(new Onclick());
        t11.setOnClickListener(new Onclick());
        t12.setOnClickListener(new Onclick());
        t13.setOnClickListener(new Onclick());
        t14.setOnClickListener(new Onclick());
        t15.setOnClickListener(new Onclick());
        t16.setOnClickListener(new Onclick());
        t17.setOnClickListener(new Onclick());
        t18.setOnClickListener(new Onclick());
        t19.setOnClickListener(new Onclick());
        t20.setOnClickListener(new Onclick());
        t21.setOnClickListener(new Onclick());
        t22.setOnClickListener(new Onclick());
        t23.setOnClickListener(new Onclick());

//        ArrayList list = List();
        ArrayList list = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            list = sortList();
        }
        String str = "";
        for (int j = 0; j < list.size(); j++) {
             str += list.get(j);
        }
        t4.setText(str);


    }

    class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.t_1:
                    intent = new Intent(MainActivity.this,twoActivity.class);
                    break;
                case R.id.btn_lll:
                    intent = new Intent(MainActivity.this,LInearActivity.class);
                    break;
                case R.id.btn_re:
                    intent = new Intent(MainActivity.this, RecyclerviewActivity.class);
                    break;
                case R.id.btn_lx:
                    intent = new Intent(MainActivity.this, LianxiActivity.class);
                    break;
                case R.id.btn_gr:
                    intent = new Intent(MainActivity.this, GridActivity.class);
                    break;
                case R.id.btn_fr:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_bd:
                    intent = new Intent(MainActivity.this, BroadcastActivity.class);
                    break;
                case R.id.btn_th:
                    intent = new Intent(MainActivity.this, ThreadActivity.class);
                    break;
                case R.id.btn_se:
                    intent = new Intent(MainActivity.this, ServiceActivity.class);
                    break;
                case R.id.btn_dl:
                    intent = new Intent(MainActivity.this, DownloadActivity.class);
                    break;
                case R.id.btn_fl:
                    intent = new Intent(MainActivity.this, FileActivity.class);
                    break;
                case R.id.btn_wb:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_rx:
                    intent = new Intent(MainActivity.this, RxjavaActivity.class);
                    break;
                case R.id.btn_rh:
                    intent = new Intent(MainActivity.this, RefreshActivity.class);
                    break;
                case R.id.btn_bn:
                    intent = new Intent(MainActivity.this, BannerActivity.class);
                    break;
                case R.id.btn_ev:
                    intent = new Intent(MainActivity.this, EventbusActivity.class);
                    break;
                case R.id.btn_rm:
                    intent = new Intent(MainActivity.this, RoomActivity.class);
                    break;
                case R.id.btn_wc:
                    intent = new Intent(MainActivity.this, WeChatActivity.class);
                    break;
                case R.id.btn_vp:
                    intent = new Intent(MainActivity.this, ViewPageActivity.class);
                    break;
                case R.id.btn_video:
                    intent = new Intent(MainActivity.this, VideoActivity.class);
                    break;
                case R.id.btn_lm:
                    intent = new Intent(MainActivity.this, LaunchModeActivity.class);
                    break;
            }
            startActivity(intent);

        }
    }

    public ArrayList List(){
        Integer[] intArray = new Integer[] {2,1,2,1,3,9,7,7};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(intArray));

        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(list);

        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);


        return listWithoutDuplicates;

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList sortList(){
        Integer[] intArray = new Integer[] {6,8,9,2,3,5,10};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(intArray));
        list.sort(Comparator.<Integer>naturalOrder());

        return list;

    }

}