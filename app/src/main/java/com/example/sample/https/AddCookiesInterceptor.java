package com.example.sample.https;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * Created by 赖祖宏 on 2018/4/11.
 */

public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
//        HashSet<String> preferences = (HashSet<String>) SharedPreferenceUtil.newInstance().getCookie();
//        if (preferences != null) {
//            for (String cookie : preferences) {
//                builder.addHeader("Cookie", cookie);
//                Log.v("OkHttp", "Adding Header: " + cookie); // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
//            }
//        }
        return chain.proceed(builder.build());
    }

}
