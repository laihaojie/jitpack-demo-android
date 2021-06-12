package com.example.shengqi.Thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shengqi.R;

public class ThreadActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int UPDATE_TEXT = 1;


    private TextView text;
    private Button mbtn;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATE_TEXT:
                    text.setText("llllllllllll");
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        text = findViewById(R.id.thread_1);
        mbtn = findViewById(R.id.change_text);
        mbtn.setOnClickListener(this);

    }

    @Override
    public void onClick (View view){
        switch (view.getId()) {
            case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            default:
                break;

            }

        }

}