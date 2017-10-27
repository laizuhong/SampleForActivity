package com.example.sample.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;

import com.example.sample.R;
import com.example.sample.fragment.ImageFragment;
import com.example.sample.fragment.MainFragment;
import com.example.sample.view.FragmentTabHost;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MoreViewPagerActivity extends Fragment {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @Bind(android.R.id.tabhost)
    FragmentTabHost tabhost;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.contentLayout)
    FrameLayout contentLayout;
    @Bind(R.id.scrollview)
    NestedScrollView scrollview;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_more_view_pager, container, false);
        ButterKnife.bind(this, view);

        tabhost.setup(getActivity(), getChildFragmentManager(), R.id.contentLayout);
        tabhost.getTabWidget().setDividerDrawable(null); // 去掉分割线

        for (int i = 0; i < mImages.length; i++) {
            // Tab按钮添加文字和图片
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(mFragmentTags[i]).setIndicator(getImageView(i));
            if (i == 3) {
                // 添加Fragment
                tabhost.addTab(tabSpec, ImageFragment.class, null);
            } else {
                // 添加Fragment
                tabhost.addTab(tabSpec, MainFragment.class, null);
            }
            // 设置Tab按钮的背景
            tabhost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.white);
        }
        return view;
    }


    // 获得图片资源
    private View getImageView(int index) {
        @SuppressLint("InflateParams")
        View view = getActivity().getLayoutInflater().inflate(R.layout.tab_item, null);
        ImageView imageView = view.findViewById(R.id.tab_iv_image);
        imageView.setImageResource(mImages[index]);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
