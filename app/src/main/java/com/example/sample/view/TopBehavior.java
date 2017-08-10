package com.example.sample.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.sample.util.DisplayUtil;

/**
 *
 * Created by 赖祖宏 on 2017/5/15.
 */

public class TopBehavior extends CoordinatorLayout.Behavior<View>{

    private final int MinWidth = 300;
    private final int MaxWidth = 450;

    private float minHeight;

    private float start=0;
    private float old=0;
    private boolean flag=true;

    public TopBehavior() {
    }

    public TopBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        minHeight= DisplayUtil.dip2px(context,48)+10;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }


    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
//        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        int followScrolled = target.getScrollY();
//        Log.e("setBigersetBigerger","onNestedScroll    "+followScrolled);
        setBiger(child, followScrolled);
    }

    private void setBiger(View v, int y) {

        if (flag){//向下滑
            if (y<old){
                start=y;
                flag=false;
            }
            old=y;
        }else {//向上滑
            if (y>old){
                start=y;
                flag=true;
            }
            old=y;
        }
        float off = v.getTranslationY();

        float my=y-start;
        Log.e("cccccc","off=  "+ off+"        "+my);
//        if (my!=0){
            if (my>0&& off >-minHeight){
                Log.e("aaaaaaaaa","my=  "+my);
                v.setTranslationY(-my);
            }else {

//                if (my<-minHeight){
//                    return;
//                }
                if (off >=0){
                    v.setTranslationY(0);
                    return;
                }
                float i=-minHeight-my;
                Log.e("bbbbbbb","my=  "+i);
                v.setTranslationY(i);
            }

//        }
//        v.setLayoutParams(layoutParams);
    }



}
