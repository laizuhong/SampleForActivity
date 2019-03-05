package com.example.sample.https;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by 赖祖宏 on 2018/3/23.
 */

public class TokenClient {

    public static final String BASE_URL = "http://192.168.7.86:8080/";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private TokenService tokenService;

    //构造方法私有
    private TokenClient() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                //modify by zqikai 20160317 for 对http请求结果进行统一的预处理 GosnResponseBodyConvert
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ResponseConvertFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        tokenService = retrofit.create(TokenService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final TokenClient INSTANCE = new TokenClient();
    }

    //获取单例
    public static TokenClient getInstance() {
        return SingletonHolder.INSTANCE;
    }


    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(s);
    }


    private Map<String,String> getMap(){
        Map<String, String> map = new HashMap<>();
//        map.put("imei", DeviceUtils.getDeviceId());
        map.put("timestamp", new Date().getTime() + "");
//        map.put("token", Setting.newInstance().getTOKEN());
        return map;
    }
}
