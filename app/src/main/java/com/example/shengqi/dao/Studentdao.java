package com.example.shengqi.dao;

import androidx.room.Dao;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.shengqi.Room.Student;

import java.util.List;

/**
 * Author: Norton
 * Date: 2020-01-13 15:33
 * Description: ${DESCRIPTION}
 */
//public class IdeaDao {
//    @Query("SELECT * FROM idea")
//    public static void saveDBIdea(DBIdea dbIdea) ;
//
//    public static void saveDBMaterial( ){
////        LitePal.saveAll(list);
//    }
//
//    public static DBIdea findIdeaId(String dbIdeaId){
//        return  LitePal.where("ideaId = ?", dbIdeaId).findFirst(DBIdea.class);
//    }
//
//    public static List<DBIdea> findAll(){
//        if (LitePal.findAll(DBIdea.class) != null){
//            return  LitePal.findAll(DBIdea.class);
//        }
//        return new ArrayList<>();
//    }
//
//}


@Dao
public interface Studentdao {

    @Insert
    void saveStudent(Student... student);

    @Query("SELECT * FROM student order by id desc")
    List<Student> findAll();

//    @Query("SELECT * FROM student where id = :dbIdeaId  order by playTime desc limit 1")
//    Student findIdeaId(String dbIdeaId);
//
//    @Delete()
//    void del(Student... dbIdeas);
//
//    @Query("DELETE  FROM student where rowid  in (SELECT ROWID FROM idea ORDER BY  playtime desc  LIMIT 10 OFFSET 5)")
//    void delSync();
//
//    @Query("SELECT * FROM student order by  playTime desc  LIMIT 10 OFFSET 5")
//    List<Student> findSync();
//
//    @Query("DELETE FROM student")
//    void delAll();



}