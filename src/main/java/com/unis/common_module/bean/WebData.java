package com.unis.common_module.bean;


import com.unis.common_module.clouddisk.bean.FileBean;
import com.unis.common_module.daoentity.OrganizeEntity;

import java.util.List;

/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: WebData
 * Author: zhangyibin
 * Date: 2020/8/13 15:56
 * Description:
 */
public class WebData {
    private String type = "";
    private AppToJs appToJs;
    private JsToApp jsToApp;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AppToJs getAppToJs() {
        return appToJs;
    }

    public void setAppToJs(AppToJs appToJs) {
        this.appToJs = appToJs;
    }

    public JsToApp getJsToApp() {
        return jsToApp;
    }

    public void setJsToApp(JsToApp jsToApp) {
        this.jsToApp = jsToApp;
    }

    //app传给js的消息bean
    public static class AppToJs {
        private List<OrganizeEntity> organizeEntityList;
        private List<UploadInfo> uploadInfos;//上传图片列表
        private UploadInfo uploadInfo;//上传图片单个状态
        private MoxinAccount userInfo;
        private ClassFragmentBean teacherClassItem;
        //        回传选择云盘上的文件
        private List<FileBean> fileBeanList;
        private int clouddisk_transmission_count;
        private List<String> localFilePaths;


        public List<String> getLocalFilePaths() {
            return localFilePaths;
        }

        public void setLocalFilePaths(List<String> localFilePaths) {
            this.localFilePaths = localFilePaths;
        }

        public int getClouddisk_transmission_count() {
            return clouddisk_transmission_count;
        }

        public void setClouddisk_transmission_count(int clouddisk_transmission_count) {
            this.clouddisk_transmission_count = clouddisk_transmission_count;
        }

        public ClassFragmentBean getTeacherClassItem() {
            return teacherClassItem;
        }

        public void setTeacherClassItem(ClassFragmentBean teacherClassItem) {
            this.teacherClassItem = teacherClassItem;
        }

        public List<OrganizeEntity> getOrganizeEntityList() {
            return organizeEntityList;
        }

        public void setOrganizeEntityList(List<OrganizeEntity> organizeEntityList) {
            this.organizeEntityList = organizeEntityList;
        }

        public List<FileBean> getFileBeanList() {
            return fileBeanList;
        }

        public void setFileBeanList(List<FileBean> fileBeanList) {
            this.fileBeanList = fileBeanList;
        }

        public MoxinAccount getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(MoxinAccount userInfo) {
            this.userInfo = userInfo;
        }

        public List<UploadInfo> getUploadInfos() {
            return uploadInfos;
        }

        public void setUploadInfos(List<UploadInfo> uploadInfos) {
            this.uploadInfos = uploadInfos;
        }

        public UploadInfo getUploadInfo() {
            return uploadInfo;
        }

        public void setUploadInfo(UploadInfo uploadInfo) {
            this.uploadInfo = uploadInfo;
        }

        public static class UploadInfo {
            private String fileId;//id android本地路径
            private String fileType;//类型
            private int status = 5;//状态
            private String filename;//文件名
            private String thumbBase64;//缩略图
            private String url;//图片地址
            private int progress;//进度
            private String uuid;//文件上传id
            private String updateTime;//文件时间
            private String duration;//时长

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getFileId() {
                return fileId;
            }

            public void setFileId(String fileId) {
                this.fileId = fileId;
            }

            public String getFileType() {
                return fileType;
            }

            public void setFileType(String fileType) {
                this.fileType = fileType;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getFilename() {
                return filename;
            }

            public void setFilename(String filename) {
                this.filename = filename;
            }

            public String getThumbBase64() {
                return thumbBase64;
            }

            public void setThumbBase64(String thumbBase64) {
                this.thumbBase64 = thumbBase64;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getProgress() {
                return progress;
            }

            public void setProgress(int progress) {
                this.progress = progress;
            }
        }
    }

    //js传给app的消息bean
    public static class JsToApp {
        private String shareType;//分享类型 calendar 日程  text 文字 image 图片  voice 音频  file 文件  video 视频  card 名片 face 表情
        private WebActivitySettingBean settingBean;//顶部标题设置 显示隐藏 标题内容
        private String url;//跳转新WebViewActivity打开url
        private CalendarBean calendarBean;
        private List<String> downloadUrlList;//图片下载地址
        private String bizType;
        private TeacherDetailBean teacherDetailBean;
        /*
        文件上传类型：
        班级通知：bizType="classNotification"
        班级问卷：bizType="classQuestionnaire"
        班级文件: bizType: "classFile"
        班级相册：bizType="classAlbum"
        云盘:   bizType: "cloudDisk"
        PC云盘: bizType = "diskDesktop"
        日程:  bizType: "calendar"*/

        public String getBizType() {
            return bizType;
        }

        public void setBizType(String bizType) {
            this.bizType = bizType;
        }

        public List<String> getDownloadUrlList() {
            return downloadUrlList;
        }

        public void setDownloadUrlList(List<String> downloadUrlList) {
            this.downloadUrlList = downloadUrlList;
        }

        public WebActivitySettingBean getSettingBean() {
            return settingBean;
        }

        public String getUrl() {
            return url;
        }

        public String getShareType() {
            return shareType;
        }

        public void setShareType(String shareType) {
            this.shareType = shareType;
        }

        public CalendarBean getCalendarBean() {
            return calendarBean;
        }

        public void setCalendarBean(CalendarBean calendarBean) {
            this.calendarBean = calendarBean;
        }

        public TeacherDetailBean getTeacherDetailBean() {
            return teacherDetailBean;
        }

        public void setTeacherDetailBean(TeacherDetailBean teacherDetailBean) {
            this.teacherDetailBean = teacherDetailBean;
        }
    }

}
