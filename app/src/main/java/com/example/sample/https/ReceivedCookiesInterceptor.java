package com.example.sample.https;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 *
 * Created by 赖祖宏 on 2018/4/11.
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

//        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
//            HashSet<String> cookies = new HashSet<>();
//
//            for (String header : originalResponse.headers("Set-Cookie")) {
//                cookies.add(header);
//            }
//
//            SharedPreferenceUtil.newInstance().setCookie(cookies);
//
//        }

        return originalResponse;
    }


}
