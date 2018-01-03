package com.dailyart.bookstoreapplication.bookdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by 27DH on 2018/1/2.
 */
@Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {
    abstract public BookDao bookDao();
}
