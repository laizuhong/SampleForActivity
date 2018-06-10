package com.example.sample.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sample.R;
import com.example.sample.adapter.PagerAdapter;
import com.example.sample.fragment.ImageFragment;
import com.example.sample.util.InputMethodUtils;
import com.example.sample.view.DanmakuVideoPlayer;
import com.example.sample.view.SendMsgDialog;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

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
    @Bind(R.id.danmaku_video)
    DanmakuVideoPlayer danmakuVideoPlayer;

    private OrientationUtils orientationUtils;
    private boolean isPlay;
    private boolean isPause;
    private boolean isDestory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setFullScreen(true);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

//        StatusBarUtil.setTransparentForImageView(this,danmakuVideoPlayer);

        List<Fragment> list = new ArrayList<>();
        list.add(new ImageFragment());
        list.add(new ImageFragment());
        list.add(new ImageFragment());
        list.add(new ImageFragment());
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewpager);



        //使用自定义的全屏切换图片，!!!注意xml布局中也需要设置为一样的
        //必须在setUp之前设置
        danmakuVideoPlayer.setShrinkImageRes(R.drawable.custom_shrink);
        danmakuVideoPlayer.setEnlargeImageRes(R.drawable.custom_enlarge);

        //String url = "https://res.exexm.com/cw_145225549855002";
        String url = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
        //String url = "https://res.exexm.com/cw_145225549855002";
        danmakuVideoPlayer.setUp(url, true, null, "测试视频");

//        resolveNormalVideoUI();

        //外部辅助的旋转，帮助全屏
        orientationUtils = new OrientationUtils(this, danmakuVideoPlayer);
        //初始化不打开外部的旋转
        orientationUtils.setEnable(false);

        danmakuVideoPlayer.setIsTouchWiget(true);
        //关闭自动旋转
        danmakuVideoPlayer.setRotateViewAuto(false);
        danmakuVideoPlayer.setLockLand(false);
        danmakuVideoPlayer.setShowFullAnimation(false);
        danmakuVideoPlayer.setNeedLockFull(true);

        //detailPlayer.setOpenPreView(true);
        danmakuVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                orientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                danmakuVideoPlayer.startWindowFullscreen(VideoActivity.this, true, true);
            }
        });

        danmakuVideoPlayer.setVideoAllCallBack(new GSYSampleCallBack() {
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                //开始播放了才能旋转和全屏
                orientationUtils.setEnable(true);
                isPlay = true;
            }

            @Override
            public void onAutoComplete(String url, Object... objects) {
                super.onAutoComplete(url, objects);
            }

            @Override
            public void onClickStartError(String url, Object... objects) {
                super.onClickStartError(url, objects);
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                super.onQuitFullscreen(url, objects);
                if (orientationUtils != null) {
                    orientationUtils.backToProtVideo();
                    setFullScreen(true);
                }
            }
        });

        danmakuVideoPlayer.setLockClickListener(new LockClickListener() {
            @Override
            public void onClick(View view, boolean lock) {
                if (orientationUtils != null) {
                    //配合下方的onConfigurationChanged
                    orientationUtils.setEnable(!lock);
                }
            }
        });
    }

    @OnClick(R.id.tv_msg)
    public void onViewClicked(View view) {
        SendMsgDialog sendMsgDialog = new SendMsgDialog(VideoActivity.this);
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
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void onBackPressed() {

        if (orientationUtils != null) {
            orientationUtils.backToProtVideo();
        }

        if (GSYVideoManager.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();
        getCurPlay().onVideoPause();
        isPause = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCurPlay().onVideoResume();
        isPause = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isPlay) {
            getCurPlay().release();
        }
        //GSYPreViewManager.instance().releaseMediaPlayer();
        if (orientationUtils != null)
            orientationUtils.releaseListener();

        isDestory = true;
    }

//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        //如果旋转了就全屏
//        if (isPlay && !isPause) {
//            danmakuVideoPlayer.onConfigurationChanged(this, newConfig, orientationUtils, true, true);
//        }
//    }

    private void resolveNormalVideoUI() {
        //增加title
        danmakuVideoPlayer.getTitleTextView().setVisibility(View.GONE);
        danmakuVideoPlayer.getBackButton().setVisibility(View.GONE);
    }

    private GSYVideoPlayer getCurPlay() {
        if (danmakuVideoPlayer.getFullWindowPlayer() != null) {
            return  danmakuVideoPlayer.getFullWindowPlayer();
        }
        return danmakuVideoPlayer;
    }

    private void setFullScreen(boolean enable) {
        if (enable) {
            WindowManager.LayoutParams attrs = getWindow().getAttributes();
            attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(attrs);
        } else {
            WindowManager.LayoutParams attrs = getWindow().getAttributes();
            attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(attrs);
        }
    }

}
