package com.example.sample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.example.sample.R;
import com.example.sample.view.MineScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AutoScrollActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.mine)
    MineScrollView mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_scroll);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {

        mine.add();
//        mAnimator = ValueAnimator.ofFloat(0, 100);
//        mAnimator.setDuration(1000);
//        mAnimator.setInterpolator(new LinearInterpolator());
//        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//
//            }
//        });
//        mAnimator.start();
    }
}
