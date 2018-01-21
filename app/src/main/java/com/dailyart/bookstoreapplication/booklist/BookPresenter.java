package com.dailyart.bookstoreapplication.booklist;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.dailyart.bookstoreapplication.BookSource;
import com.dailyart.bookstoreapplication.bookdb.Book;
import com.dailyart.bookstoreapplication.bookdb.BookRepository;
import com.dailyart.bookstoreapplication.insert.AddBookActivity;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by 27DH on 2018/1/20.
 */

public class BookPresenter implements BooksContract.Presenter {

    private final BookRepository bookRepository;

    private final BooksContract.View bookView;

    private boolean mFirstLoad = true;

    public BookPresenter(@NonNull BookRepository bookRepository, @NonNull BooksContract.View bookView) {
        this.bookRepository = checkNotNull(bookRepository, "bookRepository cannot be null");
        this.bookView = checkNotNull(bookView, "bookView cannot be null");

        this.bookView.setPresenter(this);
    }

    @Override
    public void start() {
        bookRepository.getBooks(new BookSource.LoadBooksCallback() {
            @Override
            public void onBooksLoaded(List<Book> books) {
                bookView.showBook(books);
            }

            @Override
            public void onBooksNotAvailable() {

            }
        });

    }

    @Override
    public void addBook() {

    }

    @Override
    public void loadBook() {

    }

    @Override
    public void loadBooks() {

    }

    @Override
    public void result(int requestCode, int resultCode) {
        if (AddBookActivity.REQUEST_ADD_TASK == requestCode && Activity.RESULT_OK == resultCode) {
            bookView.showSuccessfullySavedMessage();
        }
    }

    @Override
    public void addNewBook() {
        bookView.showAddBook();
    }


}
