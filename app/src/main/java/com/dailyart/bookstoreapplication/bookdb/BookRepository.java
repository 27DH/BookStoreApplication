package com.dailyart.bookstoreapplication.bookdb;

import android.support.annotation.NonNull;

import com.dailyart.bookstoreapplication.BookSource;
import com.dailyart.bookstoreapplication.util.AppExecutors;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by 27DH on 2018/1/7.
 */

public class BookRepository implements BookSource {

    private AppExecutors executor;
    private BookDao bookDao;

    private static volatile BookSource INSTANCE;


    private BookRepository(@NonNull AppExecutors executor, @NonNull BookDao bookDao) {
        this.executor = executor;
        this.bookDao = bookDao;

    }

    public synchronized static BookRepository getInstance(@NonNull AppExecutors executor, @NonNull BookDao bookDao) {
        if (INSTANCE == null) {
            INSTANCE = new BookRepository(executor, bookDao);
        }
        return INSTANCE;
    }

    @Override
    public void getBooks(@NonNull final LoadBooksCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Book> books = bookDao.loadAll();
                executor.mainThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (books.isEmpty()) {
                            callback.onBooksNotAvailable();
                        } else {
                            callback.onBooksLoaded(books);
                        }
                    }
                });

            }
        };

        executor.diskIO().execute(runnable);

    }

    @Override
    public void getBook(@NonNull final int bookId, @NonNull final GetBookCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Book book = bookDao.loadById(bookId);
                executor.mainThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (book != null) {
                            callback.onBookLoaded(book);
                        } else {
                            callback.onBookNotAvailable();
                        }
                    }
                });
            }
        };

        executor.diskIO().execute(runnable);
    }

    @Override
    public void insertBook(@NonNull final Book book) {
        checkNotNull(book);
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                bookDao.insertBook(book);
            }
        };

        executor.diskIO().execute(saveRunnable);
    }

    @Override
    public void deleteBook(@NonNull final Book book) {
        Runnable deleteRunnable = new Runnable() {
            @Override
            public void run() {
                bookDao.deleteBook(book);
            }
        };

        executor.diskIO().execute(deleteRunnable);
    }

    @Override
    public void updateBook(@NonNull final Book book) {
        Runnable updateRunnable = new Runnable() {
            @Override
            public void run() {
                bookDao.updateBook(book);
            }
        };

        executor.diskIO().execute(updateRunnable);
    }
}
