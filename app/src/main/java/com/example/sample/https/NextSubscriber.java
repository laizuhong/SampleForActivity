package com.example.sample.https;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;

import rx.Subscriber;

/**
 *
 * Created by 赖祖宏 on 2018/3/28.
 */

public abstract class NextSubscriber<T> extends Subscriber<T> implements OnSuccessListener<T>{

    private ProgressDialog progressDialog;
    private SwipeRefreshLayout swipeRefreshLayout;

    public NextSubscriber(ProgressDialog progressDialog) {
        this.progressDialog=progressDialog;
    }

    public NextSubscriber(){

    }

    public NextSubscriber(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    @Override
    public void onCompleted() {
        if (progressDialog!=null)
            progressDialog.dismiss();
        if (swipeRefreshLayout!=null){
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (progressDialog!=null)
            progressDialog.dismiss();
        if (swipeRefreshLayout!=null){
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onSuccess(T t) {
        if (progressDialog!=null)
            progressDialog.dismiss();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (progressDialog!=null)
            progressDialog.show();
    }

}
