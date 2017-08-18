package com.example.sample.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.example.sample.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/8/15
 * 描述:
 */

public class OpenAppActivity extends BaseActivity {
    @Bind(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_app);
        ButterKnife.bind(this);
        Intent i_getvalue = getIntent();
        String action = i_getvalue.getAction();

        if (Intent.ACTION_VIEW.equals(action)) {
            Uri uri = i_getvalue.getData();
            if (uri != null) {
                String name = uri.getQueryParameter("name");
                String age = uri.getQueryParameter("age");
                btn.setText(name+"   "+age);
            }
        }
    }
}
