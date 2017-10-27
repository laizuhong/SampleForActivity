package com.example.sample.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sample.R;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/10/19
 * 描述:
 */

public class MineScrollView extends LinearLayout{
    private Context context;
    private LayoutInflater layoutInflater;
    private int offset,mOffset;
    private ValueAnimator mAnimator;
    private int current=1;
    private Handler handler;
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            newline();
            Log.e("run",current+"");
            current++;
            handler.postDelayed(runnable,2000);
        }
    };

    private RecyclerScrollview scrollView;
    private LinearLayout layout;


    public MineScrollView(Context context) {
        super(context);
        initView(context);
    }

    public MineScrollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MineScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

//    public MineScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        initView(context);
//    }

    private void initView(Context context){
        this.context=context;
//        setOrientation(VERTICAL);

        layoutInflater=LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.auto_scroll_view,this,true);
        scrollView=findViewById(R.id.scrollView);
        layout=findViewById(R.id.parentView);

        handler=new Handler();
        for (int i=0;i<10;i++) {
            View view = layoutInflater.inflate(R.layout.item_view_home_hot_live_item, null);

            TextView textView=view.findViewById(R.id.text);
            textView.setText(i+"");
            layout.addView(view);
            if (offset==0){
                view.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                offset=view.getMeasuredHeight();
            }
        }

//        runOnUi(runnable);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        offset=getViewHeight(view);
//    }
//
//    //高
//    public int getViewHeight(LinearLayout view){
//        view.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        return view.getMeasuredHeight();
//    }

    /**
     * 换行动画<br>
     * 属性动画只能在主线程使用
     */
    public void newline() {
        endAnimation();

//        int offset = getOffset(line);

        Log.e("ValueAnimator",mOffset+"   "+offset);
        mAnimator = ValueAnimator.ofInt(0, 100);
        mAnimator.setDuration(1000);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mOffset = (int) animation.getAnimatedValue();
//                invalidate();
                Log.e("onAnimationUpdate",mOffset+"");
                scrollBy(0,mOffset);
            }
        });
        mAnimator.start();

    }

    public void add(){
//        View view = layoutInflater.inflate(R.layout.item_view_home_hot_live_item, null);
//
//        TextView textView=view.findViewById(R.id.text);
//        textView.setText("add");
//        layout.addView(view);
        scrollView.scrollTo(offset*(current-1),offset*current);
    }

    private void endAnimation() {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.end();
        }
    }


    private void runOnUi(Runnable r) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r.run();
        } else {
            post(r);
        }
    }
}
