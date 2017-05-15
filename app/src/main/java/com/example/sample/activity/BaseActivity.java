package com.example.sample.activity;

import android.support.v7.app.AppCompatActivity;

import com.example.sample.R;
import com.jaeger.library.StatusBarUtil;

/**
 *
 * Created by 赖祖宏 on 2017/5/15.
 */

public class BaseActivity extends AppCompatActivity{

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
}
