package com.example.sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.sample.R;
import com.example.sample.adapter.MainAdapter;
import com.example.sample.util.DateUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/7/31
 * 描述:
 */

public class TopViewActivity extends BaseActivity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.scrollView)
    NestedScrollView scrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_view);
        ButterKnife.bind(this);
        scrollView.setFillViewport(true);
        MainAdapter adapter = new MainAdapter(DateUtils.getDate());
        View headView= LayoutInflater.from(this).inflate(R.layout.view_head_top,null);
        adapter.addHeaderView(headView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
