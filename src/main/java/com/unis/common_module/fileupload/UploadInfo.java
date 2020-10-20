package com.unis.common_module.fileupload;

/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: UploadInfo
 * Author: zhangyibin
 * Date: 2020/8/19 16:50
 * Description:
 */
public class UploadInfo {
    private String filePath;//文件地址
    private long contentLength;//文件总长度
    private long readLength;//已上传长度
    private boolean isComplete;//是否上传完毕

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public long getReadLength() {
        return readLength;
    }

    public void setReadLength(long readLength) {
        this.readLength = readLength;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
