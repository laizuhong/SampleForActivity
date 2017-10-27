package com.example.sample.activity;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;

import com.example.sample.R;
import com.example.sample.adapter.PagerAdapter;
import com.example.sample.fragment.MainFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/8/16
 * 描述:
 */

public class MoreFragmentActivity extends BaseActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.scrollView)
    NestedScrollView scrollView;
//    @Bind(R.id.tab1)
//    TextView tab1;
//    @Bind(R.id.tab2)
//    TextView tab2;
//    @Bind(R.id.tab3)
//    TextView tab3;
//    @Bind(R.id.tab4)
//    TextView tab4;
//    @Bind(R.id.bottom_layout)
//    LinearLayout bottomLayout;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        scrollView.setFillViewport(true);
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new MainFragment());
        fragments.add(new MainFragment());
        fragments.add(new MainFragment());
        PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

    }



    @Override
    protected void setStatusBar() {
        super.setStatusBar();
    }

//    @OnClick({R.id.tab1, R.id.tab2, R.id.tab3, R.id.tab4})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.tab1:
//                viewPager.setCurrentItem(0);
//                break;
//            case R.id.tab2:
//                viewPager.setCurrentItem(1);
//                break;
//            case R.id.tab3:
//                viewPager.setCurrentItem(2);
//                break;
//            case R.id.tab4:
//                viewPager.setCurrentItem(3);
//                break;
//        }
//    }
}
