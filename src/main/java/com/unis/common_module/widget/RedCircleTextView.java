package com.unis.common_module.widget;


import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.unis.common_module.R;
import com.unis.common_module.utils.DensityUtils;

//import com.unis.teacher.R;
//import com.unis.teacher.utils.DensityUtils;

public class RedCircleTextView extends LinearLayout {

    private TextView tvUnRead;
    private Context context;

    public RedCircleTextView(Context context) {
        super(context);
        this.context = context;
        initView(context);
    }

    public RedCircleTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
    }

    public RedCircleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RedCircleTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        initView(context);

    }

    private void initView(Context context) {
        View content = inflate(context, R.layout.common_unread_text_layout, null);
        addView(content);
        tvUnRead = content.findViewById(R.id.tv_unread);
    }

    public void setText(int count) {
        if (count <= 0) {
            tvUnRead.setBackground(getResources().getDrawable(R.drawable.circle_red));
            tvUnRead.setText("");
        } else if (count < 10 && count > 0) {
            tvUnRead.setBackground(getResources().getDrawable(R.drawable.circle_red));
            tvUnRead.setText(count + "");
        } else if (count <= 99) {
            tvUnRead.setBackground(getResources().getDrawable(R.drawable.rounder_red_6_small));
            tvUnRead.setText(count + "");
        } else {
            tvUnRead.setBackground(getResources().getDrawable(R.drawable.rounder_red_6));
            tvUnRead.setText("99+");
        }

    }

    public void setText(int count, boolean needMargin) {
        if (count < 10) {
            tvUnRead.setBackground(getResources().getDrawable(R.drawable.circle_red));
            tvUnRead.setText(count + "");
            LayoutParams layoutParams = (LayoutParams) tvUnRead.getLayoutParams();
            layoutParams.leftMargin = DensityUtils.dp2px(context, 0);
            tvUnRead.setLayoutParams(layoutParams);
        } else if (count <= 99) {
            tvUnRead.setBackground(getResources().getDrawable(R.drawable.rounder_red_6_small));
            tvUnRead.setText(count + "");
            LayoutParams layoutParams = (LayoutParams) tvUnRead.getLayoutParams();
            layoutParams.leftMargin = DensityUtils.dp2px(context, 10);
            tvUnRead.setLayoutParams(layoutParams);
        } else {
            tvUnRead.setBackground(getResources().getDrawable(R.drawable.rounder_red_6));
            tvUnRead.setText("99+");
            LayoutParams layoutParams = (LayoutParams) tvUnRead.getLayoutParams();
            layoutParams.leftMargin = DensityUtils.dp2px(context, 10);
            tvUnRead.setLayoutParams(layoutParams);
        }
    }
}
