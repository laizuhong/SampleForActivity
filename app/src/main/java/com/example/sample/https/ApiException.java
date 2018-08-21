package com.example.sample.https;

/**
 *
 * Created by liukun on 16/3/10.
 */
public class ApiException extends RuntimeException {

    public static final int USER_NOT_EXIST = 100;
    public static final int WRONG_PASSWORD = 101;


    public String errorCode;
    public String resultMsg;
    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    public ApiException(String resultCode,String resultMsg) {
        super(getApiExceptionMessage(resultCode,resultMsg));
        setErrorCode(resultCode);
    }

    public ApiException(String resultMsg,int resultCode){
        super(getApiExceptionMessage(resultCode+"",resultMsg));
        setErrorCode(resultCode+"");
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     *
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(String code,String resultMsg){

//        LogUtils.e(resultMsg+"     "+code);
//        if (!TextUtils.isEmpty(resultMsg)){
//            //一定要继承QBaseActivity处理这个消息
//            EventBus.getDefault().post(new HttpMsgEvent(code,resultMsg));
//        }
//        if (!TextUtils.isEmpty(code)&&code.equals("u112")){//登录过期
//            for (Activity activity : Utils.getActivityList()) {
//                activity.finish();
//            }
//            ActivityUtils.startActivity(LoginActivity.class);
//        }
        return resultMsg;
    }
}

