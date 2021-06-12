package com.example.shengqi;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null){
            actionbar.hide();
        }


//        ArrayList list = List();
        ArrayList list = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            list = sortList();
        }
        String str = "";
        for (int j = 0; j < list.size(); j++) {
             str += list.get(j);
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