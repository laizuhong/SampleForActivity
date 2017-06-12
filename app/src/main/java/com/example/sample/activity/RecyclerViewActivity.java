package com.example.sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.sample.R;
import com.example.sample.bean.BookBean;
import com.example.sample.util.DateUtils;
import com.example.sample.view.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/6/12
 * 描述:
 */

public class RecyclerViewActivity extends BaseActivity{
    MyRecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView= (MyRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter adapter=new RecyclerAdapter(DateUtils.getDate());
        recyclerView.setAdapter(adapter);


    }

    class RecyclerAdapter extends BaseQuickAdapter<BookBean,BaseViewHolder>{

        public RecyclerAdapter(@Nullable List<BookBean> data) {
            super(R.layout.item_recycler,data);
        }

        @Override
        protected void convert(BaseViewHolder helper, BookBean item) {
            RecyclerView recyclerView=helper.getView(R.id.recyclerView);
            List<BookBean> list=new ArrayList<>();
            list.add(item);
            list.add(item);
            list.add(item);
            list.add(item);
            list.add(item);
            list.add(item);
            ItemAdapter adapter=new ItemAdapter(list);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,true));
            recyclerView.setAdapter(adapter);
        }
    }


    class ItemAdapter extends BaseQuickAdapter<BookBean,BaseViewHolder>{

        public ItemAdapter(@Nullable List<BookBean> data) {
            super(R.layout.item_textview,data);
        }

        @Override
        protected void convert(BaseViewHolder helper, BookBean item) {
            helper.setText(R.id.id_index_gallery_item_text,item.getName());
        }
    }
}
