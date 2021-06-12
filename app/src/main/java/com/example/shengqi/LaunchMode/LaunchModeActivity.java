package com.example.shengqi.LaunchMode;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shengqi.R;

public class LaunchModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);

        findViewById(R.id.btn).setOnClickListener(view -> {
            Intent intent = new Intent(this, LaunchModeTestActivity.class);
            startActivity(intent);
        });
    }

}