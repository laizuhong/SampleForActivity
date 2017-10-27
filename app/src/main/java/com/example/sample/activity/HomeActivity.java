package com.example.sample.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sample.R;
import com.example.sample.adapter.MainAdapter;
import com.example.sample.bean.BookBean;
import com.example.sample.util.DateUtils;
import com.example.sample.util.SpeedyLinearLayoutManager;
import com.thefinestartist.finestwebview.FinestWebView;

import java.io.File;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 赖祖宏 on 2017/5/15.
 */

public class HomeActivity extends BaseActivity {
    @Bind(R.id.rv_content)
    RecyclerView rvContent;
    List<BookBean> list;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    MainAdapter adapter;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        list = DateUtils.getDate();
        adapter = new MainAdapter(list);


        rvContent.setLayoutManager(new SpeedyLinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        rvContent.setAdapter(adapter);


//        new SwitcherRecycler(rvContent,2000,adapter).start();

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                position--;
                switch (position) {
                    case -1:
                        startActivity(new Intent(HomeActivity.this, MoreFragmentActivity.class));
                        break;
                    case 0:
                        startActivity(new Intent(HomeActivity.this, TabLayoutActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(HomeActivity.this, TabHostActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(HomeActivity.this, ViewPagerActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(HomeActivity.this, ImageActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(HomeActivity.this, BottomBehaviorActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(HomeActivity.this, RecyclerViewActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(HomeActivity.this, WebViewActivity.class));
                        break;
                    case 7:
                        new FinestWebView.Builder(HomeActivity.this).show("https://www.fntv8.com/m/live/128542");
                        break;
                    case 8:
                        startActivity(new Intent(HomeActivity.this, VideoActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(HomeActivity.this, UuidActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(HomeActivity.this, HotFixActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(HomeActivity.this, AppBarLayoutActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(HomeActivity.this, ColorStatusBarActivity.class));
                        break;
                    case 13:
                        startActivity(new Intent(HomeActivity.this, TopViewActivity.class));
                        break;
                    case 14:
                        startActivity(new Intent(HomeActivity.this, BottomActivity.class));
                        break;
                    case 15:
                        startActivity(Intent.createChooser(getPdfFileIntent("/storage/emulated/0/Java并发编程实战 (1).pdf"), "Open pdf file"));
                        break;
                    case 16:
                        startActivity(new Intent(HomeActivity.this,AdvancedTextSwitcherActivity.class));
                        break;
                    case 17:
                        startActivity(new Intent(HomeActivity.this,AutoScrollActivity.class));
                        break;
                    case 18:
                        startActivity(new Intent(HomeActivity.this,RecyclerActivity.class));
                        break;
                    default:
                        adapter.notifyItemRemoved(position);
                        adapter.notifyItemRangeChanged(position, adapter.getData().size() - position);
                        break;
                }
            }
        });

    }


    @OnClick(R.id.fab)
    public void onViewClicked() {
        createSystemSwitcherShortCut(this);
    }

    public static void createSystemSwitcherShortCut(Context context) {
        final Intent addIntent = new Intent(
                "com.android.launcher.action.INSTALL_SHORTCUT");
        final Parcelable icon = Intent.ShortcutIconResource.fromContext(
                context, R.drawable.ic_account_box_black_24dp); // 获取快捷键的图标
        addIntent.putExtra("duplicate", false);
        final Intent myIntent = new Intent(context,
                HomeActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME,
                "2343456456");// 快捷方式的标题
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);// 快捷方式的图标
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, myIntent);// 快捷方式的动作
        context.sendBroadcast(addIntent);
    }

    //Android获取一个用于打开PDF文件的intent
    public Intent getPdfFileIntent( String path ){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        i.addCategory(Intent.CATEGORY_DEFAULT);
//        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
        Uri uri = Uri.fromFile(new File(path));
        i.setDataAndType(uri, "application/pdf");
        return i;
    }
}
