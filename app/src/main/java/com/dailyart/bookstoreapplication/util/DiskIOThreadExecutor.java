package com.dailyart.bookstoreapplication.util;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by 27DH on 2018/1/20.
 */

public class DiskIOThreadExecutor implements Executor {

    private final Executor diskIO;

    public DiskIOThreadExecutor() {
        diskIO = Executors.newSingleThreadExecutor();
    }

    @Override
    public void execute(@NonNull Runnable runnable) {
        diskIO.execute(runnable);
    }
}
