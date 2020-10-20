package com.unis.common_module.bean;

import java.io.Serializable;

//云盘分享文件夹
public class FolderContentBean implements Serializable {
    private String appId;//应用标识
    private String appName;//应用名称
    private String id;//文件夹id
    private String name;//文件夹名称
    private String size;//文件夹大小
    private String fileConversionSize;//显示大小
    private String detailUrl;//h5跳转地址
    private String classifyId;//云盘分类，1:我的云盘2:群文件3:班级文件4:共享文件

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFileConversionSize() {
        return fileConversionSize;
    }

    public void setFileConversionSize(String fileConversionSize) {
        this.fileConversionSize = fileConversionSize;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }
}
