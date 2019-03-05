package com.example.sample.https;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * 用于上传文件
 * Created by 赖祖宏 on 2018/4/12.
 */

public class FileClient {

    private static final String BASE_URL = "http://192.168.7.86:8080/";

    private static final int DEFAULT_TIMEOUT = 30;

    private Retrofit retrofit;
    private FileService fileService;

    //构造方法私有
    private FileClient() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

//        builder.cookieJar()
        builder.addInterceptor(new AddCookiesInterceptor()) //这部分
                .addInterceptor(new ReceivedCookiesInterceptor());//这部分

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                //modify by zqikai 20160317 for 对http请求结果进行统一的预处理 GosnResponseBodyConvert
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ResponseConvertFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        fileService = retrofit.create(FileService.class);

    }

    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final FileClient INSTANCE = new FileClient();
    }

    //获取单例
    public static FileClient getInstance() {
        return SingletonHolder.INSTANCE;
    }


    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {

        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .onErrorResumeNext(new HttpResponseFunc<T>())
                .subscribe(s);
    }

    private Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
//        map.put("imei", DeviceUtils.getDeviceId());
        map.put("timestamp", new Date().getTime() + "");
        return map;
    }



//
//    public void uploadPic(List<File> list,Subscriber<List<String>> subscriber){
//        Map<String,String> map=getMap();
//        map.put("typeFlag",SharedPreferenceUtil.newInstance().getUserId());
//        MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("image/png");
//
//        MultipartBody.Part [] part =new MultipartBody.Part[list.size()];
//
//
////        Map<String,RequestBody> bodyMap=new HashMap<>();
//        for (int i = 0; i < list.size(); i++) {
//            File file=list.get(i);
//            part[i] =MultipartBody.Part.createFormData("fileList", file.getName(),
//                    RequestBody.create(MEDIA_TYPE_MARKDOWN, file));
//        }
//
////            bodyMap.put("fileList",RequestBody.create(MEDIA_TYPE_MARKDOWN, file));
////        }
//        Observable<List<String>> observable = fileService.uploadImages(map, part)
//                .map(new HttpResultFunc<List<String>>());
//        toSubscribe(observable, subscriber);
//    }
//
//
//    public void addImg(String typeFlag,File file,Subscriber<OneFile> subscriber){
//        Map<String,String> map=getMap();
//        map.put("typeFlag",SharedPreferenceUtil.newInstance().getUserId());
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse("image/png"), file);
//        MultipartBody.Part body =
//                MultipartBody.Part.createFormData("imgFile", file.getName(), requestFile);
//        Observable<OneFile> observable = fileService.addImg(map, body)
//                .map(new HttpResultFunc<OneFile>());
//        toSubscribe(observable, subscriber);
//    }


}
