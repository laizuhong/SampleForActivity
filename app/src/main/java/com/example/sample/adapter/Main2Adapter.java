package com.example.sample.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.sample.R;
import com.example.sample.bean.BookBean;

import java.util.List;

/**
 *
 * Created by 赖祖宏 on 2017/5/15.
 */

public class Main2Adapter extends BaseQuickAdapter<BookBean,BaseViewHolder>{


    public Main2Adapter(@Nullable List<BookBean> data) {
        super(R.layout.item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookBean item) {
//        IconTextView iconTextView=helper.getView(R.id.textView);
//        iconTextView.setDrawable(ContextCompat.getDrawable(mContext,R.drawable.icon_home_title_article));
//        iconTextView.setText(item.getName());
//        iconTextView.addIcon();

        helper.setText(R.id.textView,item.getName());
    }
}
