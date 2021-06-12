package com.example.shengqi.Room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shengqi.R;
import com.example.shengqi.dao.AppDatabase;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoomActivity extends AppCompatActivity {

    @BindView(R.id.room_name)
    EditText mtext1;

    @BindView(R.id.room_age)
    EditText mtext2;


    @BindView(R.id.room_btn)
    Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.room_btn})
    public void clike (View view){
        String name = mtext1.getText().toString();
        int age = Integer.parseInt(mtext1.getText().toString());

        Student student = new Student();
        student.setAge(age);
        student.setName(name);

        AppDatabase.getAppDatabase(this).studentdao().saveStudent(student);

    }
}