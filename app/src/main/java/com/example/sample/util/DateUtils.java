package com.example.sample.util;

import android.support.v4.app.Fragment;

import com.example.sample.bean.BookBean;
import com.example.sample.fragment.MainFragment;
import com.example.sample.fragment.TabLayoutFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by 赖祖宏 on 2017/5/15.
 */

public class DateUtils {
    public static List<BookBean> getDate(){

        List<BookBean> list=new ArrayList<>();
        list.add(new BookBean("MoreFragmentActivity","789"));
        list.add(new BookBean("TabLayoutActivity","234"));
        list.add(new BookBean("TabHostActivity","234"));
        list.add(new BookBean("ViewPagerActivity","234"));
        list.add(new BookBean("ImageActivity","234"));
        list.add(new BookBean("BottomBehaviorActivity","234"));
        list.add(new BookBean("RecyclerViewActivity","234"));
        list.add(new BookBean("WebViewActivity","234"));
        list.add(new BookBean("FinestWebView","234"));
        list.add(new BookBean("VideoActivity","234"));
        list.add(new BookBean("UuidActivity","234"));
        list.add(new BookBean("HotFixActivity","234"));
        list.add(new BookBean("AppBarLayoutActivity","234"));
        list.add(new BookBean("ColorStatusBarActivity","234"));
        list.add(new BookBean("TopViewActivity","234"));
        list.add(new BookBean("BottomActivity","234"));
        list.add(new BookBean("pdfview","234"));
        list.add(new BookBean("AdvancedTextSwitcherActivity","234"));
        list.add(new BookBean("AutoScrollActivity","234"));
        list.add(new BookBean("RecyclerActivity","234"));
        list.add(new BookBean("TextActivity","234"));
        list.add(new BookBean("StockActivity","234"));
        list.add(new BookBean("SchoolActivity","234"));
        return list;
    }


    public static List<Fragment> getMainFragments(int count){
        List<Fragment> fragments=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fragments.add(new MainFragment());
        }
        return fragments;
    }
//    public static List<Fragment> getTableFragments(int count){
//        List<Fragment> fragments=new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            fragments.add(new TableFragment());
//        }
//        return fragments;
//    }

    public static List<Fragment> getTabLayoutFragments(int count){
        List<Fragment> fragments=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fragments.add(new TabLayoutFragment());
        }
        return fragments;
    }
}
