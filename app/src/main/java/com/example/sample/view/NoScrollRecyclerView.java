package com.example.sample.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 作者：赖祖宏
 * 项目：qiniu
 * 时间：2017/10/18
 * 描述:
 */

public class NoScrollRecyclerView extends RecyclerView {
    private int startX;
    private int startY;
    public NoScrollRecyclerView(Context context) {
        super(context);
    }

    public NoScrollRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                startX= (int) ev.getX();
                startY= (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:

                int dX= (int) (ev.getX()-startX);
                int dY= (int) (ev.getY()-startX);
                if(Math.abs(dX)> Math.abs(dY)){//左右滑动
                    return false;
                }else {//上下滑动
                    return false;
                }
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
