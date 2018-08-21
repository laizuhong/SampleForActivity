package com.example.sample.https;

import rx.Observable;
import rx.functions.Func1;

/**
 *
 * Created by 赖祖宏 on 2018/4/11.
 */

public class HttpResponseFunc<T> implements Func1<Throwable, Observable<T>> {
    @Override
    public Observable<T> call(Throwable throwable) {
        //ExceptionEngine为处理异常的驱动器
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}