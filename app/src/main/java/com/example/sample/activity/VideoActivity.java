package com.example.sample.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sample.R;
import com.example.sample.adapter.PagerAdapter;
import com.example.sample.fragment.ImageFragment;
import com.example.sample.util.InputMethodUtils;
import com.example.sample.view.SendMsgDialog;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoActivity extends BaseActivity {

    @Bind(R.id.tv_msg)
    TextView tvMsg;
    @Bind(R.id.bottom_layout)
    RelativeLayout bottomLayout;
    @Bind(R.id.videoPlayer)
    StandardGSYVideoPlayer videoPlayer;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.scrollview)
    NestedScrollView scrollview;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.msg_layout)
    RelativeLayout msgLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        List<Fragment> list=new ArrayList<>();
        list.add(new ImageFragment());
        list.add(new ImageFragment());
        list.add(new ImageFragment());
        list.add(new ImageFragment());
        PagerAdapter pagerAdapter=new PagerAdapter(getSupportFragmentManager(),list);
        viewpager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewpager);
    }

    @OnClick(R.id.tv_msg)
    public void onViewClicked(View view) {
        SendMsgDialog sendMsgDialog=new SendMsgDialog(VideoActivity.this);
        sendMsgDialog.show();
        InputMethodUtils.showInputMethod(view);
//        Dialog dialog=new Dialog(VideoActivity.this);
//        dialog.show();
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View viewDialog = inflater.inflate(R.layout.dialog_send_msg, null);
//        Display display = this.getWindowManager().getDefaultDisplay();
//        int width = display.getWidth();
//        int height = display.getHeight();
////设置dialog的宽高为屏幕的宽高
//        ViewGroup.LayoutParams layoutParams = new  ViewGroup.LayoutParams(width, height);
//        dialog.setContentView(viewDialog, layoutParams);
//        msgLayout.setVisibility(View.VISIBLE);
    }
}
