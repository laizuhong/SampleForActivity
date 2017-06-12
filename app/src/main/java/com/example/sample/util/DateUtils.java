package com.example.sample.util;

import android.support.v4.app.Fragment;

import com.example.sample.bean.BookBean;
import com.example.sample.fragment.MainFragment;
import com.example.sample.fragment.TabLayoutFragment;
import com.example.sample.fragment.TableFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by 赖祖宏 on 2017/5/15.
 */

public class DateUtils {
    public static List<BookBean> getDate(){

        List<BookBean> list=new ArrayList<>();
        list.add(new BookBean("TabLayoutActivity","234"));
        list.add(new BookBean("TabHostActivity","234"));
        list.add(new BookBean("ViewPagerActivity","234"));
        list.add(new BookBean("ImageActivity","234"));
        list.add(new BookBean("BottomBehaviorActivity","234"));
        list.add(new BookBean("RecyclerViewActivity","234"));
        list.add(new BookBean("assdf","234"));
        list.add(new BookBean("asddff","234"));
        list.add(new BookBean("asfgdf","234"));
        list.add(new BookBean("aswghdf","234"));
        list.add(new BookBean("assxxcvdgdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asfgcbdf","234"));
        list.add(new BookBean("asgdfdf","234"));
        list.add(new BookBean("adfsdf","234"));
        list.add(new BookBean("ascvdfbdf","234"));
        list.add(new BookBean("ascvbdf","234"));
        list.add(new BookBean("asvbddf","234"));
        list.add(new BookBean("ascvbndf","234"));
        list.add(new BookBean("asxcvdf","234"));
        return list;
    }


    public static List<Fragment> getMainFragments(int count){
        List<Fragment> fragments=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fragments.add(new MainFragment());
        }
        return fragments;
    }
    public static List<Fragment> getTableFragments(int count){
        List<Fragment> fragments=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fragments.add(new TableFragment());
        }
        return fragments;
    }

    public static List<Fragment> getTabLayoutFragments(int count){
        List<Fragment> fragments=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fragments.add(new TabLayoutFragment());
        }
        return fragments;
    }
}
