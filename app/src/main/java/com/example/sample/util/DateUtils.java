package com.example.sample.util;

import android.support.v4.app.Fragment;

import com.example.sample.bean.BookBean;
import com.example.sample.fragment.MainFragment;
import com.example.sample.fragment.TableFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赖祖宏 on 2017/5/15.
 */

public class DateUtils {
    public static List<BookBean> getDate(){

        List<BookBean> list=new ArrayList<>();
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
        list.add(new BookBean("asdf","234"));
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
}