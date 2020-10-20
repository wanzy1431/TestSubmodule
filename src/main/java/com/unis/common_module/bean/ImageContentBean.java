package com.unis.common_module.bean;

import java.io.Serializable;

//发送图片
public class ImageContentBean implements Serializable {
    private String thumb;//压缩图片地址
    private String size;//bit
    private String source;//原始图片地址
    private String fileId;// 文件Id
    private String fileName;// 文件名称

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
