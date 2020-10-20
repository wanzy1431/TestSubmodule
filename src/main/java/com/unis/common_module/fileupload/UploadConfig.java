package com.unis.common_module.fileupload;


import com.unis.common_module.net.IRequest;

/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: UploadConfig
 * Author: zhangyibin
 * Date: 2020/8/19 20:03
 * Description:
 */
public class UploadConfig {
    public static final int STATUS_START = 0;//开始
    public static final int STATUS_COMPLETE = 1;//成功
    public static final int STATUS_ERROR = 2;//失败
    public static final int STATUS_DOWING = 3;//上传中
    public static final int STATUS_CANCLE = 4;//取消
    public static final int STATUS_DEFAULT = 5;//默认状态
    public static final int SPEED_REFRESH_UI_TIME = 1;//progress获取速度


    public static final String UPLOAD_BASEURL = IRequest.HOST;//主地址
}
