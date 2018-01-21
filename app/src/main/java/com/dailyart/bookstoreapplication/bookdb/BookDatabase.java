package com.dailyart.bookstoreapplication.bookdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by 27DH on 2018/1/2.
 */
@Database(entities = {Book.class}, version = 1 ,exportSchema = false)
public abstract class BookDatabase extends RoomDatabase {

    private static BookDatabase INSTANCE;

    abstract public BookDao bookDao();

    public synchronized static BookDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    BookDatabase.class, "book.db").build();
        }
        return INSTANCE;
    }
}
