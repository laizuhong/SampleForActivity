package com.example.sample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.sample.R;

public class CheckButtonView extends View {

    private boolean isCheck=false;
    private Paint circlePaint,roundPaint,textPaint,linePaint;
    private float textSize=60;
    private int progress=0;
    private Context context;
    private boolean mTickDrawing=false;


    private static final int DEF_DRAW_SIZE = 25;

    private Paint mTickPaint;
    private Point[] mTickPoints;
    private Path mTickPath;
    private int mWidth;

    private float mLeftLineDistance, mRightLineDistance, mDrewDistance;

    public CheckButtonView(Context context) {
        super(context);
        this.context=context;
        setUpClick();
        initPaint();
    }

    public CheckButtonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        setUpClick();
        initPaint();
    }

    public CheckButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        setUpClick();
        initPaint();
    }

    private void initPaint(){
        circlePaint=new Paint();
        circlePaint.setStrokeWidth(5);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(getResources().getColor(R.color.colorAccent));

        textPaint=new Paint();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setTextSize(textSize);
        textPaint.setColor(Color.WHITE);

        roundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        roundPaint.setColor(Color.WHITE);
        roundPaint.setStrokeWidth(dp2px(context, 5));
        //设置圆弧为空心
        roundPaint.setStyle(Paint.Style.STROKE);

        mTickPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTickPaint.setStyle(Paint.Style.STROKE);
        mTickPaint.setStrokeCap(Paint.Cap.ROUND);
        mTickPaint.setColor(Color.WHITE);

        mTickPath = new Path();
        mTickPoints = new Point[3];
        mTickPoints[0] = new Point();
        mTickPoints[1] = new Point();
        mTickPoints[2] = new Point();
    }

    private void setUpClick(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                isCheck=!isCheck;
                reSet();
            }
        });
    }

    private void reSet(){
        mTickDrawing = true;

        progress=0;
        mDrewDistance = !isCheck? (mLeftLineDistance + mRightLineDistance) : 0;
        drawTickDelayed();
//        invalidate();
    }


    private int center,center1;
    private int screenWidth,screenHeight;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        mWidth = getMeasuredWidth();

        mTickPoints[0].x = Math.round((float) getMeasuredWidth() / 30 * 7);
        mTickPoints[0].y = Math.round((float) getMeasuredHeight() / 30 * 14);
        mTickPoints[1].x = Math.round((float) getMeasuredWidth() / 30 * 13);
        mTickPoints[1].y = Math.round((float) getMeasuredHeight() / 30 * 20);
        mTickPoints[2].x = Math.round((float) getMeasuredWidth() / 30 * 22);
        mTickPoints[2].y = Math.round((float) getMeasuredHeight() / 30 * 10);

        mLeftLineDistance = (float) Math.sqrt(Math.pow(mTickPoints[1].x - mTickPoints[0].x, 2) +
                Math.pow(mTickPoints[1].y - mTickPoints[0].y, 2));
        mRightLineDistance = (float) Math.sqrt(Math.pow(mTickPoints[2].x - mTickPoints[1].x, 2) +
                Math.pow(mTickPoints[2].y - mTickPoints[1].y, 2));
        mTickPaint.setStrokeWidth(10);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        center=getMeasuredWidth()/2;
        screenHeight=getMeasuredHeight();
        screenWidth=getMeasuredWidth();
        center1 = center - getWidth() / 5;

        setMeasuredDimension(measureSize(widthMeasureSpec), measureSize(heightMeasureSpec));
    }
    private int measureSize(int measureSpec) {
        int defSize = dp2px(getContext(), DEF_DRAW_SIZE);
        int specSize = MeasureSpec.getSize(measureSpec);
        int specMode = MeasureSpec.getMode(measureSpec);

        int result = 0;
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                result = Math.min(defSize, specSize);
                break;
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = getWidth() / 2 - 5;

        Rect targetRect = new Rect(0, 0, screenHeight, screenWidth);
        Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();
        int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
        textPaint.setTextAlign(Paint.Align.CENTER);

        canvas.drawCircle(screenWidth / 2, screenHeight / 2, center, circlePaint);
        if (!isCheck){


            canvas.drawText("开启", targetRect.centerX(), baseline, textPaint);
        }else {

            progress+=5;
            float a= textSize-textSize/100*progress;
            textPaint.setTextSize(a);
            canvas.drawText("开启", targetRect.centerX(), baseline, textPaint);


            //定义的圆弧的形状和大小的界限
            RectF rectF = new RectF(center - radius -1, center - radius -1 ,center + radius + 1, center + radius + 1);

            //根据进度画圆弧
            canvas.drawArc(rectF, 235, -360 * progress / 100, false, roundPaint);


            if (progress>=100){
                drawTickPath(canvas);
                return;
            }
            //每隔10毫秒界面刷新
            postInvalidateDelayed(10);
        }
    }

    private void drawTickDelayed() {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mTickDrawing = true;
                postInvalidate();
            }
        }, 100);
    }

    private void drawTick(Canvas canvas) {
        if (mTickDrawing && isCheck) {
            drawTickPath(canvas);
        }
    }


    private void drawTickPath(Canvas canvas) {
        mTickPath.reset();
        // draw left of the tick
        if (mDrewDistance < mLeftLineDistance) {
            float step = (mWidth / 20.0f) < 3 ? 3 : (mWidth / 20.0f);
            mDrewDistance += step;
            float stopX = mTickPoints[0].x + (mTickPoints[1].x - mTickPoints[0].x) * mDrewDistance / mLeftLineDistance;
            float stopY = mTickPoints[0].y + (mTickPoints[1].y - mTickPoints[0].y) * mDrewDistance / mLeftLineDistance;

            mTickPath.moveTo(mTickPoints[0].x, mTickPoints[0].y);
            mTickPath.lineTo(stopX, stopY);
            canvas.drawPath(mTickPath, mTickPaint);

            if (mDrewDistance > mLeftLineDistance) {
                mDrewDistance = mLeftLineDistance;
            }
        } else {

            mTickPath.moveTo(mTickPoints[0].x, mTickPoints[0].y);
            mTickPath.lineTo(mTickPoints[1].x, mTickPoints[1].y);
            canvas.drawPath(mTickPath, mTickPaint);

            // draw right of the tick
            if (mDrewDistance < mLeftLineDistance + mRightLineDistance) {
                float stopX = mTickPoints[1].x + (mTickPoints[2].x - mTickPoints[1].x) * (mDrewDistance - mLeftLineDistance) / mRightLineDistance;
                float stopY = mTickPoints[1].y - (mTickPoints[1].y - mTickPoints[2].y) * (mDrewDistance - mLeftLineDistance) / mRightLineDistance;

                mTickPath.reset();
                mTickPath.moveTo(mTickPoints[1].x, mTickPoints[1].y);
                mTickPath.lineTo(stopX, stopY);
                canvas.drawPath(mTickPath, mTickPaint);

                float step = (mWidth / 20) < 3 ? 3 : (mWidth / 20);
                mDrewDistance += step;
            } else {
                mTickPath.reset();
                mTickPath.moveTo(mTickPoints[1].x, mTickPoints[1].y);
                mTickPath.lineTo(mTickPoints[2].x, mTickPoints[2].y);
                canvas.drawPath(mTickPath, mTickPaint);
            }
        }

        // invalidate
        if (mDrewDistance < mLeftLineDistance + mRightLineDistance) {
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    postInvalidate();
                }
            }, 10);
        }
    }


    private static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
