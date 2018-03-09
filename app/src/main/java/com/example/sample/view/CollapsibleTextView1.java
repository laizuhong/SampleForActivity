package com.example.sample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sample.R;


/**
 * 作者：王勇钦
 * 时间：2017/4/25
 * 标题：
 * 描述：
 */

public class CollapsibleTextView1 extends LinearLayout implements
        View.OnClickListener {

    /** default text show max lines */
    private static final int DEFAULT_MAX_LINE_COUNT = 2;

    private static final int COLLAPSIBLE_STATE_NONE = 0;
    private static final int COLLAPSIBLE_STATE_SHRINKUP = 1;
    private static final int COLLAPSIBLE_STATE_SPREAD = 2;

    private TextView desc;

    private String shrinkup;
    private String spread;
    private int mState;
    private boolean flag;

    public CollapsibleTextView1(Context context, AttributeSet attrs) {
        super(context, attrs);

        View view = inflate(context, R.layout.collapsible_textview, this);
        view.setPadding(0, -1, 0, 0);
        desc = (TextView) view.findViewById(R.id.desc_tv);

    }

    public CollapsibleTextView1(Context context) {
        this(context, null);
    }

    public final void setDesc(CharSequence charSequence, TextView.BufferType bufferType) {
        desc.setText(charSequence, bufferType);
        mState = COLLAPSIBLE_STATE_SPREAD;
        requestLayout();
    }

    @Override
    public void onClick(View v) {
         flag = false;
        requestLayout();

    }
    private TextView textView;
    public void setClick(TextView textView){
         flag = false;
        this.textView = textView;
        requestLayout();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (!flag) {
            flag = true;
            if (desc.getLineCount() <= DEFAULT_MAX_LINE_COUNT) {
                mState = COLLAPSIBLE_STATE_NONE;

                desc.setMaxLines(DEFAULT_MAX_LINE_COUNT + 1);
            } else {
                post(new InnerRunnable());
            }
        }
    }

    class InnerRunnable implements Runnable {
        @Override
        public void run() {
            if (mState == COLLAPSIBLE_STATE_SPREAD) {
                desc.setMaxLines(DEFAULT_MAX_LINE_COUNT);
                if(textView!=null){
                    textView.setText("点击查看");
                }
                mState = COLLAPSIBLE_STATE_SHRINKUP;
            } else if (mState == COLLAPSIBLE_STATE_SHRINKUP) {
                desc.setMaxLines(Integer.MAX_VALUE);
                if(textView!=null){
                    textView.setText("点击收起");

                }
                mState = COLLAPSIBLE_STATE_SPREAD;
            }
        }
    }
}