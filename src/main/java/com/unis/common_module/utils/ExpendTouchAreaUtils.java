package com.unis.common_module.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

public class ExpendTouchAreaUtils {
    public static void expandTouchArea(View view) {
        expandTouchArea(view, DensityUtils.dp2px(view.getContext(), 20));
    }

    public static void expandTouchArea(View view, int size) {
        View parentView = (View) view.getParent();
        parentView.post(new Runnable() {
            @Override
            public void run() {
                Rect rect = new Rect();
                view.getHitRect(rect);
                rect.top -= size;
                rect.bottom += size;
                rect.left -= size;
                rect.right += size;
                parentView.setTouchDelegate(new TouchDelegate(rect, view));
            }
        });
    }
}
