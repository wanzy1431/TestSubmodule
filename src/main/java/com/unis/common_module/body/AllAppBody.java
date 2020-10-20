package com.unis.common_module.body;

public class AllAppBody {
    private int pageSize;
    private int currentPage;
    private String keyword;
    private String appClassifyId;
    private String mobileTerminalType = "PHONE";
    private String workPlatformType = "ANDROID";

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAppClassifyId() {
        return appClassifyId;
    }

    public void setAppClassifyId(String appClassifyId) {
        this.appClassifyId = appClassifyId;
    }

    public String getMobileTerminalType() {
        return mobileTerminalType;
    }

    public void setMobileTerminalType(String mobileTerminalType) {
        this.mobileTerminalType = mobileTerminalType;
    }

    public String getWorkPlatformType() {
        return workPlatformType;
    }

    public void setWorkPlatformType(String workPlatformType) {
        this.workPlatformType = workPlatformType;
    }
}
