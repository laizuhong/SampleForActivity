package com.example.sample.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.example.sample.R;
import com.example.sample.fragment.ImageFragment;
import com.example.sample.fragment.MainFragment;
import com.example.sample.util.StatusBarUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/8/16
 * 描述:
 */

public class MoreFragmentActivity extends BaseActivity {
//    @Bind(android.R.id.tabs)
//    TabWidget tabs;
//    @Bind(android.R.id.tabcontent)
//    FrameLayout tabcontent;
    @Bind(android.R.id.tabhost)
    com.example.sample.view.FragmentTabHost tabhost;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;

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
        setContentView(R.layout.activity_more_fragment);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
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
                tabhost.addTab(tabSpec, MainFragment.class, null);
            }
            // 设置Tab按钮的背景
            tabhost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.white);
        }

        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                switch (s) {
                    case "1":
                        appbar.setVisibility(View.VISIBLE);
//                        getSupportActionBar().show();
                        break;
                    case "2":
                        appbar.setVisibility(View.VISIBLE);
//                        getSupportActionBar().show();
                        break;
                    case "3":
                        appbar.setVisibility(View.VISIBLE);
//                        getSupportActionBar().show();
                        break;
                    case "4":
                        appbar.setVisibility(View.GONE);
//                        getSupportActionBar().hide();
                        break;
                }
//                StatusBarUtil.setColor(MoreFragmentActivity.this, ContextCompat.getColor(MoreFragmentActivity.this,R.color.colorAccent), 0);
            }
        });
    }

    // 获得图片资源
    private View getImageView(int index) {
        @SuppressLint("InflateParams")
        View view = getLayoutInflater().inflate(R.layout.tab_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_iv_image);
        imageView.setImageResource(mImages[index]);
        return view;
    }


    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTransparentForImageViewInFragment(this, appbar);
        super.setStatusBar();
    }
}
