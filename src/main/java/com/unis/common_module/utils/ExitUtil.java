package com.unis.common_module.utils;

import com.arialyy.aria.core.Aria;
import com.unis.common_module.base.UnisApplication;
import com.unis.common_module.config.Event;
import com.unis.common_module.net.SpAPI;

public class ExitUtil {
    private volatile static ExitUtil mSingleton = null;

    private ExitUtil() {

    }

    public static ExitUtil getInstance() {
        if (mSingleton == null) {
            synchronized (ExitUtil.class) {
                if (mSingleton == null) {
                    mSingleton = new ExitUtil();
                }
            }
        }
        return mSingleton;
    }

    public void loginOut() {
        RxManager rxManager = new RxManager();
        rxManager.post(Event.REFRESH_UNREAD_COUNT, "0");
        //0 被踢 1正常退出
        SpUtils.removeAll(SpAPI.THIS.F_MOXINIP, UnisApplication.getmContext());
        //清空数据库
        UnisApplication.instance().getDaoSession().getImTextBeanEntityDao().deleteAll();
        UnisApplication.instance().getDaoSession().getConversationEntityDao().deleteAll();
        UnisApplication.instance().getDaoSession().getGroupSetEntityDao().deleteAll();
        UnisApplication.instance().getDaoSession().getGroupEntityDao().deleteAll();
        UnisApplication.instance().getDaoSession().getOrganizeEntityDao().deleteAll();
        UnisApplication.instance().getDaoSession().getChatBgEntityDao().deleteAll();
        UnisApplication.instance().getDaoSession().getUploadBeanDao().deleteAll();
        //清空下载记录
        Aria.download(this).removeAllTask(true);
    }
}
