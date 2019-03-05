package com.example.sample.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import com.example.sample.R;

public class ImageDialog extends Dialog{
    public ImageDialog(@NonNull Context context) {
        super(context,R.style.window_bg_dialog_common);
    }

    public ImageDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ImageDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_order);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        dismiss();
        return super.onTouchEvent(event);
    }
}
