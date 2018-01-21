package com.dailyart.bookstoreapplication.insert;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dailyart.bookstoreapplication.bookdb.Book;
import com.dailyart.bookstoreapplication.bookdb.BookRepository;
import static com.google.common.base.Preconditions.checkNotNull;
/**
 * Created by 27DH on 2018/1/21.
 */

public class AddPresenter implements AddContract.Presenter {

    @NonNull
    private final BookRepository bookRepository;

    @NonNull
    private final AddContract.View addView;


    public AddPresenter(@NonNull BookRepository bookRepository,
                        @NonNull AddContract.View view) {
        this.bookRepository = bookRepository;
        this.addView = view;

        addView.setPresenter(this);
    }

    @Override
    public void saveBook(String id, String press, String bookName, String author) {
        Book book = new Book();
        book.setId(Integer.parseInt(id));
        book.setPress(press);
        book.setAuthor(author);
        book.setBookName(bookName);
        bookRepository.insertBook(book);
        addView.showBook();
    }

    @Override
    public void start() {

    }
}
