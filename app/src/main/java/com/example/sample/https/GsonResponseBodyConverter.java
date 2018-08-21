package com.example.sample.https;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 *
 * Created by Charles on 2016/3/17.
 */
class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        //httpResult 只解析result字段
//        LogUtils.e(response);
        try {
            JSONObject jsonObject=new JSONObject(response);
            if (jsonObject.getString("result").equals("")){
                jsonObject.put("result",null);
                response=jsonObject.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        HttpResult httpResult = gson.fromJson(response, HttpResult.class);
        //
//            if (!httpResult.isSuccess()) {
//                throw new ApiException(httpResult.getErrorCode(),httpResult.getMsg());
//            }
        if (response.equals("")){
            response=null;
        }
        return gson.fromJson(response, type);


    }
}
