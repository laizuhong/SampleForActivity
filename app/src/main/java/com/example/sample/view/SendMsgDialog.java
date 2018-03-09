package com.example.sample.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.sample.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：赖祖宏
 * 项目：SampleForActivity
 * 时间：2018/1/16
 * 描述:
 */

public class SendMsgDialog extends Dialog {
    @Bind(R.id.edit_text)
    EditText editText;
    @Bind(R.id.edit_layout)
    RelativeLayout editLayout;
    @Bind(R.id.root_view)
    RelativeLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//         <!--关键点1-->
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_send_msg, null);
        ButterKnife.bind(this,view);
//        <!--关键点2-->
        setContentView(view);
//        <!--关键点3-->
        getWindow().setBackgroundDrawable(new ColorDrawable(0x00000000));
//        <!--关键点4-->
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//        setContentView(R.layout.dialog_send_msg);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    public SendMsgDialog(@NonNull Context context) {
        super(context, R.style.window_bg_dialog_common);
    }

    public SendMsgDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SendMsgDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
