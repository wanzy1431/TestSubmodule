package com.unis.common_module.clouddisk;

import android.app.Activity;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.unis.common_module.R;
import com.unis.common_module.clouddisk.bean.FileBean;
import com.unis.common_module.clouddisk.bean.MoveCopyFileReqBean;
import com.unis.common_module.router.RouterPath;

import java.util.ArrayList;

import static com.unis.common_module.clouddisk.bean.FileBean.SHARE_NO_SHARE_SEAT;

public class CloudDiskRouter {

    public static final int REQUEST_CODE_SELECT_FILE = 1122;
    public static final String KEY_CLOUD_FILE = "cloud_file";
    public static final int REQUEST_CODE_COPY_OR_MOVE = 1123;
    public static final String VALUE_SELECT_FILE = "isSelectFileForIM";


    public static void startFileByMyCloud(Activity activity, int classifyId, long forderId, String folderName, int directoryRight) {
        myCloudPublic(classifyId, forderId, folderName, directoryRight)
                .navigation(activity);
    }

    public static void startFileByMyCloudForSelectFile(Activity activity, int classifyId, long forderId, String folderName, int directoryRight) {
        myCloudPublic(classifyId, forderId, folderName, directoryRight)
                .withBoolean(VALUE_SELECT_FILE, true)
                .navigation(activity, REQUEST_CODE_SELECT_FILE);
    }

    private static Postcard myCloudPublic(int classifyId, long forderId, String folderName, int directoryRight) {
        return ARouter.getInstance().build(RouterPath.CLOUDDISK_MINE)
                .withInt("classifyId", classifyId)
                .withLong("folderId", forderId)
                .withString("folderName", folderName)
                .withInt("directoryRight", directoryRight);
    }

    public static void startMyCloudDiskForSelectFile(Activity activity) {
        startFileByMyCloudForSelectFile(activity, CloudDiskConfig.CLASSIFYID_MYCLOUD, CloudDiskConfig.CLASSIFYID_MYCLOUD, activity.getString(R.string.cloud_mine), SHARE_NO_SHARE_SEAT);
    }

    public static void startMyCloudDisk(Activity activity) {
        startFileByMyCloud(activity, CloudDiskConfig.CLASSIFYID_MYCLOUD, CloudDiskConfig.CLASSIFYID_MYCLOUD, activity.getString(R.string.cloud_mine), SHARE_NO_SHARE_SEAT);
    }

    public static void startShareCloudDisk(Activity activity) {
        startFileByMyCloud(activity, CloudDiskConfig.CLASSIFYID_SHARE, CloudDiskConfig.CLASSIFYID_SHARE, activity.getString(R.string.cloud_share), FileBean.SHARE_PERMISSION_MANAGER);
    }

    public static void startShareCloudDiskForSelectFile(Activity activity) {
        startFileByMyCloudForSelectFile(activity, CloudDiskConfig.CLASSIFYID_SHARE, CloudDiskConfig.CLASSIFYID_SHARE, activity.getString(R.string.cloud_share), FileBean.SHARE_PERMISSION_MANAGER);
    }

    public static void startGroupCloudDisk(Activity activity) {
        groupOrClass(activity, CloudDiskConfig.CLASSIFYID_GROUP, activity.getString(R.string.cloud_group));
    }


    public static void startGroupCloudDiskForSelectFile(Activity activity) {
        groupOrClassForSelectFile(activity, CloudDiskConfig.CLASSIFYID_GROUP, activity.getString(R.string.cloud_group));
    }

    public static void startClassCloudDisk(Activity activity) {
        groupOrClass(activity, CloudDiskConfig.CLASSIFYID_CLASS, activity.getString(R.string.cloud_class));
    }

    public static void startClassCloudDiskForSelectFile(Activity activity) {
        groupOrClassForSelectFile(activity, CloudDiskConfig.CLASSIFYID_CLASS, activity.getString(R.string.cloud_class));
    }

    private static void groupOrClassForSelectFile(Activity activity, int classifyid, String folderName) {
        groupOrClassPublic(classifyid, folderName)
                .withBoolean(VALUE_SELECT_FILE, true)
                .navigation(activity, REQUEST_CODE_SELECT_FILE);
    }

    private static void groupOrClass(Activity activity, int classifyid, String folderName) {
        groupOrClassPublic(classifyid, folderName)
                .withBoolean(VALUE_SELECT_FILE, false)
                .navigation(activity);
    }

    private static Postcard groupOrClassPublic(int classifyid, String folderName) {
        return ARouter.getInstance().build(RouterPath.CLOUDDISK_GROUP_OR_CLASS)
                .withInt("classifyId", classifyid)
                .withString("folderName", folderName);
    }

    public static void startMoveOrCopyFile(Activity activity, String optType, ArrayList<MoveCopyFileReqBean.MoveChildFile> fileBeanArrayList) {
        ARouter.getInstance().build(RouterPath.CLOUDDISK_SELECT_FOLDER)
                .withString("optType", optType)
                .withParcelableArrayList("moveFiles", fileBeanArrayList)
                .navigation(activity, REQUEST_CODE_COPY_OR_MOVE);
    }

    public static void saveToCloudDisk(Activity activity, ArrayList<MoveCopyFileReqBean.MoveChildFile> fileBeanArrayList) {
        ARouter.getInstance().build(RouterPath.CLOUDDISK_SELECT_FOLDER)
                .withString("optType", MoveCopyFileReqBean.COPY)
                .withBoolean("saveToCloudDisk", true)
                .withParcelableArrayList("moveFiles", fileBeanArrayList)
                .navigation(activity, REQUEST_CODE_COPY_OR_MOVE);
    }

    public static void startRecentUseForSelectFile(Activity activity) {
        ARouter.getInstance().build(RouterPath.CLOUDDISK_RECENT_USE)
                .withBoolean(VALUE_SELECT_FILE, true)
                .navigation(activity, REQUEST_CODE_SELECT_FILE);
    }

    public static void startRootPageForSelectFile(Activity activity) {
        ARouter.getInstance().build(RouterPath.CLOUDDISK_ROOT_PAGE)
                .navigation(activity, REQUEST_CODE_SELECT_FILE);
    }

    public static void startCloudDisk(Activity activity) {
        ARouter.getInstance().build(RouterPath.CLOUDDISK_RECENT)
                .navigation(activity, REQUEST_CODE_SELECT_FILE);
    }
}
