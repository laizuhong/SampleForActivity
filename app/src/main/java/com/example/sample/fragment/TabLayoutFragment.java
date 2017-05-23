package com.example.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sample.R;
import com.example.sample.adapter.PagerAdapter;
import com.example.sample.util.DateUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/5/17
 * 描述:
 */

public class TabLayoutFragment extends Fragment {



    @Bind(R.id.tabLayout)
    TabLayout tabLayout;

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabhost, null);
        ButterKnife.bind(this, view);
        PagerAdapter adapter = new PagerAdapter(getActivity().getSupportFragmentManager(), DateUtils.getMainFragments(4));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setOffscreenPageLimit(4);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
