package com.unis.common_module.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.unis.common_module.daoentity.ChatBgEntityDao;
import com.unis.common_module.daoentity.ConversationEntityDao;
import com.unis.common_module.daoentity.DaoMaster;
import com.unis.common_module.daoentity.GroupEntityDao;
import com.unis.common_module.daoentity.GroupSetEntityDao;
import com.unis.common_module.daoentity.ImTextBeanEntityDao;
import com.unis.common_module.daoentity.OrganizeEntityDao;
import com.unis.common_module.daoentity.UploadBeanDao;

import org.greenrobot.greendao.database.Database;

public class MoXinSQLiteOpenHelper extends DaoMaster.OpenHelper {

    public MoXinSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, OrganizeEntityDao.class, ConversationEntityDao.class, UploadBeanDao.class, ImTextBeanEntityDao.class, GroupSetEntityDao.class, GroupEntityDao.class, ChatBgEntityDao.class);
    }
}
