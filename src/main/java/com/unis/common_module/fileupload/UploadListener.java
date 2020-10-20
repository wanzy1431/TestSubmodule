package com.unis.common_module.fileupload;


/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: UploadListener
 * Author: zhangyibin
 * Date: 2020/8/19 15:58
 * Description:
 */
public interface UploadListener<T> {
    /**
     * 开始上传
     *
     * @param url
     */
    void start(String url);

    /**
     * @param read          已上传大小
     * @param contentLength 总大小
     * @param url           上传文件地址
     * @param kbs           上传速度
     */
    void progress(long read, long contentLength, String url, long kbs);

    /**
     * 上传完成 成功
     *
     * @param url 下载地址
     */
    void complete(String url, T value);

    /**
     * 上传完成 失败
     */
    void error(String url, String msg);

}
