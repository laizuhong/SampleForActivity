package com.example.sample.bean;

public class HttpResult<T> {
    /**
     * message : ok
     * nu : 3384743553914
     * ischeck : 1
     * condition : F00
     * com : shentong
     * status : 200
     * state : 3
     * data : [{"time":"2018-11-14 18:53:30","ftime":"2018-11-14 18:53:30","context":"前台签收-已签收","location":""},{"time":"2018-11-14 14:40:21","ftime":"2018-11-14 14:40:21","context":"广东深圳福田文光分部-陈智强(18126238802,)-派件中","location":""},{"time":"2018-11-14 13:55:21","ftime":"2018-11-14 13:55:21","context":"已到达-广东深圳福田文光分部","location":""},{"time":"2018-11-14 09:41:50","ftime":"2018-11-14 09:41:50","context":"广东深圳转运中心-已发往-广东深圳福田文光分部","location":""},{"time":"2018-11-13 01:36:14","ftime":"2018-11-13 01:36:14","context":"浙江嘉兴转运中心-已装袋发往-广东深圳转运中心","location":""},{"time":"2018-11-12 22:58:53","ftime":"2018-11-12 22:58:53","context":"浙江嘉兴公司-已装袋发往-浙江嘉兴转运中心","location":""},{"time":"2018-11-12 22:56:17","ftime":"2018-11-12 22:56:17","context":"浙江嘉兴公司-已进行装袋扫描","location":""},{"time":"2018-11-12 22:56:17","ftime":"2018-11-12 22:56:17","context":"浙江嘉兴公司-已发往-浙江嘉兴转运中心","location":""},{"time":"2018-11-12 17:29:48","ftime":"2018-11-12 17:29:48","context":"浙江嘉兴中安营业部-中安发往总公司(15168348423,0573-83678582)-已收件","location":""},{"time":"2018-11-12 17:24:50","ftime":"2018-11-12 17:24:50","context":"浙江嘉兴中安营业部-麦包包茶园路仓(13865126616,)-已收件","location":""}]
     */

    private String message;
    private String nu;
    private String ischeck;
    private String condition;
    private String com;
    private String status;
    private String state;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
//    private boolean success;
//    private String errorCode;
//    private String resultMsg;
//    private T result;
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(String errorCode) {
//        this.errorCode = errorCode;
//    }
//
//    public String getResultMsg() {
//        return resultMsg;
//    }
//
//    public void setResultMsg(String resultMsg) {
//        this.resultMsg = resultMsg;
//    }
//
//    public T getResult() {
//        return result;
//    }
//
//    public void setResult(T result) {
//        this.result = result;
//    }
}
