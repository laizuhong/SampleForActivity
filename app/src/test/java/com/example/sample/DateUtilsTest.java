package com.example.sample;

import com.example.sample.bean.BookBean;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/7/11
 * 描述:
 */
public class DateUtilsTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getDate() throws Exception {
        List<BookBean> list=new ArrayList<>();
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
        for (BookBean bookBean : list) {
            System.out.print(bookBean.toString());
        }
    }

    @Test
    public void getMainFragments() throws Exception {

    }

    @Test
    public void getTableFragments() throws Exception {

    }

    @Test
    public void getTabLayoutFragments() throws Exception {

    }

}