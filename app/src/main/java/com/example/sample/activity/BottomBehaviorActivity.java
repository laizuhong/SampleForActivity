package com.example.sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;

import com.example.sample.R;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2017/6/7
 * 描述:
 */

public class BottomBehaviorActivity extends BaseActivity{
    BottomSheetBehavior<View> behavior;
    BottomSheetDialog sheetDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_behavior);
        View bottomSheet =  findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        sheetDialog=new BottomSheetDialog(this);
        sheetDialog.setContentView(R.layout.include_bottom_sheet_layout);

        findViewById(R.id.btnBehavior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int state = behavior.getState();
                if (state == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }else{
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });

        findViewById(R.id.btnDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sheetDialog.isShowing()){
                    sheetDialog.dismiss();
                }else {
                    sheetDialog.show();
                }
            }
        });
    }
}
