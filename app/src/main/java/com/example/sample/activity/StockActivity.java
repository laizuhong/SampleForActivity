package com.example.sample.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.example.sample.R;
import com.example.sample.adapter.MainAdapter;
import com.example.sample.bean.BookBean;
import com.example.sample.util.DateUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StockActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.edt)
    EditText edt;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        List<BookBean> list=DateUtils.getDate();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MainAdapter(null);
        recyclerView.setAdapter(adapter);

//        textBeanDao= SampleApplicationLike.getInstance().getSession().getBookBeanDao();
//        for (BookBean bookBean : list) {
//            textBeanDao.insertOrReplaceInTx(bookBean);
//            textBeanDao.insertInTx(bookBean);
//        }

//        edt.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                if (!TextUtils.isEmpty(editable.toString())) {
//                    List<BookBean> list = search(editable.toString());
//                    adapter.setNewData(list);
//                }else {
//                    adapter.setNewData(null);
//                }
//            }
//        });
    }


//    private List<BookBean> search(String s){
//        QueryBuilder builder = textBeanDao.queryBuilder();
//        long count=builder.count();
//        builder.whereOr(BookBeanDao.Properties.Name.like("%"+s+"%"),BookBeanDao.Properties.Price.like("%"+s+"%"));
//        return builder.list();
//    }
}
