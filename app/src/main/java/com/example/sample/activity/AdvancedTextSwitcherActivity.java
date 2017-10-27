package com.example.sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.sample.R;
import com.example.sample.bean.BookBean;
import com.example.sample.util.DateUtils;
import com.example.sample.view.AutoScrollView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import sumimakito.android.advtextswitcher.AdvTextSwitcher;

import static com.example.sample.R.id.autoView;

public class AdvancedTextSwitcherActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    //    @Bind(R.id.recyclerView)
//    RecyclerView recyclerView;
    String[] strings;
    @Bind(R.id.autoView1)
    AutoScrollView autoView1;
    @Bind(R.id.autoView2)
    AutoScrollView autoView2;
    @Bind(R.id.autoView3)
    AutoScrollView autoView3;
    @Bind(R.id.autoView4)
    AutoScrollView autoView4;
    @Bind(R.id.autoView5)
    AutoScrollView autoView5;
    @Bind(R.id.autoView6)
    AutoScrollView autoView6;
    @Bind(R.id.autoView7)
    AutoScrollView autoView7;
    @Bind(R.id.autoView8)
    AutoScrollView autoView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_text_switcher);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        List<BookBean> list = DateUtils.getDate();
        strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i).getName();
        }
        autoView1.start(list);
        autoView2.start(list);
        autoView3.start(list);
        autoView4.start(list);
        autoView5.start(list);
        autoView6.start(list);
        autoView7.start(list);
        autoView8.start(list);
//        TextSwitcherAdapter adapter = new TextSwitcherAdapter(list);
//        recyclerView.setLayoutManager(new CenterLayoutManager(this) {
//            @Override
//            public boolean canScrollVertically() {
//                return true;
//            }
//        });
//        recyclerView.setAdapter(adapter);

//        new SwitcherRecycler(recyclerView,2000,adapter).start();


    }


    private class TextSwitcherAdapter extends BaseQuickAdapter<BookBean, BaseViewHolder> {

        public TextSwitcherAdapter(@Nullable List<BookBean> data) {
            super(R.layout.item_textswitcher, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, BookBean item) {
            AdvTextSwitcher advTextSwitcher = helper.getView(R.id.text);
            advTextSwitcher.setTexts(strings);
            advTextSwitcher.next();
            advTextSwitcher.previous();

            AutoScrollView autoScrollView = helper.getView(autoView);
            autoScrollView.start(DateUtils.getDate());

//            NoScrollRecyclerView recyclerView=helper.getView(R.id.recyclerView);
//            MainAdapter adapter=new MainAdapter(DateUtils.getDate());
//            recyclerView.setLayoutManager(new CenterLayoutManager(mContext){
//                @Override
//                public boolean canScrollVertically() {
//                    return true;
//                }
//            });
//            recyclerView.setAdapter(adapter);
//
//            if (recyclerView.getTag()==null) {
//                SwitcherRecycler switcherRecycler = new SwitcherRecycler(recyclerView, 2000, adapter);
//                switcherRecycler.start();
//                recyclerView.setTag(switcherRecycler);
//            }else {
//                SwitcherRecycler switcherRecycler= (SwitcherRecycler) recyclerView.getTag();
//
//            }

            //Auto switch between texts every 5000ms.
//            Switcher switcher = new Switcher(advTextSwitcher, 1000);
//            switcher.start();
//            //Pause
//            switcher.pause();
            //Or use switcher in only one line...
//            new Switcher().attach(advTextSwitcher).setDuration(5000).start();

            //Want to know which text is clicked?
            advTextSwitcher.setCallback(new AdvTextSwitcher.Callback() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(mContext, "ITEM@" + position + " Clicked!", Toast.LENGTH_SHORT).show();
                }
            });
        }


        @Override
        public int getItemCount() {
            return 10;
        }
    }
}
