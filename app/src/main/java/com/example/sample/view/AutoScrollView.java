package com.example.sample.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.sample.R;
import com.example.sample.adapter.MainAdapter;
import com.example.sample.bean.BookBean;
import com.example.sample.util.CenterLayoutManager;
import com.example.sample.util.SwitcherRecycler;

import java.util.List;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/10/18
 * 描述:
 */

public class AutoScrollView extends LinearLayout{

    private Context context;
    private NoScrollRecyclerView recyclerView;
    private SwitcherRecycler switcherRecycler;

    public AutoScrollView(Context context) {
        super(context);
        initView(context);
    }

    public AutoScrollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public AutoScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public AutoScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, Context context1) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context1;
        initView(context);
    }

    private void initView(Context context){
        this.context=context;
        LayoutInflater.from(context).inflate(R.layout.view_auto_scroll, this, true);
        recyclerView=findViewById(R.id.recyclerView);

    }


    public void start(List<BookBean> list){
        MainAdapter adapter=new MainAdapter(list);
        recyclerView.setLayoutManager(new CenterLayoutManager(context));
        recyclerView.setAdapter(adapter);
        switcherRecycler= new SwitcherRecycler(recyclerView,2000);
        switcherRecycler.setAdapter(adapter).start();
    }
}
