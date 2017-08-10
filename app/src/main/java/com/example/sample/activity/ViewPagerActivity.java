package com.example.sample.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.sample.R;
import com.example.sample.fragment.TabLayoutFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/5/19
 * 描述:
 */

public class ViewPagerActivity extends BaseActivity {
    @Bind(R.id.buttonView)
    BottomNavigationView buttonView;
//    @Bind(R.id.viewPager)
//    ViewPager viewPager;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    TabLayoutFragment fragment1,fragment2,fragment3,fragment4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
//        List<Fragment> fragments = new ArrayList<>();
//        fragments.add(new MainFragment());
//        fragments.add(new MainFragment());
//        fragments.add(new MainFragment());
//        fragments.add(new MainFragment());
//        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), DateUtils.getTabLayoutFragments(4)));

//        buttonView.setUpWithViewPager(viewPager,
//                new int[]{
//                        R.color.white,
//                        R.color.white,
//                        R.color.white,
//                        R.color.white},
//                new int[]{
//                        R.drawable.message_normal,
//                        R.drawable.contacts_normal,
//                        R.drawable.discovery_normal,
//                        R.drawable.me_normal});


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment4 = new TabLayoutFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment4);
        transaction.commit();


        buttonView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home1:
                        switchFragment(1);
                        break;
                    case R.id.home2:
                        switchFragment(2);
                        break;
                    case R.id.home3:
                        switchFragment(3);
                        break;
                    case R.id.home4:
                        switchFragment(4);
                        break;
                }
                return true;
            }
        });

    }

    private void switchFragment(int position){
        FragmentManager fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (fragment1 == null) {
                    fragment1=new TabLayoutFragment();
                }
                transaction.replace(R.id.fragment_container, fragment1);
                break;
            case 1:
                if (fragment2 == null) {
                    fragment2=new TabLayoutFragment();
                }
                transaction.replace(R.id.fragment_container, fragment2);
                break;
            case 2:
                if (fragment3 == null) {
                    fragment3=new TabLayoutFragment();
                }
                transaction.replace(R.id.fragment_container, fragment3);
                break;
            case 3:
                if (fragment4 == null) {
                    fragment4=new TabLayoutFragment();
                }
                transaction.replace(R.id.fragment_container, fragment4);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }



//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        @StringRes int text;
//        switch (item.getItemId()) {
//            case R.id.recents:
//                text = R.string.recents;
//                break;
//            case R.id.favourites:
//                text = R.string.favourites;
//                break;
//            case R.id.nearby:
//                text = R.string.nearby;
//                break;
//            default:
//                return false;
//        }
//        switchFragmentText(text);
//        return true;
//    }
//
//    private void switchFragmentText(@StringRes int text) {
//        fragment.setText(text);
//    }


}
