package com.example.shengqi.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private DownLoadBinder mBinder = new DownLoadBinder();

    public MyService() {
    }

    class DownLoadBinder extends Binder {
        public void startDownload(){
            Log.d("MyService", "startDownload: 开始下载");
        }

        public int getProgress(){
            Log.d("MyService", "getProgress: 获取下载");
            return 0;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "onCreate: 创建服务");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onCreate: 启动服务");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "onCreate: 停止服务");

    }
}
