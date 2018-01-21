package com.dailyart.bookstoreapplication;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by 27DH on 2018/1/21.
 */

public class BookApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
