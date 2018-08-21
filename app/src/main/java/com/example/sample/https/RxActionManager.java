package com.example.sample.https;

import rx.Subscription;

/**
 * Created by 赖祖宏 on 2018/3/30.
 */

public interface RxActionManager<T> {

    void add(T tag, Subscription subscription);
    void remove(T tag);

    void cancel(T tag);

    void cancelAll();
}
