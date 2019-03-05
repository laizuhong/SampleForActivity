package com.example.sample.https;


import com.example.sample.bean.HttpResult;

import rx.functions.Func1;

/**
 * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 *
 * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
 */

public class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

    @Override
    public T call(HttpResult<T> httpResult) {
//        if (!httpResult.isSuccess()) {
//            throw new ApiException(httpResult.getErrorCode(),httpResult.getResultMsg());
//        }
        if (!httpResult.getState().equals("200")) {
            throw new ApiException(httpResult.getState()+"",httpResult.getMessage());
        }
        return httpResult.getData();
    }


}