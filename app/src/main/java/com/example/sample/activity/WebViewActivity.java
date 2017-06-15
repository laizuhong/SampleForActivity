package com.example.sample.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sample.R;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    View mCustomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view2);
        webView= (WebView) findViewById(R.id.web_view);

        WebSettings ws = webView.getSettings();
        /**
         *
         * setAllowFileAccess 启用或禁止WebView访问文件数据 setBlockNetworkImage 是否显示网络图像
         * setBuiltInZoomControls 设置是否支持缩放 setCacheMode 设置缓冲的模式
         * setDefaultFontSize 设置默认的字体大小 setDefaultTextEncodingName 设置在解码时使用的默认编码
         * setFixedFontFamily 设置固定使用的字体 setJavaSciptEnabled 设置是否支持Javascript
         * setLayoutAlgorithm 设置布局方式 setLightTouchEnabled 设置用鼠标激活被选项
         * setSupportZoom 设置是否支持变焦
         * */
        ws.setBuiltInZoomControls(true);// 隐藏缩放按钮
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);// 排版适应屏幕
        ws.setUseWideViewPort(true);// 可任意比例缩放
        ws.setLoadWithOverviewMode(true);// setUseWideViewPort方法设置webview推荐使用的窗口。setLoadWithOverviewMode方法是设置webview加载的页面的模式。
        ws.setSavePassword(true);
        ws.setSaveFormData(true);// 保存表单数据
        ws.setJavaScriptEnabled(true);
        ws.setGeolocationEnabled(true);// 启用地理定位
        ws.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");// 设置定位的数据库路径
        ws.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ws.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());


        webView.loadUrl("https://www.fntv8.com/m/live/128542");
//        webView.loadUrl("http://v.youku.com/v_show/id_XMjgyNDg3Mjk2MA==.html?spm=a2hww.20023042.m_223465.5~5~5~5~5!2~5~5~A");
    }





}
