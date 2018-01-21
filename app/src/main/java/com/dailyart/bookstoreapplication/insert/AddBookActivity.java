package com.dailyart.bookstoreapplication.insert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dailyart.bookstoreapplication.R;
import com.dailyart.bookstoreapplication.bookdb.BookDatabase;
import com.dailyart.bookstoreapplication.bookdb.BookRepository;
import com.dailyart.bookstoreapplication.util.ActivityUtils;
import com.dailyart.bookstoreapplication.util.AppExecutors;

public class AddBookActivity extends AppCompatActivity {

    private AddPresenter addPresenter;

    public static final int REQUEST_ADD_TASK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        AddFragment addFragment = (AddFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (addFragment == null) {
            addFragment = AddFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), addFragment, R.id.contentFrame);
        }

        addPresenter = new AddPresenter(BookRepository.getInstance(new AppExecutors(), BookDatabase.getInstance(this).bookDao()),
                addFragment);
    }
}
