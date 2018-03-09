package com.example.sample.util;

import android.os.Handler;

import sumimakito.android.advtextswitcher.AdvTextSwitcher;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/11/6
 * 描述:
 */

public class SwitcherText {
    private AdvTextSwitcher advTsView;
    private boolean isPaused;
    private int mDuration = 1000;
    private static final int MESSAGE_MOVE=222;

    private Handler handler;
    public Runnable runnable = new Runnable() {
        public void run() {
            if(!SwitcherText.this.isPaused && SwitcherText.this.advTsView != null) {
                SwitcherText.this.advTsView.next();
                SwitcherText.this.handler.postDelayed(this, (long)SwitcherText.this.mDuration);
            }

        }
    };

    public SwitcherText() {
    }

    public SwitcherText(AdvTextSwitcher view, int duration) {
        this.advTsView = view;
        this.mDuration = duration;

    }

    public SwitcherText setDuration(int duration) {
        this.mDuration = duration;
        return this;
    }

    public SwitcherText attach(AdvTextSwitcher view) {
        this.pause();
        this.advTsView = view;
        return this;
    }

    public void start() {
        this.isPaused = false;
        if(this.advTsView != null) {
            this.handler.postDelayed(this.runnable, (long)this.mDuration);
        }

    }

    public void pause() {
        this.isPaused = true;
    }
}
