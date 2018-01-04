package com.dailyart.bookstoreapplication.booklist;

import com.dailyart.bookstoreapplication.BasePresenter;
import com.dailyart.bookstoreapplication.BaseView;

/**
 * Created by 27DH on 2018/1/5.
 */

public interface BooksContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void loadBook();
        void loadBooks();
    }
}
