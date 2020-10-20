package com.unis.common_module.widget.combinebitmap;

import android.content.Context;

import com.unis.common_module.widget.combinebitmap.helper.Builder;


public class CombineBitmap {
    public static Builder init(Context context) {
        return new Builder(context);
    }
}
