package com.example.shengqi.file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.shengqi.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private EditText medit;
    private Button mb1,mb2;
    private TextView mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        medit = findViewById(R.id.Edit1);
        mb1 = findViewById(R.id.mbtncunru);
        mb2 = findViewById(R.id.mbtnquchu);
        mt = findViewById(R.id.mt1);
        mb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(medit.getText().toString());
            }
        });
        mb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mt.setText(read());
            }
        });
    }
    private void save(String text){
        FileOutputStream file = null;
        try {
            file = openFileOutput("text.txt", Context.MODE_APPEND);

            file.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String read(){
        FileInputStream file = null;
        try {
            file = openFileInput("text.txt");
            byte[] bytes = new byte[1024];
            StringBuilder s = new StringBuilder("");
            int len = 0;
            while ((len = file.read(bytes)) > 0){
                s.append(new String(bytes,0,len));
            }
            return s.toString();
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}