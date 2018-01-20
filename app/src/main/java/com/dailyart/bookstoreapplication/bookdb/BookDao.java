package com.dailyart.bookstoreapplication.bookdb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by 27DH on 2018/1/2.
 */
@Dao
public interface BookDao {
    @Query("SELECT * FROM book")
    List<Book> loadAll();
    @Query("SELECT * from book where press = :press")
    List<Book> loadByPress(String press);
    @Query("SELECT * from book where id = :id")
    Book loadById(int id);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBooks(Book... books);
    @Insert
    void insertBook(Book book);
    @Delete
    void deleteBooks(Book... books);
    @Delete
    void deleteBook(Book book);
    @Update
    void updateBooks(Book... books);
    @Update
    void updateBook(Book book);

}
