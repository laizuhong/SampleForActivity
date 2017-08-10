package com.example.sample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sample.R;

public class BackFormatTitleView extends RelativeLayout {

    private TextView mTvTitle;
    private Context mContext;
    private ImageButton mIbtRight;
    private TextView mTvRight;
    private ImageButton mIbtLeft;
    private TextView mTvLeft;
    private TextView mTvTitle2;
    private View mVFilling;
//    private AppBarLayout appBarLayout;
//    private LinearLayout mLnlRoot;

    public BackFormatTitleView(Context context) {
        super(context);
        init(context, null);

    }

    public BackFormatTitleView(Context context, AttributeSet paramAttributeSet) {
        super(context, paramAttributeSet);
        init(context, paramAttributeSet);

    }

    public BackFormatTitleView(Context context, AttributeSet paramAttributeSet, int paramInt) {
        super(context, paramAttributeSet, paramInt);
        init(context, paramAttributeSet);

    }

    private ImageButton ibClose;
    private void init(Context context, AttributeSet attr) {
        mContext = context;

        LayoutInflater.from(context).inflate(R.layout.title_bar, this, true);
//        mVFilling = findViewById(R.id.v_filling);
////        mLnlRoot = (LinearLayout) findViewById(R.id.root);
//
//        mTvLeft = (TextView) findViewById(R.id.tv_title_left);
//        ibClose = (ImageButton)findViewById(R.id.ib_close);
//        mTvTitle = (TextView) findViewById(R.id.title);
//        mIbtRight = (ImageButton) findViewById(R.id.btn_next);
//        mTvRight = (TextView) findViewById(R.id.tv_title_next);
//        mIbtLeft = (ImageButton) findViewById(R.id.btn_back);
//        mTvTitle2 = (TextView) findViewById(R.id.title_2);
//        appBarLayout= (AppBarLayout) findViewById(R.id.appbar);

//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            StateListAnimator animator= AnimatorInflater.loadStateListAnimator(mContext, R.animator.appbar_elevation);
//            appBarLayout.setStateListAnimator(animator);
//        }

//        if (isInEditMode()) {
//            return;
//        }

//        mIbtLeft.setOnClickListener(new OnClickListener() {
//            private Method mHandler;
//            //FIXME 这里省事 直接写死onBack 后续有修改，请改变handlerName，或者参照View源码来根据属性获取反射的方法名
//            private String handlerName = "onBack";
//
//            @Override
//            public void onClick(View v) {
//                if (mHandler == null) {
//                    try {
//                        mHandler = getContext().getClass().getMethod(handlerName, View.class);
//                    } catch (NoSuchMethodException e) {
//                        Context context1 = getContext();
//                        if (context1 instanceof Activity) {
//                            QLog.d(TAG, "context has no such method. use default backIcon Onclick!!!");
//                            ((Activity) context1).onBackPressed();
//                        }
//                        return;
//                    }
//                }
//                try {
//                    mHandler.invoke(getContext(), BackFormatTitleView.this);
//                } catch (Exception e) {
//                    Context context1 = getContext();
//                    if (context1 instanceof Activity) {
//                        QLog.d(TAG, "Exception when invoke, use default backIcon Onclick!!!");
//                        ((Activity) context1).onBackPressed();
//                    }
//                }
//            }
//        });
//
////        mLnlRoot.setFitsSystemWindows(false);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mVFilling.getLayoutParams();
//            layoutParams.height = DisplayUtil.getStatusBarHeight(mContext);
//            mVFilling.setLayoutParams(layoutParams);
//            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT){
//                mVFilling.setBackgroundColor(ContextCompat.getColor(context,R.color.black));
//            }
//        }
//
//        TypedArray a = context.obtainStyledAttributes(attr, R.styleable.back_format_title);
////        TypedArray a = context.obtainStyledAttributes(attr, R.styleable.AppBarLayout,
////                0, R.style.Widget_Design_AppBarLayout);
//        int color = a.getColor(R.styleable.back_format_title_bg_color, getResources().getColor(R.color.MAIN));
//        //标题
//        String titleStr = a.getString(R.styleable.back_format_title_txt);
//        if (!TextUtils.isEmpty(titleStr)) {
//            mTvTitle.setText(titleStr);
//        } else {
//            mTvTitle.setText(R.string.app_name);
//        }
//        //是否直接使用返回按钮
//        boolean isBackIcon = a.getBoolean(R.styleable.back_format_title_is_back_icon, true);
//        mIbtLeft.setVisibility(isBackIcon ? VISIBLE : GONE);
//        //左边图标
//        Drawable rightIcon = a.getDrawable(R.styleable.back_format_title_icon_right);
//        if (null != rightIcon) {
//            mIbtRight.setVisibility(View.VISIBLE);
//            mIbtRight.setImageDrawable(rightIcon);
//        }
//        //右边图标
//        Drawable leftIcon = a.getDrawable(R.styleable.back_format_title_icon_left);
//        if (null != leftIcon) {
//            mIbtLeft.setVisibility(View.VISIBLE);
//            mIbtLeft.setImageDrawable(leftIcon);
//        }
//
//
//        a.recycle();
    }



    public void setTitleName(String s) {
        mTvTitle.setText(s);
    }

    public void setTitleName(int id) {
        mTvTitle.setText(id);
    }

    public void setRightBtn(int resId, OnClickListener l) {
        mTvRight.setVisibility(View.GONE);
        if (resId != -1) {
            mIbtRight.setImageResource(resId);
        }
        mIbtRight.setVisibility(View.VISIBLE);
        mIbtRight.setOnClickListener(l);
    }
    public void setLeftClose(OnClickListener l){
        ibClose.setVisibility(View.VISIBLE);
        ibClose.setOnClickListener(l);
    }

    public void setRightText(String s, OnClickListener l, int color) {
        mIbtRight.setVisibility(View.GONE);
        mTvRight.setVisibility(VISIBLE);
        if (s != null) {
            mTvRight.setText(s);
        }
        if (color != -1) {
            mTvRight.setTextColor(color);
        }
        if (l != null) {
            mTvRight.setOnClickListener(l);
        }
    }

    public void setLeftText(String s, OnClickListener l, int color) {
        mIbtLeft.setVisibility(View.GONE);
        mTvLeft.setVisibility(VISIBLE);
        if (s != null) {
            mTvLeft.setText(s);
        }
        if (color != -1) {
            mTvLeft.setTextColor(color);
        }
        if (l != null) {
            mTvLeft.setOnClickListener(l);
        }
    }

    public void setRightTextEnable(boolean enable) {
        mIbtRight.setEnabled(enable);
    }

    public void setLeftBtn(int resId, OnClickListener l) {
        mTvLeft.setVisibility(View.GONE);
        if (resId != -1) {
            mIbtLeft.setImageResource(resId);
        }
        mIbtLeft.setVisibility(View.VISIBLE);
        mIbtLeft.setOnClickListener(l);
    }

    public void setSecondaryTitleVisible(boolean visible) {
        mTvTitle2.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setSecondaryTitleText(CharSequence text) {
        mTvTitle2.setText(text);
    }


    public void setRightTextColor(int color){
        mTvRight.setTextColor(color);
    }
    public void setRightEnable(boolean b){
        mTvRight.setEnabled(b);
    }
}
