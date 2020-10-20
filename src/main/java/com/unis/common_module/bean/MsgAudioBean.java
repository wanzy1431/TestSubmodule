package com.unis.common_module.bean;

//音频消息体
public class MsgAudioBean {
    private String source;//音频地址
    private long fileId;// 文件Id
    private String fileName;// 文件名称

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
