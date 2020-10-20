package com.unis.common_module.widget;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WorkItemDecoration extends RecyclerView.ItemDecoration {
    private int spaceTop;
    private int spceBottom;

    public WorkItemDecoration(int spaceTop, int spceBottom) {
        this.spaceTop = spaceTop;
        this.spceBottom = spceBottom;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition != 0) {
            outRect.bottom = spceBottom;
        } else {
            outRect.bottom = spaceTop;
        }
//        else{
//            outRect.bottom = spceBottom;
//        }
    }
}
