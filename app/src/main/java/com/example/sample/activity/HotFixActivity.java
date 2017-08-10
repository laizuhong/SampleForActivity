package com.example.sample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sample.R;

public class HotFixActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_fix_acitivty);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(HotFixActivity.this,"HotFixActivity",Toast.LENGTH_LONG).show();
                Toast.makeText(HotFixActivity.this,"HotFixActivity has fixed",Toast.LENGTH_LONG).show();
            }
        });
    }



}
