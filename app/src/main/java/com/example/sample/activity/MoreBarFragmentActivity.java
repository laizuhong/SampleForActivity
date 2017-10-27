package com.example.sample.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;

import com.example.sample.R;
import com.example.sample.fragment.AppBarFragment;
import com.example.sample.fragment.ImageFragment;
import com.example.sample.view.FragmentTabHost;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/8/25
 * 描述:
 */

public class MoreBarFragmentActivity extends BaseActivity {
    @Bind(R.id.contentLayout)
    FrameLayout contentLayout;
    @Bind(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @Bind(android.R.id.tabhost)
    FragmentTabHost tabhost;


    // 图片
    @DrawableRes
    private int mImages[] = {
            R.drawable.icon_home_red,
            R.drawable.icon_home_me_red,
            R.drawable.icon_home_hang_red,
            R.drawable.ic_home_dy_red
    };

    // 标题
    private String mFragmentTags[] = {
            "1",
            "2",
            "3",
            "4"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_fragment);
        ButterKnife.bind(this);


        tabhost.setup(this, getSupportFragmentManager(), R.id.contentLayout);
        tabhost.getTabWidget().setDividerDrawable(null); // 去掉分割线

        for (int i = 0; i < mImages.length; i++) {
            // Tab按钮添加文字和图片
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(mFragmentTags[i]).setIndicator(getImageView(i));
            if (i==3){
                // 添加Fragment
                tabhost.addTab(tabSpec, ImageFragment.class, null);
            }else {
                // 添加Fragment
                tabhost.addTab(tabSpec, AppBarFragment.class, null);
            }
            // 设置Tab按钮的背景
            tabhost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.white);
        }

    }
    // 获得图片资源
    private View getImageView(int index) {
        @SuppressLint("InflateParams")
        View view = getLayoutInflater().inflate(R.layout.tab_item, null);
        ImageView imageView =view.findViewById(R.id.tab_iv_image);
        imageView.setImageResource(mImages[index]);
        return view;
    }


    @Override
    protected void setStatusBar() {
        super.setStatusBar();

    }
}
