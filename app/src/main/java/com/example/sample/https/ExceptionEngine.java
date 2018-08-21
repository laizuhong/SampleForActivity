package com.example.sample.https;

import org.json.JSONException;

import java.io.FileNotFoundException;
import java.net.ConnectException;

import retrofit2.adapter.rxjava.HttpException;


/**
 *
 * Created by 赖祖宏 on 2018/4/11.
 */

public class ExceptionEngine {

    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static ApiException handleException(Throwable e){
        ApiException ex;
        if (e instanceof HttpException){             //HTTP错误
            HttpException httpException = (HttpException) e;
//            ex = new ApiException(null, ERROR.HTTP_ERROR);
            switch(httpException.code()){
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                    ex = new ApiException("404 NOT FOUND", ERROR.HTTP_ERROR);
                    break;
//                    ex.setResultMsg();
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex = new ApiException("网络异常", ERROR.HTTP_ERROR);//均视为网络错误
                    break;
            }
            return ex;
        }
        else if (e instanceof RuntimeException){    //服务器返回的错误
            RuntimeException resultException = (RuntimeException) e;
            ex = new ApiException(resultException.getMessage(), resultException.hashCode());
            return ex;
        }
        else if (e instanceof JSONException){
            ex = new ApiException("解析错误", ERROR.PARSE_ERROR);
            return ex;
        }else if(e instanceof ConnectException){
            ex = new ApiException("连接失败", ERROR.NETWORD_ERROR);
            return ex;
        }else if (e instanceof FileNotFoundException){
            ex = new ApiException("文件不存在", ERROR.FILE_NOT_FOUND);
            return ex;
        } else {
            ex = new ApiException("未知错误", ERROR.UNKNOWN);
            return ex;
        }
    }

    /**
     * 约定异常
     */

    public class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;
        /**
         * 文件不存在
         */
        public static final int FILE_NOT_FOUND = 1004;

    }
}

