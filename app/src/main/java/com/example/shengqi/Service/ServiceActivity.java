package com.example.shengqi.Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.example.shengqi.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mbtn1;
    private Button mbtn2;
    private Button mbtn3;
    private Button mbtn4;
    private MyService.DownLoadBinder downLoadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downLoadBinder = (MyService.DownLoadBinder) iBinder;
            downLoadBinder.startDownload();
            downLoadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        mbtn1 = findViewById(R.id.s_1);
        mbtn2 = findViewById(R.id.s_2);
        mbtn3 = findViewById(R.id.s_3);
        mbtn4 = findViewById(R.id.s_4);
        mbtn1.setOnClickListener(this);
        mbtn2.setOnClickListener(this);
        mbtn3.setOnClickListener(this);
        mbtn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.s_1:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.s_2:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.s_3:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.s_4:
                unbindService(connection);
                break;
        }


    }
}