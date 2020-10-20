package com.unis.common_module.fileupload;


import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: UploadFileAPI
 * Author: zhangyibin
 * Date: 2020/8/19 10:18
 * Description:
 */
public interface UploadFileAPI {
    @POST
    Observable<Object> uploadFile(@Url String url, @Query("bizType") String bizType, @Body MultipartBody multipartBody);
}
