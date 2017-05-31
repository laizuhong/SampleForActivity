package com.example.sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.Log;

import com.example.sample.R;
import com.example.sample.util.Utils;

import java.util.List;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/5/31
 * 描述:
 */

public class ImageActivity extends BaseActivity{
    String html="<p style=\"text-align:center\"><img src=\"http://p0.ifengimg.com/pmop/2017/0530/1D40B4198812BF897F3B5669CD6A999D899A899A_size29_w477_h676.jpeg\" class=\"\"></p>";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        String s= Html.fromHtml(html).toString();
        List<String> img= Utils.getImageUrl(s);
        if (img!=null){
            Log.e("imageActivity",img.toString());
        }
    }
}
