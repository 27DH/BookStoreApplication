package com.dailyart.bookstoreapplication;

import android.support.annotation.NonNull;

import com.dailyart.bookstoreapplication.bookdb.Book;

import java.util.List;

/**
 * Created by 27DH on 2018/1/5.
 */

public interface BookSource {
    interface LoadBooksCallback {
        void onBooksLoaded(List<Book> books);
        void onBooksNotAvailable();
    }

    interface GetBookCallback {
        void onBookLoaded(Book book);
        void onBookNotAvailable();
    }

    void getBooks(@NonNull LoadBooksCallback callback);
    void getBook(@NonNull int bookId, @NonNull GetBookCallback callback);
    void insertBook(@NonNull Book book);
    void deleteBook(@NonNull Book book);
    void updateBook(@NonNull Book book);


}
