package com.unis.common_module.daoentity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * 文件上传本地表字段实体
 */
@Entity
public class UploadBean implements Serializable {

    private static final long serialVersionUID = 0L;

    @Id(autoincrement = true)
    private Long id;

    /*
        上传服务器返回的文件id
     */
    private long file_id;

    /**
     * 速度
     */
    private long speed = 0;
    /**
     * 单位转换后的速度
     */
    private String convertSpeed;
    /**
     * 失败计数，每次开始都重置为0
     */
    private int failNum = 0;

    /**
     * 剩余时间，单位：s
     */
    private int timeLeft = Integer.MAX_VALUE;

    /**
     * 扩展字段
     */
    private String str;
    /**
     * 文件大小
     */
    private long fileSize = 0;
    /**
     * 转换后的文件大小
     */
    private String convertFileSize;
    /**
     * 当前已上传文件大小
     */
    private long currentUploadFileSize;
    /**
     * 任务状态
     */
    private int state = -1;
    /**
     * 当前下载进度
     */
    private long currentProgress = 0;
    /**
     * 完成时间
     */
    private long completeTime;
    /**
     * 进度百分比
     */
    private int percent;

    private boolean isComplete = false;
    /**
     * 上一次停止时间
     */
    private long stopTime = 0;
    /**
     * 服务器地址
     */
    private String url;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 是否重定向
     */
    private boolean isRedirect = false;
    /**
     * 重定向链接
     */
    private String redirectUrl;
    /**
     * 任务类型
     */
    private int taskType;

    /**
     * 文件上传路径
     */
    private String filePath;
    /**
     * 上传完成后服务器返回的数据
     */
    private String responseStr = "";
    /**
     * 保存临时设置的上传路径
     */
    private String tempUrl;
    /**
     * 业务文件下载地址
     */
    private String downloadUrl;
    /**
     * 业务ID
     */
    private String bizId;
    /**
     * 业务类型
     */
    private String bizType;
    /**
     * 文件类型
     */
    private String contentType;
    /**
     * 后缀
     */
    private String ext;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 数据类型EcpFileDataType{ DIR:目录;IMAGE:图片;VIDEO:视频;AUDIO:音频;DOC:文档;OTHER:其他 }
     */
    private String dataType;
    /**
     * md5值
     */
    private String fileMd5;
    /**
     * 文件的相对路径
     */
    private String relativePath;
    /**
     * 原始文件名
     */
    private String submittedFileName;
    /**
     * 是否是敏感文件，如果是敏感文件则不允许查看
     */
    private String fileSensitive;
    /**
     * 最后修改时间
     */
    private String updateTime;
    /**
     * 业务文件uuid
     */
    private String uuid;
    /**
     * 是否需要合并
     */
    private String needMerge;
    /**
     * 文件是否存在，存在则直接返回文件信息，进行秒传
     */
    private String skipUpload;
    /**
     * 已上传分片
     */
    private String uploaded;
    /**
     * 当前文件块，从1开始
     */
    private String chunkNumber;
    /**
     * 分块大小
     */
    private String chunkSize;
    /**
     * 当前分块大小
     */
    private String currentChunkSize;
    /**
     * 文件标识
     */
    private String identifier;
    /**
     * 总块数
     */
    private String totalChunks;
    /**
     * 班级分类
     */
    private String publishToClass;
    /**
     * 拓展数据
     */
    private String extra;

    @Generated(hash = 1456120519)
    public UploadBean(Long id, long file_id, long speed, String convertSpeed, int failNum,
                      int timeLeft, String str, long fileSize, String convertFileSize,
                      long currentUploadFileSize, int state, long currentProgress, long completeTime,
                      int percent, boolean isComplete, long stopTime, String url, String fileName,
                      boolean isRedirect, String redirectUrl, int taskType, String filePath,
                      String responseStr, String tempUrl, String downloadUrl, String bizId,
                      String bizType, String contentType, String ext, String createTime,
                      String dataType, String fileMd5, String relativePath, String submittedFileName,
                      String fileSensitive, String updateTime, String uuid, String needMerge,
                      String skipUpload, String uploaded, String chunkNumber, String chunkSize,
                      String currentChunkSize, String identifier, String totalChunks,
                      String publishToClass, String extra) {
        this.id = id;
        this.file_id = file_id;
        this.speed = speed;
        this.convertSpeed = convertSpeed;
        this.failNum = failNum;
        this.timeLeft = timeLeft;
        this.str = str;
        this.fileSize = fileSize;
        this.convertFileSize = convertFileSize;
        this.currentUploadFileSize = currentUploadFileSize;
        this.state = state;
        this.currentProgress = currentProgress;
        this.completeTime = completeTime;
        this.percent = percent;
        this.isComplete = isComplete;
        this.stopTime = stopTime;
        this.url = url;
        this.fileName = fileName;
        this.isRedirect = isRedirect;
        this.redirectUrl = redirectUrl;
        this.taskType = taskType;
        this.filePath = filePath;
        this.responseStr = responseStr;
        this.tempUrl = tempUrl;
        this.downloadUrl = downloadUrl;
        this.bizId = bizId;
        this.bizType = bizType;
        this.contentType = contentType;
        this.ext = ext;
        this.createTime = createTime;
        this.dataType = dataType;
        this.fileMd5 = fileMd5;
        this.relativePath = relativePath;
        this.submittedFileName = submittedFileName;
        this.fileSensitive = fileSensitive;
        this.updateTime = updateTime;
        this.uuid = uuid;
        this.needMerge = needMerge;
        this.skipUpload = skipUpload;
        this.uploaded = uploaded;
        this.chunkNumber = chunkNumber;
        this.chunkSize = chunkSize;
        this.currentChunkSize = currentChunkSize;
        this.identifier = identifier;
        this.totalChunks = totalChunks;
        this.publishToClass = publishToClass;
        this.extra = extra;
    }

    @Generated(hash = 856027701)
    public UploadBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getFile_id() {
        return this.file_id;
    }

    public void setFile_id(long file_id) {
        this.file_id = file_id;
    }

    public long getSpeed() {
        return this.speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public String getConvertSpeed() {
        return this.convertSpeed;
    }

    public void setConvertSpeed(String convertSpeed) {
        this.convertSpeed = convertSpeed;
    }

    public int getFailNum() {
        return this.failNum;
    }

    public void setFailNum(int failNum) {
        this.failNum = failNum;
    }

    public int getTimeLeft() {
        return this.timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getStr() {
        return this.str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getConvertFileSize() {
        return this.convertFileSize;
    }

    public void setConvertFileSize(String convertFileSize) {
        this.convertFileSize = convertFileSize;
    }

    public long getCurrentUploadFileSize() {
        return this.currentUploadFileSize;
    }

    public void setCurrentUploadFileSize(long currentUploadFileSize) {
        this.currentUploadFileSize = currentUploadFileSize;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getCurrentProgress() {
        return this.currentProgress;
    }

    public void setCurrentProgress(long currentProgress) {
        this.currentProgress = currentProgress;
    }

    public long getCompleteTime() {
        return this.completeTime;
    }

    public void setCompleteTime(long completeTime) {
        this.completeTime = completeTime;
    }

    public int getPercent() {
        return this.percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public boolean getIsComplete() {
        return this.isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public long getStopTime() {
        return this.stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean getIsRedirect() {
        return this.isRedirect;
    }

    public void setIsRedirect(boolean isRedirect) {
        this.isRedirect = isRedirect;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public int getTaskType() {
        return this.taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getResponseStr() {
        return this.responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }

    public String getTempUrl() {
        return this.tempUrl;
    }

    public void setTempUrl(String tempUrl) {
        this.tempUrl = tempUrl;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getBizId() {
        return this.bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getExt() {
        return this.ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public String getRelativePath() {
        return this.relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getSubmittedFileName() {
        return this.submittedFileName;
    }

    public void setSubmittedFileName(String submittedFileName) {
        this.submittedFileName = submittedFileName;
    }

    public String getFileSensitive() {
        return this.fileSensitive;
    }

    public void setFileSensitive(String fileSensitive) {
        this.fileSensitive = fileSensitive;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNeedMerge() {
        return this.needMerge;
    }

    public void setNeedMerge(String needMerge) {
        this.needMerge = needMerge;
    }

    public String getSkipUpload() {
        return this.skipUpload;
    }

    public void setSkipUpload(String skipUpload) {
        this.skipUpload = skipUpload;
    }

    public String getUploaded() {
        return this.uploaded;
    }

    public void setUploaded(String uploaded) {
        this.uploaded = uploaded;
    }

    public String getChunkNumber() {
        return this.chunkNumber;
    }

    public void setChunkNumber(String chunkNumber) {
        this.chunkNumber = chunkNumber;
    }

    public String getChunkSize() {
        return this.chunkSize;
    }

    public void setChunkSize(String chunkSize) {
        this.chunkSize = chunkSize;
    }

    public String getCurrentChunkSize() {
        return this.currentChunkSize;
    }

    public void setCurrentChunkSize(String currentChunkSize) {
        this.currentChunkSize = currentChunkSize;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTotalChunks() {
        return this.totalChunks;
    }

    public void setTotalChunks(String totalChunks) {
        this.totalChunks = totalChunks;
    }

    public String getPublishToClass() {
        return publishToClass;
    }

    public void setPublishToClass(String publishToClass) {
        this.publishToClass = publishToClass;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
