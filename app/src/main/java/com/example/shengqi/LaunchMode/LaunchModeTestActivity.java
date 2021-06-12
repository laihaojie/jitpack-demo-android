package com.example.shengqi.LaunchMode;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shengqi.Lianxi.LianxiActivity;
import com.example.shengqi.R;

public class LaunchModeTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launche_mode_test);
        findViewById(R.id.test).setOnClickListener(view -> {
            Intent intent = new Intent(this, LianxiActivity.class);
            startActivity(intent);
        });
    }
}