package com.unis.common_module.base;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tencent.bugly.crashreport.CrashReport;
import com.unis.common_module.R;
import com.unis.common_module.config.MoxinConfig;
import com.unis.common_module.daoentity.DaoMaster;
import com.unis.common_module.daoentity.DaoSession;
import com.unis.common_module.helper.MoXinSQLiteOpenHelper;
import com.unis.common_module.utils.AppContextUtil;
import com.unis.common_module.utils.BackgroundTasks;
import com.unis.common_module.widget.itoast.ToastUtils;
import com.unis.common_module.widget.itoast.style.ToastBlackStyle;

import org.greenrobot.greendao.database.Database;

public class UnisApplication extends BaseApplication {
    private static final String TAG = UnisApplication.class.getSimpleName();
    private static UnisApplication instance;
    private DaoSession daoSession;
    private static Context mContext;//全局上下文对象

    public static UnisApplication instance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppContextUtil.init(this, true, false);
        instance = this;
        mContext = getApplicationContext();
        MultiDex.install(this);
        //
        if (MoxinConfig.LOG_DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
//        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
//        strategy.setAppVersion(TIMManager.getInstance().getVersion());
//        CrashReport.initCrashReport(getApplicationContext(), PrivateConstants.BUGLY_APPID, true, strategy);
        try {
            ToastUtils.init(this, new ToastBlackStyle(this));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //
        initSmartListStyle();
        CrashReport.initCrashReport(getApplicationContext(), "ef74e631d5", false);
        BackgroundTasks.initInstance();
        MoXinSQLiteOpenHelper helper = new MoXinSQLiteOpenHelper(this, "school-db", null);
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        initLiveEventBus();
    }

    private void initLiveEventBus() {
        LiveEventBus.get()
                .config()
                .supportBroadcast(this)
                .lifecycleObserverAlwaysActive(true)
                .autoClear(false);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static Context getmContext() {
        return mContext;
    }

    private void initSmartListStyle() {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.white, R.color.cloud_gold);//全局设置主题颜色
                return new ClassicsHeader(getApplicationContext());//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

}
