package com.unis.common_module.bean;

import java.io.Serializable;

//云盘分享文件
public class FileContentBean implements Serializable {
    private String appId;//应用标识
    private String appName;//应用名称
    private String downloadUrl;//文件地址
    private String name;//文件名称
    private String fileSize;//文件大小
    private String fileConversionSize;//显示大小
    private String id;//云盘文件id
    private String uuid;//文件服务文件uuid
    private String fileExt;//文件后缀
    private String classifyId;//云盘分类，1:我的云盘2:群文件3:班级文件4:共享文件
    private String detailUrl;//h5跳转地址

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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileConversionSize() {
        return fileConversionSize;
    }

    public void setFileConversionSize(String fileConversionSize) {
        this.fileConversionSize = fileConversionSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
}
