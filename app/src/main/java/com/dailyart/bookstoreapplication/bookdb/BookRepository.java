package com.dailyart.bookstoreapplication.bookdb;

import android.support.annotation.NonNull;

import com.dailyart.bookstoreapplication.BookSource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 27DH on 2018/1/7.
 */

public class BookRepository implements BookSource {

    private ExecutorService es = Executors.newFixedThreadPool(1);


    @Override
    public void getBooks(@NonNull LoadBooksCallback callback) {

    }

    @Override
    public void getBook(@NonNull String bookId, @NonNull GetBookCallback callback) {

    }

    @Override
    public void insertBook(@NonNull Book book) {

    }

    @Override
    public void deleteBook(@NonNull Book book) {

    }

    @Override
    public void updateBook(@NonNull Book book) {
        
    }
}
