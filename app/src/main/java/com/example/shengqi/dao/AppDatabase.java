package com.example.shengqi.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.shengqi.Room.Student;


@Database(entities = {Student.class}, version = 1 ,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract Studentdao studentdao();
    private static AppDatabase INSTANCE;



    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "database-name").allowMainThreadQueries().build();

            //Room.inMemoryDatabaseBuilder(context.getApplicationContext(),AppDatabase.class).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}


