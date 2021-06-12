package com.example.shengqi.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shengqi.MainActivity;
import com.example.shengqi.R;

import java.util.ArrayList;
import java.util.List;

public class ContainerActivity extends AppCompatActivity {

    private Fragment f1;
    private Fragment f2;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private TextView t5;
    private List<TextView> list = new ArrayList<>();
    private Boolean bl = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        f1 = new AFragment("1");
        f2 = new BFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.f_view,f1).commitAllowingStateLoss();

        t1 = findViewById(R.id.btn_1);
        t2 = findViewById(R.id.btn_2);
        t3 = findViewById(R.id.btn_3);
        t4 = findViewById(R.id.btn_4);
        t5 = findViewById(R.id.btn_5);

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);



        t1.setOnClickListener(new Onclick());
        t2.setOnClickListener(new Onclick());
        t3.setOnClickListener(new Onclick());
        t4.setOnClickListener(new Onclick());
        t5.setOnClickListener(new Onclick());

//        t1.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                if ( getSupportFragmentManager().getFragments().get(0) == f2)
////                {
////                    getSupportFragmentManager().beginTransaction().replace(R.id.f_view,f1).commitAllowingStateLoss();
////                }else  {
////                    getSupportFragmentManager().beginTransaction().replace(R.id.f_view,f2).commitAllowingStateLoss();
////                }
////
////            }
////        });

    }
    public void setColor (int id){
        for (int i = 0;i<=list.size();i++){
            if(id == list.get(i).getId()){
                list.get(i).setBackgroundColor(Color.parseColor("#FF0000"));
            }else{
                list.get(i).setBackgroundColor(Color.parseColor("#CCCCCC"));
            }
        }
    }

    class Onclick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_1:
                    setColor(R.id.btn_1);
                    f1 = new AFragment("1");
                    getSupportFragmentManager().beginTransaction().replace(R.id.f_view,f1).commitAllowingStateLoss();
                    break;
                case R.id.btn_2:
                    setColor(R.id.btn_2);
                    f1 = new AFragment("2");
                    getSupportFragmentManager().beginTransaction().replace(R.id.f_view,f1).commitAllowingStateLoss();
                    break;
                case R.id.btn_3:
                    setColor(R.id.btn_3);
                    f1 = new AFragment("3");
                    getSupportFragmentManager().beginTransaction().replace(R.id.f_view,f1).commitAllowingStateLoss();
                    break;
                case R.id.btn_4:
                    setColor(R.id.btn_4);
                    f1 = new AFragment("4");
                    getSupportFragmentManager().beginTransaction().replace(R.id.f_view,f1).commitAllowingStateLoss();
                    break;
                case R.id.btn_5:
                    setColor(R.id.btn_5);
                    f1 = new AFragment("5");
                    getSupportFragmentManager().beginTransaction().replace(R.id.f_view,f1).commitAllowingStateLoss();
                    break;
            }
        }
    }
}