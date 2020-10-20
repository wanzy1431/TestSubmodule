package com.unis.common_module.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class CollectinoBean implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int IMG_TEXT = 3;
    public static final int FILE = 4;
    public static final int VIDEO = 5;
    public static final int VOICE = 6;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    private int itemType;

    @Override
    public int getItemType() {
        return itemType;
    }
}
