package com.unis.common_module.fileupload;

/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: UploadProgressListener
 * Author: zhangyibin
 * Date: 2020/8/19 15:39
 * Description:
 * 上传进度条，body中使用
 */
public interface UploadProgressListener {
    /**
     * @param read 读取量
     */
    void progress(long read);
}
