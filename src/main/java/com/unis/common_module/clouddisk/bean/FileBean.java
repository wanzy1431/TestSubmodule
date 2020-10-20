/**
 * Copyright 2020 bejson.com
 */
package com.unis.common_module.clouddisk.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Auto-generated: 2020-07-16 14:18:43
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class FileBean implements Parcelable {

    private String id;
    private String createTime;
    private String creator;
    private String updateTime;
    private String modificator;
    private String itemName;
    private String isFile;
    //    文件分类DOC、IMAGE、OTHER
    private String fileType;
    private String uuid;
    private String fileSize;
    private String fileExt;
    private boolean isSelect;
    private long directoryId;
    private String directoryPath;
    private int classifyId;
    private String directoryName;
    private String downloadUrl;
    private String avatarUrl;
    private FolderBeanRes folderBeanRes;
    //    共享权限3:管理2:编辑上传1:查看4:自己创建的' 100:不是分享页面的占位
    public static final int SHARE_NO_SHARE_SEAT = 100;
    public static final int SHARE_PERMISSION_MANAGER = 3;
    public static final int SHARE_PERMISSION_EDITOR = 2;
    public static final int SHARE_PERMISSION_VIEW = 1;
    public static final int SHARE_PERMISSION_SELF = 4;

    private int directoryRight;
    private String fileConversionSize;
    //    预览文件
    private String fileName;//文件名字
    private String playUrl;//预览通用地址（网页单独取h5PrviewUrl字段）
    private String transCodingStatus;//文件转码状态：0 尚未转码 1 转码中，2 转码成功 3 转码失败
    private String canPreview;//是否可预览,1可预览 0不可预览
    private String h5PrviewUrl;//h5预览字段
    private String nativeFilePath;//本地文件路径
    private String thumbnailPath;//视频缩略图路径
    private String hasFile;//是否有该文件1:有0:无


    public FileBean(Parcel in) {
        id = in.readString();
        createTime = in.readString();
        creator = in.readString();
        updateTime = in.readString();
        modificator = in.readString();
        itemName = in.readString();
        isFile = in.readString();
        fileType = in.readString();
        uuid = in.readString();
        fileSize = in.readString();
        fileExt = in.readString();
        isSelect = in.readByte() != 0;
        directoryId = in.readLong();
        directoryPath = in.readString();
        classifyId = in.readInt();
        directoryName = in.readString();
        downloadUrl = in.readString();
        avatarUrl = in.readString();
        folderBeanRes = in.readParcelable(FolderBeanRes.class.getClassLoader());
        directoryRight = in.readInt();
        fileConversionSize = in.readString();
        fileName = in.readString();
        playUrl = in.readString();
        transCodingStatus = in.readString();
        canPreview = in.readString();
        h5PrviewUrl = in.readString();
        nativeFilePath = in.readString();
        thumbnailPath = in.readString();
        hasFile = in.readString();
    }


    public FileBean(String itemName, int classifyId, String id) {
        this.id = id;
        this.itemName = itemName;
        this.classifyId = classifyId;
    }

    public FileBean() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(createTime);
        dest.writeString(creator);
        dest.writeString(updateTime);
        dest.writeString(modificator);
        dest.writeString(itemName);
        dest.writeString(isFile);
        dest.writeString(fileType);
        dest.writeString(uuid);
        dest.writeString(fileSize);
        dest.writeString(fileExt);
        dest.writeByte((byte) (isSelect ? 1 : 0));
        dest.writeLong(directoryId);
        dest.writeString(directoryPath);
        dest.writeInt(classifyId);
        dest.writeString(directoryName);
        dest.writeString(downloadUrl);
        dest.writeString(avatarUrl);
        dest.writeParcelable(folderBeanRes, flags);
        dest.writeInt(directoryRight);
        dest.writeString(fileConversionSize);
        dest.writeString(fileName);
        dest.writeString(playUrl);
        dest.writeString(transCodingStatus);
        dest.writeString(canPreview);
        dest.writeString(h5PrviewUrl);
        dest.writeString(nativeFilePath);
        dest.writeString(thumbnailPath);
        dest.writeString(hasFile);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FileBean> CREATOR = new Creator<FileBean>() {
        @Override
        public FileBean createFromParcel(Parcel in) {
            return new FileBean(in);
        }

        @Override
        public FileBean[] newArray(int size) {
            return new FileBean[size];
        }
    };

    public String getFileConversionSize() {
        return fileConversionSize;
    }

    public void setFileConversionSize(String fileConversionSize) {
        this.fileConversionSize = fileConversionSize;
    }

    public int getDirectoryRight() {
        return directoryRight;
    }

    public void setDirectoryRight(int directoryRight) {
        this.directoryRight = directoryRight;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public long getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(long directoryId) {
        this.directoryId = directoryId;
    }

    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }

    public FolderBeanRes getFolderBeanRes() {
        return folderBeanRes;
    }

    public void setFolderBeanRes(FolderBeanRes folderBeanRes) {
        this.folderBeanRes = folderBeanRes;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }


    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setModificator(String modificator) {
        this.modificator = modificator;
    }

    public String getModificator() {
        return modificator;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setIsFile(String isFile) {
        this.isFile = isFile;
    }

    public String getIsFile() {
        return isFile;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getTransCodingStatus() {
        return transCodingStatus;
    }

    public void setTransCodingStatus(String transCodingStatus) {
        this.transCodingStatus = transCodingStatus;
    }

    public String getCanPreview() {
        return canPreview;
    }

    public void setCanPreview(String canPreview) {
        this.canPreview = canPreview;
    }

    public String getH5PrviewUrl() {
        return h5PrviewUrl;
    }

    public void setH5PrviewUrl(String h5PrviewUrl) {
        this.h5PrviewUrl = h5PrviewUrl;
    }

    public String getNativeFilePath() {
        return nativeFilePath;
    }

    public void setNativeFilePath(String nativeFilePath) {
        this.nativeFilePath = nativeFilePath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getHasFile() {
        return hasFile;
    }

    public void setHasFile(String hasFile) {
        this.hasFile = hasFile;
    }
}