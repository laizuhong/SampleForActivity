package com.example.sample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sample.R;
import com.example.sample.view.ShadowDrawableWrapper;

public class ShadowViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow_view);
        View button=findViewById(R.id.btn);
        ShadowDrawableWrapper shadowDrawableWrapper=new ShadowDrawableWrapper(this,
                null,10,20,20);
        button.setBackground(shadowDrawableWrapper);
    }
}
