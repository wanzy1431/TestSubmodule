package com.unis.common_module.daoentity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

@Entity
public class UsedAppEntity {
    @Id
    private String id;
    private String keyId;
    private String shortName;
    private String name;
    private String description;
    private String appTypeName;
    private String appType;
    private String appClassifyName;
    private String iconUrl;
    private String accessUrl;
    private String joinStatus;
    private String packageUrl;
    private String appInstallType;
    private String appInstallTypeName;
    private String installationUrl;
    private String versionName;
    private String accessProtocol;
    private String accessPath;
    private String packageName;
    private String versionCode;
    private String mainActivity;
    private String mobileTerminalTypeNames;
    @Index
    private int numIndex;
    private boolean isSelect;
    public int itemType;
    public boolean isLast;

    @Generated(hash = 1734964997)
    public UsedAppEntity(String id, String keyId, String shortName, String name, String description,
                         String appTypeName, String appType, String appClassifyName, String iconUrl,
                         String accessUrl, String joinStatus, String packageUrl, String appInstallType,
                         String appInstallTypeName, String installationUrl, String versionName,
                         String accessProtocol, String accessPath, String packageName, String versionCode,
                         String mainActivity, String mobileTerminalTypeNames, int numIndex, boolean isSelect,
                         int itemType, boolean isLast) {
        this.id = id;
        this.keyId = keyId;
        this.shortName = shortName;
        this.name = name;
        this.description = description;
        this.appTypeName = appTypeName;
        this.appType = appType;
        this.appClassifyName = appClassifyName;
        this.iconUrl = iconUrl;
        this.accessUrl = accessUrl;
        this.joinStatus = joinStatus;
        this.packageUrl = packageUrl;
        this.appInstallType = appInstallType;
        this.appInstallTypeName = appInstallTypeName;
        this.installationUrl = installationUrl;
        this.versionName = versionName;
        this.accessProtocol = accessProtocol;
        this.accessPath = accessPath;
        this.packageName = packageName;
        this.versionCode = versionCode;
        this.mainActivity = mainActivity;
        this.mobileTerminalTypeNames = mobileTerminalTypeNames;
        this.numIndex = numIndex;
        this.isSelect = isSelect;
        this.itemType = itemType;
        this.isLast = isLast;
    }

    @Generated(hash = 573019039)
    public UsedAppEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppTypeName() {
        return this.appTypeName;
    }

    public void setAppTypeName(String appTypeName) {
        this.appTypeName = appTypeName;
    }

    public String getAppType() {
        return this.appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppClassifyName() {
        return this.appClassifyName;
    }

    public void setAppClassifyName(String appClassifyName) {
        this.appClassifyName = appClassifyName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getAccessUrl() {
        return this.accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getJoinStatus() {
        return this.joinStatus;
    }

    public void setJoinStatus(String joinStatus) {
        this.joinStatus = joinStatus;
    }

    public String getPackageUrl() {
        return this.packageUrl;
    }

    public void setPackageUrl(String packageUrl) {
        this.packageUrl = packageUrl;
    }

    public String getAppInstallType() {
        return this.appInstallType;
    }

    public void setAppInstallType(String appInstallType) {
        this.appInstallType = appInstallType;
    }

    public String getAppInstallTypeName() {
        return this.appInstallTypeName;
    }

    public void setAppInstallTypeName(String appInstallTypeName) {
        this.appInstallTypeName = appInstallTypeName;
    }

    public String getInstallationUrl() {
        return this.installationUrl;
    }

    public void setInstallationUrl(String installationUrl) {
        this.installationUrl = installationUrl;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getAccessProtocol() {
        return this.accessProtocol;
    }

    public void setAccessProtocol(String accessProtocol) {
        this.accessProtocol = accessProtocol;
    }

    public String getAccessPath() {
        return this.accessPath;
    }

    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getMainActivity() {
        return this.mainActivity;
    }

    public void setMainActivity(String mainActivity) {
        this.mainActivity = mainActivity;
    }

    public String getMobileTerminalTypeNames() {
        return this.mobileTerminalTypeNames;
    }

    public void setMobileTerminalTypeNames(String mobileTerminalTypeNames) {
        this.mobileTerminalTypeNames = mobileTerminalTypeNames;
    }

    public boolean getIsSelect() {
        return this.isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    public int getItemType() {
        return this.itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public boolean getIsLast() {
        return this.isLast;
    }

    public void setIsLast(boolean isLast) {
        this.isLast = isLast;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public int getNumIndex() {
        return this.numIndex;
    }

    public void setNumIndex(int numIndex) {
        this.numIndex = numIndex;
    }
}
