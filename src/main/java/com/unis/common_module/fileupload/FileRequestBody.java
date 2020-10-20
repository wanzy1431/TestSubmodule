package com.unis.common_module.fileupload;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: FileRequestBody
 * Author: zhangyibin
 * Date: 2020/8/18 16:10
 * Description:
 */
public class FileRequestBody extends RequestBody {
    protected File file;
    protected String contentType;
    private UploadProgressListener progressListener;

    public FileRequestBody(File file, String contentType, UploadProgressListener progressListener) {
        this.file = file;
        this.contentType = contentType;
        this.progressListener = progressListener;
    }

    @Override
    public MediaType contentType() {
        return MediaType.parse(contentType);
    }

    private int sum;//todo 加这个参数 是因为不同的手机系统，这个回调方法执行次数不同原因未知（手里有的一个华为手机、华为平板执行3次，三星执行两次）
    public static final int SEGMENT_SIZE = 2048;

    @Override
    public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
        sum++;
        boolean ispercent = bufferedSink instanceof Buffer;//如果传入的sink为buffer类型，则直接写入，不进行百分比统计
        Source source = null;
        try {
            source = Okio.source(file);
            long total = 0;
            long read;
            while ((read = source.read(bufferedSink.getBuffer(), SEGMENT_SIZE)) != -1) {
                total += read;
                bufferedSink.flush();
                if (null != progressListener)
                    progressListener.progress(total);
                /*if (!ispercent && sum > 1) {

                }*/
            }
        } finally {
            if (null != source)
                source.close();
        }

    }
}
