package com.example.sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.example.sample.R;
import com.example.sample.adapter.PagerAdapter;
import com.example.sample.fragment.MainFragment;
import com.example.sample.util.DateUtils;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 赖祖宏 on 2017/5/15.
 */

public class TabHostActivity extends BaseActivity {
    @Bind(R.id.navigationView)
    BottomNavigationView navigationView;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taghost);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new MainFragment());
        fragments.add(new MainFragment());
        fragments.add(new MainFragment());
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), DateUtils.getTableFragments(4)));
        navigationView.setUpWithViewPager(viewPager,
                new int[]{
                        R.color.white,
                        R.color.white,
                        R.color.white,
                        R.color.white},
                new int[]{
                        R.drawable.message_normal,
                        R.drawable.contacts_normal,
                        R.drawable.discovery_normal,
                        R.drawable.me_normal});

    }
}
