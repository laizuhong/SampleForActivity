package com.example.sample.util;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * 作者：赖祖宏
 * 项目：qiniu
 * 时间：2017/10/16
 * 描述:
 */

public class SwitcherRecycler {
    private RecyclerView advTsView;
    private boolean isPaused;
    private BaseQuickAdapter adapter;
    private int mDuration = 1000;

    private int current=0;
    private int itemCount=0;

    public Handler hlUpdt = new Handler();
    public Runnable rbUpdt = new Runnable() {
        public void run() {
            if(!SwitcherRecycler.this.isPaused && SwitcherRecycler.this.advTsView != null) {
                SwitcherRecycler.this.advTsView.smoothScrollToPosition(current);
                current++;
                if (current>itemCount&&current%itemCount==2){
                    List list=adapter.getData();
                    adapter.addData(list);
//                    adapter.notifyItemRangeRemoved(0,list.size());
                }
                SwitcherRecycler.this.hlUpdt.postDelayed(this, (long)SwitcherRecycler.this.mDuration);
            }

        }
    };

    public SwitcherRecycler() {
    }

    public SwitcherRecycler(RecyclerView view, int duration) {
        this.advTsView = view;
        this.mDuration = duration;

    }

    public SwitcherRecycler setAdapter(BaseQuickAdapter adapter) {
        this.adapter = adapter;
        this.itemCount=adapter.getData().size();
        return this;
    }

    public SwitcherRecycler setDuration(int duration) {
        this.mDuration = duration;
        return this;
    }

    public SwitcherRecycler attach(RecyclerView view) {
        this.pause();
        this.advTsView = view;
        return this;
    }

    public void start() {
        this.isPaused = false;
        if (itemCount<=3){
            return;
        }
        if(this.advTsView != null) {

            this.hlUpdt.postDelayed(this.rbUpdt, (long)this.mDuration);
        }

    }

    public void pause() {
        this.isPaused = true;
    }
}
