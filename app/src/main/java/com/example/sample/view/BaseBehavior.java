package com.example.sample.view;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * Created by 赖祖宏 on 2017/5/15.
 */

public class BaseBehavior extends CoordinatorLayout.Behavior{
    public BaseBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int y=dependency.getTop();
        child.setTranslationY(-y);
        return true;
    }
}
