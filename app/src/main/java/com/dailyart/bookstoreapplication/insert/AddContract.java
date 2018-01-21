package com.dailyart.bookstoreapplication.insert;

import com.dailyart.bookstoreapplication.BasePresenter;
import com.dailyart.bookstoreapplication.BaseView;
import com.dailyart.bookstoreapplication.booklist.BooksContract;

/**
 * Created by 27DH on 2018/1/21.
 */

public interface AddContract {

    interface View extends BaseView<AddContract.Presenter> {
        void showBook();
    }

    interface Presenter extends BasePresenter {

        void saveBook(String id,String press, String book, String author);

    }
}
