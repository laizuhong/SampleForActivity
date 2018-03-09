package com.example.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sample.R;
import com.example.sample.bean.BookBean;
import com.example.sample.util.DateUtils;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by 赖祖宏 on 2017/5/15.
 */

public class TableFragment extends Fragment {
//    @Bind(R.id.toolbar)
//    Toolbar toolbar;

//    @Bind(R.id.recyclerView)
//    RecyclerView recyclerView;

    List<BookBean> list;
//    MainAdapter adapter;
//    @Bind(R.id.appbar)
    AppBarLayout appbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabhost, null);
        ButterKnife.bind(this, view);
        list = DateUtils.getDate();

//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        adapter = new MainAdapter(list);
//        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
