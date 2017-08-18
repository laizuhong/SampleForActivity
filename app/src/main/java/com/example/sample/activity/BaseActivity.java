package com.example.sample.activity;

import android.support.v7.app.AppCompatActivity;

import com.example.sample.util.StatusBarUtil;


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
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT&&Build.VERSION.SDK_INT<=Build.VERSION_CODES.N) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
//        Window window=getWindow();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // 5.0 以上全透明状态栏
//            //6.0 以上可以设置状态栏的字体为黑色.使用下面注释的这行打开亮色状态栏模式,实现黑色字体,白底的需求用这句setStatusBarColor(Color.WHITE);
//            window.getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){//4.4 全透明状态栏
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.white));
//        StatusBarUtil.StatusBarLightMode(this);


        StatusBarUtil.StatusBarLightMode(this);
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        StatusBarUtil.setColor(this, ContextCompat.getColor(this,R.color.white), 0);
//    }
}
