package com.example.sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sample.R;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/7/20
 * 描述:
 */

public class AppBarLayoutActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbarlayout);
        WebView webView= (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("http://www.baidu.com");
    }
}
