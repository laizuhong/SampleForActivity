package com.example.sample.https;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liukun on 16/3/9.
 */
public class HttpMethods {

    private static final String BASE_URL = "http://192.168.7.86:8080/";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private AccountService accountService;

    //构造方法私有
    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        .addInterceptor(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                Request.Builder requestBuilder = request.newBuilder();
//                request = requestBuilder.post(RequestBody.create(
//                        MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"),
//                        URLDecoder.decode(bodyToString(request.body()), "UTF-8")))
//                        .build();
//                return chain.proceed(request);
//            }
//        });
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

//        builder.cookieJar(new CookieJar() {
//            @Override
//            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
//
//            }
//
//            @Override
//            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
//                return null;
//            }
//        });
        builder.addInterceptor(new AddCookiesInterceptor()) //这部分
                .addInterceptor(new ReceivedCookiesInterceptor());//这部分

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                //modify by zqikai 20160317 for 对http请求结果进行统一的预处理 GosnResponseBodyConvert
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ResponseConvertFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        accountService = retrofit.create(AccountService.class);

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
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    //获取单例
    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }


    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {

        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new HttpResponseFunc<T>())
                .subscribe(s);
    }

    private Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
//        map.put("imei", DeviceUtils.getDeviceId());
//        map.put("timestamp", new Date().getTime() + "");
        return map;
    }

//
//    public void login(String tel,String code,Subscriber<LoginResult> subscriber){
//        Map<String,String> map=getMap();
//        map.put("telephone",tel);
//        map.put("code",code);
//        Observable<LoginResult> observable = accountService.login(map)
//                .map(new HttpResultFunc<LoginResult>());
//        toSubscribe(observable, subscriber);
//    }
//
//    public void sms(String tel,Subscriber<Integer> subscriber){
//        Map<String,String> map=getMap();
//        map.put("telephone",tel);
//        Observable<Integer> observable = accountService.sms(map)
//                .map(new HttpResultFunc<Integer>());
//        toSubscribe(observable, subscriber);
//    }
//
//    public void register(String tel,String code,String yqCode,Subscriber<LoginResult> subscriber){
//        Map<String,String> map=getMap();
//        map.put("telephone",tel);
//        map.put("code",code);
//        if (!TextUtils.isEmpty(yqCode)){
//            map.put("recommendCode",yqCode);
//        }
//        Observable<LoginResult> observable = accountService.register(map)
//                .map(new HttpResultFunc<LoginResult>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 获取热门圈子
//     * @param subscriber
//     */
//    public void selectHot(Subscriber<List<CircleBean>> subscriber){
//        Map<String,String> map=getMap();
//        map.put("city","深圳");
//        Observable<List<CircleBean>> observable = accountService.selectHot(map)
//                .map(new HttpResultFunc<List<CircleBean>>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 圈子动态
//     * @param id
//     * @param page
//     * @param flag 排序方式 1.最新发表 2.最多赞
//     * @param subscriber
//     */
//    public void circleDynamic(int id,int page,int flag,Subscriber<CircleDy> subscriber){
//        Map<String,String> map=getMap();
//        map.put("circle",id+"");
//        map.put("flag",flag+"");
//        map.put("pageNum",page+"");
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        Observable<CircleDy> observable = accountService.circleDynamic(map)
//                .map(new HttpResultFunc<CircleDy>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 圈子详情
//     * @param subscriber
//     */
//    public void selectCircleDail(int id,Subscriber<CircleBean> subscriber){
//        Map<String,String> map=getMap();
//        map.put("circleId",id+"");
//        String uid=SharedPreferenceUtil.newInstance().getUserId();
//        if (TextUtils.isEmpty(uid)){
//            map.put("userId",0+"");
//        }else {
//            map.put("userId",uid);
//        }
//        Observable<CircleBean> observable = accountService.selectCircleDeil(map)
//                .map(new HttpResultFunc<CircleBean>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 热门圈子
//     * @param subscriber
//     */
//    public void selectHotDynamic(int index,Subscriber<CircleDy> subscriber){
//        Map<String,String> map=getMap();
//        map.put("pageNum",index+"");
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        map.put("city", SharedPreferenceUtil.newInstance().getCity());
//        Observable<CircleDy> observable = accountService.selectHotDynamic(map)
//                .map(new HttpResultFunc<CircleDy>());
//        toSubscribe(observable, subscriber);
//    }
//    /**
//     * 话题/动态详情
//     * @param subscriber
//     * @param type 动态类型(1.用户动态 2.商家动态)
//     */
//    public void selectDynDetilForApp(int id,int type,Subscriber<Dynamic> subscriber){
//        Map<String,String> map=getMap();
//        map.put("dynamicId",id+"");
//        map.put("dynamictype",type+"");
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        Observable<Dynamic> observable = accountService.selectDynDetilForApp(map)
//                .map(new HttpResultFunc<Dynamic>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 关注圈子
//     * @param isFollow （0.取关 1.关注）
//     * @param subscriber
//     */
//    public void followCirCle(int isFollow,int id,Subscriber<String> subscriber){
//        Map<String,String> map=getMap();
//        map.put("circleId",id+"");
//        map.put("attStatus",isFollow+"");
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//
//        Observable<String> observable = accountService.followCirCle(map)
//                .map(new HttpResultFunc<String>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 发评论
//     * @param subscriber
//     */
//    public void sendComment(int dyType,int dyId,String content,Subscriber<String> subscriber){
//        Map<String,String> map=getMap();
//        map.put("dynamicId",dyId+"");
//        map.put("appraiseContext",content);
//        map.put("dynamicType",dyType+"");
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//
//        Observable<String> observable = accountService.sendComment(map)
//                .map(new HttpResultFunc<String>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 点赞
//     * @param dyId
//     * @param status 状态（0.取消赞 1.点赞）
//     * @param type 类型(1.用户动态 2.商家动态 3.评论)
//     * @param subscriber
//     */
//    public void pointZan(int dyId,int status,int type,Subscriber<String> subscriber){
//        Map<String,String> map=getMap();
//        map.put("dynamicId",dyId+"");
//        map.put("praiseStatus",status+"");
//        map.put("praiseType",type+"");
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//
//        Observable<String> observable = accountService.pointZan(map)
//                .map(new HttpResultFunc<String>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 点赞
//     * @param dyId
//     * @param status 状态（0.取消赞 1.点赞）
//     * @param type 类型(1.用户动态 2.商家动态 3.评论)
//     * @param onPointAgreeListener
//     */
//    public void pointZan(int dyId, int status, int type, OnPointAgreeListener onPointAgreeListener){
//        pointZan(dyId, status, type, new NextSubscriber<String>() {
//
//            @Override
//            public void onError(Throwable e) {
//                super.onError(e);
//                onPointAgreeListener.onError();
//            }
//
//            @Override
//            public void onSuccess(String s) {
//                super.onSuccess(s);
//                if (status==0){
//                    onPointAgreeListener.onCancelPointSuccess();
//                }else {
//                    onPointAgreeListener.onPointSuccess();
//                }
//            }
//        });
//    }
//
//
//    /**
//     * 发现-商家标签
//     */
//    public void findLabels(Subscriber<List<LabelBean>> subscriber){
//        Map<String,String> map=getMap();
//        Observable<List<LabelBean>> observable = accountService.findLabels(map)
//                .map(new HttpResultFunc<List<LabelBean>>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 发现-商家标签下的列表
//     */
//    public void getLabelsDy(int labId,int pageIndex,Subscriber<CircleDy> subscriber){
//        Map<String,String> map=getMap();
//        map.put("province",SharedPreferenceUtil.newInstance().getCity());
//        map.put("labelId",labId+"");
//        map.put("pageNum",pageIndex+"");
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        Observable<CircleDy> observable = accountService.getLabelsDy(map)
//                .map(new HttpResultFunc<CircleDy>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 关注的商家列表
//     */
//    public void selectMerchantByUser(int pageIndex,Subscriber<MerchantList> subscriber){
//        Map<String,String> map=getMap();
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        map.put("pageNum",pageIndex+"");
//        Observable<MerchantList> observable = accountService.selectMerchantByUser(map)
//                .map(new HttpResultFunc<MerchantList>());
//        toSubscribe(observable, subscriber);
//    }
//    /**
//     * 关注的商家动态
//     */
//    public void selectMerDynListByUser(int pageIndex,Subscriber<CircleDy> subscriber){
//        Map<String,String> map=getMap();
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        map.put("pageNum",pageIndex+"");
//        map.put("province", SharedPreferenceUtil.newInstance().getCity());
//        Observable<CircleDy> observable = accountService.selectMerDynListByUser(map)
//                .map(new HttpResultFunc<CircleDy>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 我关注的圈子
//     */
//    public void findMyCircle(Subscriber<List<CircleBean>> subscriber){
//        Map<String,String> map=getMap();
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        Observable<List<CircleBean>> observable = accountService.findMyCircle(map)
//                .map(new HttpResultFunc<List<CircleBean>>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 好友动态
//     */
//    public void selectMyFriendDyn(int pageIndex,Subscriber<CircleDy> subscriber){
//        Map<String,String> map=getMap();
//        map.put("pageNum",pageIndex+"");
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        Observable<CircleDy> observable = accountService.selectMyFriendDyn(map)
//                .map(new HttpResultFunc<CircleDy>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 发送动态
//     * @param content
//     * @param circleId 圈子ID，以“，”拼接
//     * @param imageList 图片路径，以“，”拼接
//     * @param subscriber
//     */
//    public void addDynamic(String content,String circleId,String imageList,Subscriber<MsgObj> subscriber){
//        Map<String,String> map=getMap();
//        map.put("dynamicContent",content);
//        map.put("circleIds",circleId);
//        map.put("imgList",imageList);
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        Observable<MsgObj> observable = accountService.addDynamic(map)
//                .map(new HttpResultFunc<MsgObj>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 首页热店22.53583  114.062067
//     */
//    public void getHomeHotMall(Subscriber<ListBean<Mall>> subscriber){
//        Map<String,String> map=getMap();
//        map.put("lat","22.53583");
//        map.put("lon","114.062067");
//        Observable<ListBean<Mall>> observable = accountService.getHomeHotMall(map)
//                .map(new HttpResultFunc<ListBean<Mall>>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 用户主页详情，也用于获取个人信息
//     */
//    public void selectUserInfo(String userId,Subscriber<UserInfo> subscriber){
//        Map<String,String> map=getMap();
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        map.put("friendId",userId);
//        Observable<UserInfo> observable = accountService.selectUserInfo(map)
//                .map(new HttpResultFunc<UserInfo>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 修改个人信息
//     */
//    public void modifyUserInfo(UserInfoBean usersBean, Subscriber<LoginResult> subscriber){
//        Map<String,String> map=getMap();
//        map.put("userId",SharedPreferenceUtil.newInstance().getUserId());
//        if (!TextUtils.isEmpty(usersBean.getNickname())){
//            map.put("nickname",usersBean.getNickname());
//        }
//        if (!TextUtils.isEmpty(usersBean.getGender())){
//            map.put("gender",usersBean.getGender());
//        }
//        if (!TextUtils.isEmpty(usersBean.getBirthday())){
//            map.put("birthday",usersBean.getBirthday());
//        }
//        if (!TextUtils.isEmpty(usersBean.getAutograph())){
//            map.put("autograph",usersBean.getAutograph());
//        }
//        if (!TextUtils.isEmpty(usersBean.getPicturePath())){
//            map.put("picturePath",usersBean.getPicturePath());
//        }
//        Observable<LoginResult> observable = accountService.modifyUserInfo(map)
//                .map(new HttpResultFunc<LoginResult>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * 获取门店信息
//     */
//    public void selectByShopId(int shopId,Subscriber<Shop> subscriber){
//        Map<String,String> map=getMap();
//        map.put("shopId",shopId+"");
//        Observable<Shop> observable = accountService.selectByShopId(map)
//                .map(new HttpResultFunc<>());
//        toSubscribe(observable, subscriber);
//    }
//
//    /**
//     * @param status 卡卷状态(0未上架,1上架中,2已经售完)
//     * 查找门店对应状态卡卷
//     */
//    public void selectCouponByStatus(int shopId,int status,Subscriber<List<Coupon>> subscriber){
//        Map<String,String> map=getMap();
//        map.put("shopId",shopId+"");
//        map.put("status",status+"");
//        Observable<List<Coupon>> observable = accountService.selectCouponByStatus(map)
//                .map(new HttpResultFunc<>());
//        toSubscribe(observable, subscriber);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    /*绑定银行卡接口*/
//    public void getCommitBankCard(Map<String,String> mp,Subscriber<ObjBean> subscriber){
//        Observable<ObjBean> observable = accountService.getCommitBankCard(mp);
//        toSubscribe(observable, subscriber);
//    }
//    /*•我的好友列表*/
//    public void getCommitBankCard(String uid,Subscriber<List<FriendBean>> subscriber){
//        Observable<List<FriendBean>> observable = accountService.getCommitBankCard(uid)
//                .map(new HttpResultFunc<List<FriendBean>>());;
//        toSubscribe(observable, subscriber);
//    }
//
//    /*添加好友*/
//    public void addFriend(int uid, int friendId,Subscriber<MsgObj> subscriber){
//        Observable<MsgObj> observable = accountService.addFriend(uid,friendId)
//                .map(new HttpResultFunc<MsgObj>());;
//        toSubscribe(observable, subscriber);
//    }
//


}