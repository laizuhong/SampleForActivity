package com.example.sample.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.sample.R;


/**
 * 作者：赖祖宏
 * 项目：qiniu
 * 时间：2017/7/19
 * 描述:
 */

public class TopicNameView extends View {

    private String topicName;
    private Context context;
    private Paint mPaint;
    private Bitmap bitmap;

    private int mViewWidth = 0;
    private int mViewHeight = 0;

    public TopicNameView(Context context) {
        super(context);
        init(context);
    }

    public TopicNameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TopicNameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    private void init(Context context){
        this.context=context;
        mPaint=new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_asking);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,mPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mViewWidth = getMeasuredWidth();
        mViewHeight = getMeasuredHeight();
    }
}
