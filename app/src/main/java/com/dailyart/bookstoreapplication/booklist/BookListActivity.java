package com.dailyart.bookstoreapplication.booklist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dailyart.bookstoreapplication.R;
import com.dailyart.bookstoreapplication.bookdb.BookDatabase;
import com.dailyart.bookstoreapplication.bookdb.BookRepository;
import com.dailyart.bookstoreapplication.util.ActivityUtils;
import com.dailyart.bookstoreapplication.util.AppExecutors;

public class BookListActivity extends AppCompatActivity {


    private BookPresenter bookPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add_book);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        BookFragment bookFragment = (BookFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (bookFragment == null) {
            bookFragment = bookFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), bookFragment, R.id.contentFrame);
        }

        bookPresenter = new BookPresenter(BookRepository.getInstance(new AppExecutors(),
                BookDatabase.getInstance(this).bookDao()), bookFragment);


    }

}
