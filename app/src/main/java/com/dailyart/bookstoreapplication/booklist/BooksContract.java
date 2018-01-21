package com.dailyart.bookstoreapplication.booklist;

import com.dailyart.bookstoreapplication.BasePresenter;
import com.dailyart.bookstoreapplication.BaseView;
import com.dailyart.bookstoreapplication.bookdb.Book;

import java.util.List;

/**
 * Created by 27DH on 2018/1/5.
 */

public interface BooksContract {
    interface View extends BaseView<Presenter> {
        void showSuccessfullySavedMessage();
        void showAddBook();
        void showBook(List<Book> books);

    }

    interface Presenter extends BasePresenter {
        void result(int requestCode, int resultCode);
        void addBook();
        void loadBook();
        void loadBooks();
        void addNewBook();
    }
}
