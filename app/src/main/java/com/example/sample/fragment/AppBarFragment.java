package com.example.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sample.R;
import com.example.sample.activity.MoreBarFragmentActivity;
import com.example.sample.view.IconTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import wu.seal.textwithimagedrawable.TextWithImageDrawable;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/8/25
 * 描述:
 */

public class AppBarFragment extends Fragment {
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    MoreBarFragmentActivity mActivity;
    @Bind(R.id.title)
    IconTextView textview;
    @Bind(R.id.text2)
    TextView text2;


    String text;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appbar, container, false);
        ButterKnife.bind(this, view);
        mActivity = (MoreBarFragmentActivity) getActivity();
        initToolbar("1234");



        text = "这是因为这些方法或者类是被Android SDK隐藏的，出于安全或者某些原因，这些API不能暴露给应用层的开发者，所以编译完成的android.jar包里会把这些API隐藏掉，而我们的A";


        textview.setDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.list_unselected));
        textview.setText(text);
//
//        text2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textview.setText(text);
//            }
//        });



//
//        SpannableString ss = new SpannableString(text+"000");
//        Drawable d = getResources().getDrawable(R.drawable.list_selected);
//        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
//        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
//
//        ss.setSpan(span, text.length(), text.length()+3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        text2.setText(ss);

        return view;
    }

    private void initDrawable(int drawablePadding, TextWithImageDrawable drawable, String mText, TextWithImageDrawable.Position position) {
        drawable.setText(mText);
        drawable.setImagePosition(position);
        drawable.setImagePadding(drawablePadding);
        drawable.setImageRes(R.drawable.list_selected);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public Toolbar initToolbar(int title) {
        AppCompatActivity mAppCompatActivity = mActivity;
        Toolbar toolbar = (Toolbar) mAppCompatActivity.findViewById(R.id.toolbar);
        mAppCompatActivity.setSupportActionBar(toolbar);
        ActionBar actionBar = mAppCompatActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        return toolbar;
    }

    public Toolbar initToolbar(CharSequence title) {
        AppCompatActivity mAppCompatActivity = (AppCompatActivity) mActivity;
//        Toolbar toolbar = (Toolbar) mAppCompatActivity.findViewById(R.id.toolbar);
        mAppCompatActivity.setSupportActionBar(toolbar);
        ActionBar actionBar = mAppCompatActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        return toolbar;
    }
}
