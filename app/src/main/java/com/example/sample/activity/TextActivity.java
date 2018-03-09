package com.example.sample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sample.R;
import com.example.sample.util.DisplayUtil;
import com.example.sample.view.CollapsedTextView;
import com.example.sample.view.CollapsibleTextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextActivity extends AppCompatActivity {
    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.image)
    ImageView image;
    private String
            mShortText = "I lost my shoe.",
            mLongText = "I swirl, dip, leap and step, To the rhythmic, rolling, reverberating melody, Of gleaming copper, and polished bronze; A shivering note, long held in the air. The deep, monotonous, shivering song, of shining, gleaming, chiming bells. I must leave before the twelfth gong. Prepare my pumpkin. I lost my shoe.";

    @Bind(R.id.collapsibleTestView)
    CollapsibleTextView collapsibleTestView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsedTextView)
    CollapsedTextView collapsedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        collapsibleTestView.setFullString(mLongText);
        collapsibleTestView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TextActivity.this, "1", Toast.LENGTH_SHORT).show();
            }
        });
//        collapsibleTestView.setCollapsedText("全文");
        collapsedTextView.setShowText(mLongText);
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        if (image.getVisibility()==View.VISIBLE){
            animClose(image);
        }else {
            animOpen(image);
        }
    }


    private void animOpen(final  View view){
        ValueAnimator va = createDropAnim(view,0, DisplayUtil.dip2px(this,80));
        va.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                view.setVisibility(View.VISIBLE);
            }
        });
        va.start();
    }

    private void animClose(final  View view){
//        int origHeight = view.getHeight();
        ValueAnimator va = createDropAnim(view, DisplayUtil.dip2px(this,80),0);
        va.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }
        });
        va.start();
    }


    /**
     * 使用动画的方式来改变高度解决visible不一闪而过出现
     * @param view
     * @param start 初始状态值
     * @param end 结束状态值
     * @return
     */
    private ValueAnimator createDropAnim(final  View view,int start,int end) {
        ValueAnimator va = ValueAnimator.ofInt(start, end);
        va.setDuration(300);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();//根据时间因子的变化系数进行设置高度
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = value;
                view.setLayoutParams(layoutParams);//设置高度
                view.invalidate();
            }
        });
        return  va;
    }
}
