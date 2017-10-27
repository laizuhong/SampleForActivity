package com.example.sample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.sample.R;
import com.example.sample.adapter.Main2Adapter;
import com.example.sample.adapter.MainAdapter;
import com.example.sample.util.DateUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerActivity extends AppCompatActivity {

    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                MainAdapter adapter=new MainAdapter(DateUtils.getDate());
                recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
                recyclerView.setAdapter(adapter);
                break;
            case R.id.btn2:
                Main2Adapter adapter1=new Main2Adapter(DateUtils.getDate());
                recyclerView.setLayoutManager(new GridLayoutManager(RecyclerActivity.this,4));
                recyclerView.setAdapter(adapter1);
                break;
        }
    }
}
