package com.unis.common_module.bean;

import java.io.Serializable;
import java.util.List;

public class WebActivitySettingBean implements Serializable {

    /**
     * showHeader : 是否显示标题栏
     * showTitle : 是否显示标题
     * title : 标题内容
     */

    private boolean showHeader = false;
    private boolean showTitle = false;
    private String title = "";

    public boolean isShowHeader() {
        return showHeader;
    }

    public boolean isShowTitle() {
        return showTitle;
    }

    public String getTitle() {
        return title;
    }
}
