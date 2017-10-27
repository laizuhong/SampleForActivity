package com.example.sample.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;


/**
 * 作者：赖祖宏
 * 项目：qiniu
 * 时间：2017/8/22
 * 描述:
 */

public class IconTextView extends AppCompatTextView{
    Context context;
    public IconTextView(Context context) {
        super(context);
        this.context=context;
    }

    public IconTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public IconTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
//        resize();

        addIcon();
    }

    Drawable drawable;
    boolean flag=false;

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }


    @Override
    public ViewTreeObserver getViewTreeObserver() {
        if (!flag){
            addIcon();
        }
        return super.getViewTreeObserver();
    }

    int picWitch=1;
   public void addIcon(){
       String text=getText().toString();
       if (TextUtils.isEmpty(text)){
           return;
       }
       int textLength=text.length();
       Layout layout=getLayout();
       if (layout==null)return;
       int lineEnd1=layout.getLineEnd(0);
       float max= layout.getLineMax(0);
       int lineEnd2= layout.getLineEnd(1);

       int line=getLayout().getLineCount();
       SpannableString spanString = new SpannableString(text+"  ");
       Drawable d= drawable;
       d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
       ImageSpan imageSpan = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
       flag=true;
       int start;
       if (line==1){
           float right=layout.getLineRight(0);
           if (right<10){
               start=textLength-picWitch;
               spanString.setSpan(imageSpan, start, textLength, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
               setText(spanString);
               return;
           }else {
               start=text.length();
           }
       }else {
           if (lineEnd2-lineEnd1<lineEnd1){
               start=Math.round(lineEnd2)-picWitch;
               spanString.setSpan(imageSpan, start, textLength, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
               setText(spanString);
               return;
           }else {
               start=Math.round(lineEnd1*2-picWitch);
           }
       }

       spanString.setSpan(imageSpan, start, start+picWitch, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
       setText(spanString);
   }

    /**
     * 去除当前页无法显示的字
     * @return 去掉的字数
     */
    public int resize() {
        CharSequence oldContent = getText();
        CharSequence newContent = oldContent.subSequence(0, getCharNum());
        setText(newContent);
        return oldContent.length() - newContent.length();
    }

    /**
     * 获取当前页总字数
     */
    public int getCharNum() {
        return getLayout().getLineEnd(getLineNum());
    }

    /**
     * 获取当前页总行数
     */
    public int getLineNum() {
        Layout layout = getLayout();
        int topOfLastLine = getHeight() - getPaddingTop() - getPaddingBottom() - getLineHeight();
        return layout.getLineForVertical(topOfLastLine);
    }
}
