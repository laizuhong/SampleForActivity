package com.example.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sample.R;
import com.example.sample.adapter.MainAdapter;
import com.example.sample.bean.BookBean;
import com.example.sample.util.DateUtils;
import com.thefinestartist.finestwebview.FinestWebView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 赖祖宏 on 2017/5/15.
 */

public class HomeActivity extends AppCompatActivity {
    @Bind(R.id.rv_content)
    RecyclerView rvContent;
    List<BookBean> list;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        list= DateUtils.getDate();
        MainAdapter adapter = new MainAdapter(list);
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(HomeActivity.this,TabLayoutActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(HomeActivity.this,TabHostActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(HomeActivity.this,ViewPagerActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(HomeActivity.this,ImageActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(HomeActivity.this,BottomBehaviorActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(HomeActivity.this,RecyclerViewActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(HomeActivity.this,WebViewActivity.class));
                        break;
                    case 7:
                        new FinestWebView.Builder(HomeActivity.this).show("https://www.fntv8.com/m/live/128542");
                        break;
                    default:
                        adapter.notifyItemRemoved(position);
                        adapter.notifyItemRangeChanged(position,adapter.getData().size()-position);
                        break;
                }
            }
        });

    }


}
