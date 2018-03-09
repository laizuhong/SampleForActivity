package com.example.sample.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;

import com.example.sample.R;
import com.example.sample.bean.City;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/12/29
 * 描述:
 */

public class SchoolActivity extends BaseActivity {
    @Bind(R.id.init)
    Button init;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.init)
    public void onViewClicked() {
        String s=getJson(this,"t_province.json");
        List<City> list=setData(s);
        for (City city : list) {
            Log.e("city",city.toString());
        }
    }


    public static String getJson(Context context, String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static List<City> setData(String str) {
        try {
            List<City> list=new ArrayList<>();
            JSONObject jsonObject=new JSONObject(str);
            JSONArray array = jsonObject.getJSONArray("RECORDS");
            int len = array.length();
            for (int i = 0; i < len; i++) {
                JSONObject object = array.getJSONObject(i);
                City city=new City();
                city.setId(object.optInt("id"));
                city.setName(object.optString("name"));
                list.add(city);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
