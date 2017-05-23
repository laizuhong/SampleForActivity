package com.example.sample.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.sample.R;
import com.example.sample.adapter.PagerAdapter;
import com.example.sample.util.DateUtils;
import com.example.sample.view.WrapContentHeightViewPager;
import com.jaeger.library.StatusBarUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TabLayoutActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.viewpager)
    WrapContentHeightViewPager viewpager;
    @Bind(R.id.scrollview)
    NestedScrollView scrollview;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), DateUtils.getMainFragments(4));
        viewpager.setAdapter(adapter);
        tabs.setupWithViewPager(viewpager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

        toolbar.setTitle("");

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    toolbar.setBackgroundResource(R.drawable.shape_toolbar);
                    collapsingToolbarLayout.setTitle("测试");
                } else {
                    toolbar.setBackgroundResource(android.R.color.transparent);
                    collapsingToolbarLayout.setTitle("");
                }
            }
        });




    }

    @Override
    protected void setStatusBar() {
        super.setStatusBar();
        StatusBarUtil.setTranslucentForImageView(this, collapsingToolbarLayout);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
