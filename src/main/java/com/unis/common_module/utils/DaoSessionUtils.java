package com.unis.common_module.utils;

import android.text.TextUtils;

import com.unis.common_module.base.UnisApplication;
import com.unis.common_module.daoentity.ChatBgEntity;
import com.unis.common_module.daoentity.ChatBgEntityDao;
import com.unis.common_module.daoentity.ConversationEntity;
import com.unis.common_module.daoentity.ConversationEntityDao;
import com.unis.common_module.daoentity.DaoSession;
import com.unis.common_module.daoentity.GroupEntity;
import com.unis.common_module.daoentity.GroupEntityDao;
import com.unis.common_module.daoentity.GroupSetEntity;
import com.unis.common_module.daoentity.GroupSetEntityDao;
import com.unis.common_module.daoentity.ImTextBeanEntity;
import com.unis.common_module.daoentity.ImTextBeanEntityDao;
import com.unis.common_module.daoentity.OrganizeEntity;
import com.unis.common_module.daoentity.OrganizeEntityDao;
import com.unis.common_module.daoentity.UploadBean;
import com.unis.common_module.net.SpAPI;

import java.util.ArrayList;
import java.util.List;

public class DaoSessionUtils {

    static DaoSession daoSession;

    public static DaoSession getDaoInstance() {
        if (daoSession == null) {
            daoSession = UnisApplication.instance().getDaoSession();
        }
        //清空所有数据表的缓存数据
        //daoSession.clear();
        return daoSession;
    }
    //-----------------聊天记录数据库---------------------//

    public static List<ImTextBeanEntity> queryAllImTextBeanEntity() {
        List<ImTextBeanEntity> list = getDaoInstance().getImTextBeanEntityDao().queryBuilder().list();
        return list;
    }

    public static ImTextBeanEntity queryImTextBeanEntityById(String id) {
        ImTextBeanEntity imTextBeanEntity = getDaoInstance().getImTextBeanEntityDao().queryBuilder().where(ImTextBeanEntityDao.Properties.MsgId.eq(id)).unique();
        return imTextBeanEntity;
    }

    public static List<ImTextBeanEntity> queryImTextBeanEntityList(String chatId) {
        //获取 某个对话  实体集合类
        if (TextUtils.isEmpty(chatId)) {
            return null;
        }
        return getDaoInstance().getImTextBeanEntityDao().queryBuilder()
                .where(ImTextBeanEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ImTextBeanEntityDao.Properties.ConversationId.eq(chatId)).list();
    }

    public static List<ImTextBeanEntity> queryImTextBeanEntityListByMsgId(String chatId, List<String> msgIds) {
        //获取 某个对话 根据消息Id  实体排序集合类
        if (TextUtils.isEmpty(chatId) || msgIds == null) {
            return null;
        }
        return getDaoInstance().getImTextBeanEntityDao().queryBuilder()
                .where(ImTextBeanEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ImTextBeanEntityDao.Properties.ConversationId.eq(chatId), ImTextBeanEntityDao.Properties.MsgId.in(msgIds))
                .orderDesc(ImTextBeanEntityDao.Properties.CreateTime)
                .list();
    }

    public static ImTextBeanEntity queryImTextBeanEntity(String chatId, String msgId) {
        //获取 某个对话 某个消息 实体类
        if (TextUtils.isEmpty(chatId) || TextUtils.isEmpty(msgId)) {
            return null;
        }
        return getDaoInstance().getImTextBeanEntityDao().queryBuilder()
                .where(ImTextBeanEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ImTextBeanEntityDao.Properties.ConversationId.eq(chatId)
                        , ImTextBeanEntityDao.Properties.MsgId.eq(msgId)).unique();
    }

    public static List<ImTextBeanEntity> searchImTextBeanEntityList(String searchStr) {
        //搜索 某个内容 实体集合类
        if (TextUtils.isEmpty(searchStr)) {
            return null;
        }
        return getDaoInstance().getImTextBeanEntityDao().queryBuilder().where(ImTextBeanEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ImTextBeanEntityDao.Properties.ChatType.notEq("0"), ImTextBeanEntityDao.Properties.ChatType.isNotNull(), ImTextBeanEntityDao.Properties.Content.like("%" + searchStr + "%")).orderAsc(ImTextBeanEntityDao.Properties.CreateTime).list();
    }

    public static long searchImTextBeanEntityCount(String chatId, String searchStr) {
        //搜索 某个对话 某个消息 实体集合类
        if (TextUtils.isEmpty(chatId) || TextUtils.isEmpty(searchStr)) {
            return 0;
        }
        return getDaoInstance().getImTextBeanEntityDao().queryBuilder().where(ImTextBeanEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ImTextBeanEntityDao.Properties.ConversationId.eq(chatId), ImTextBeanEntityDao.Properties.ChatType.notEq("0"), ImTextBeanEntityDao.Properties.ChatType.isNotNull(), ImTextBeanEntityDao.Properties.Content.like("%" + searchStr + "%")).orderAsc(ImTextBeanEntityDao.Properties.CreateTime).count();
    }

    public static List<ImTextBeanEntity> searchImTextBeanEntityList(String chatId, String searchStr) {
        //搜索 某个对话 某个消息 实体集合类
        if (TextUtils.isEmpty(chatId) || TextUtils.isEmpty(searchStr)) {
            return null;
        }
        return getDaoInstance().getImTextBeanEntityDao().queryBuilder().where(ImTextBeanEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ImTextBeanEntityDao.Properties.ConversationId.eq(chatId), ImTextBeanEntityDao.Properties.ChatType.notEq("0"), ImTextBeanEntityDao.Properties.ChatType.isNotNull(), ImTextBeanEntityDao.Properties.Content.like("%" + searchStr + "%")).orderAsc(ImTextBeanEntityDao.Properties.CreateTime).list();
    }

    //-----------------会话列表数据库---------------------//

    public static ConversationEntity queryChatEntity(String chatId) {
        //获取对话 实体类
        if (TextUtils.isEmpty(chatId)) {
            return null;
        }
        return getDaoInstance().getConversationEntityDao().queryBuilder().where(ConversationEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ConversationEntityDao.Properties.ConversationId.eq(chatId)).unique();
    }

    public static List<ConversationEntity> queryChatList() {
        //获取对话 列表
        return getDaoInstance().getConversationEntityDao().queryBuilder().where(ConversationEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey())).list();
    }

    public static List<ConversationEntity> queryChatList(String chatType) {
        //获取对话 列表
        if (TextUtils.isEmpty(chatType)) {
            return null;
        }
        return getDaoInstance().getConversationEntityDao().queryBuilder().where(ConversationEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ConversationEntityDao.Properties.ChatType.eq(chatType)).list();
    }

    public static List<ConversationEntity> sortChatList() {
        //重新排序会话
        ConversationEntityDao conversationEntityDao = getDaoInstance().getConversationEntityDao();
        List<ConversationEntity> conversationList = new ArrayList<>();
        if (conversationEntityDao != null) {
            conversationList = new ArrayList<>();
            List<ConversationEntity> entityTopList = conversationEntityDao.queryBuilder().where(ConversationEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ConversationEntityDao.Properties.Topped.notIn(0)).orderDesc(ConversationEntityDao.Properties.CreateTime).list();
            conversationList.addAll(entityTopList);
            List<ConversationEntity> entityNormalList = conversationEntityDao.queryBuilder().where(ConversationEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ConversationEntityDao.Properties.Topped.notIn(1)).orderDesc(ConversationEntityDao.Properties.CreateTime).list();
            conversationList.addAll(entityNormalList);
        }
        return conversationList;
    }

    //-----------------组织通讯录数据库---------------------//
    public static List<OrganizeEntity> queryOrganizeEntityList() {
        //获取通讯录 实体集合类
        return getDaoInstance().getOrganizeEntityDao().queryBuilder().where(OrganizeEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), OrganizeEntityDao.Properties.UserId.isNotNull()).list();
    }

    public static OrganizeEntity queryOrganizeEntity(String userId) {
        //获取通讯录 用户 实体类
        if (TextUtils.isEmpty(userId)) {
            return null;
        }
        return getDaoInstance().getOrganizeEntityDao().queryBuilder().where(OrganizeEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), OrganizeEntityDao.Properties.UserId.eq(userId)).unique();
    }

    public static List<OrganizeEntity> searchOrganizeEntityList(String searchStr) {
        //获取通讯录 用户 实体集合类
        if (TextUtils.isEmpty(searchStr)) {
            return null;
        }
        return getDaoInstance().getOrganizeEntityDao().queryBuilder()
                .where(OrganizeEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), OrganizeEntityDao.Properties.Label.like("%" + searchStr + "%"), OrganizeEntityDao.Properties.NodeType.eq("teacher"), OrganizeEntityDao.Properties.UserId.isNotNull())
                .list();
    }

    public static List<OrganizeEntity> searchOrganizeEntityByParentId(String parentId) {
        //获取通讯录 用户 实体集合类
        if (TextUtils.isEmpty(parentId)) {
            return null;
        }
        return getDaoInstance().getOrganizeEntityDao().queryBuilder().where(OrganizeEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), OrganizeEntityDao.Properties.ParentId.eq(parentId)).list();
    }

    //-----------------群组数据库---------------------//
    public static List<GroupEntity> queryGroupEntityList() {
        //获取群组 实体集合类
        return getDaoInstance().getGroupEntityDao().queryBuilder().where(GroupEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey())).list();
    }

    public static List<GroupEntity> searchGroupEntityList(String searchStr) {
        //获取群组 实体集合类
        if (TextUtils.isEmpty(searchStr)) {
            return null;
        }
        return getDaoInstance().getGroupEntityDao().queryBuilder().where(GroupEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupEntityDao.Properties.Pinyin.like("%" + searchStr + "%")).list();
    }

    public static GroupEntity queryGroupEntity(String chatId) {
        //获取群组 实体类
        if (TextUtils.isEmpty(chatId)) {
            return null;
        }
        return getDaoInstance().getGroupEntityDao().queryBuilder().where(GroupEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupEntityDao.Properties.ConversationId.eq(chatId)).unique();
    }

    //-----------------群设置数据库---------------------//

    public static boolean querySyncFileGroupSet(String chatId) {
        // 群设置-群文件自动保存至云盘
        if (TextUtils.isEmpty(chatId)) {
            return false;
        }
        GroupSetEntity syncEntity = getDaoInstance().getGroupSetEntityDao().queryBuilder().where(GroupSetEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupSetEntityDao.Properties.ChatType.in(2), GroupSetEntityDao.Properties.ChatId.eq(chatId), GroupSetEntityDao.Properties.SettingKey.eq("sync-group-file")).unique();
        if (syncEntity != null) {
            String syncValue = syncEntity.getValue();
            if ("1".equals(syncValue)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean queryAcceptModeGroupSet(String chatId) {
        // 群设置-消息免打扰
        if (TextUtils.isEmpty(chatId)) {
            return false;
        }
        GroupSetEntity groupNoticeEntity = getDaoInstance().getGroupSetEntityDao().queryBuilder().where(GroupSetEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupSetEntityDao.Properties.ChatType.in(2), GroupSetEntityDao.Properties.ChatId.eq(chatId), GroupSetEntityDao.Properties.SettingKey.eq("group-message-accept-mode")).unique();
        if (groupNoticeEntity != null) {
            String noticeValue = groupNoticeEntity.getValue();
            if ("AcceptNotNotify".equals(noticeValue)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean queryAcceptModePersonSet(String chatId) {
        // 个人设置-消息免打扰
        if (TextUtils.isEmpty(chatId)) {
            return false;
        }
        GroupSetEntity noticeEntity = getDaoInstance().getGroupSetEntityDao().queryBuilder().where(GroupSetEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupSetEntityDao.Properties.ChatType.in(1), GroupSetEntityDao.Properties.ChatId.eq(chatId)).unique();
        if (noticeEntity != null) {
            boolean noticeValue = noticeEntity.getIsNotDisturb();
            if (noticeValue) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static GroupSetEntity queryGroupSetEntity(String chatId) {
        // 设置-消息免打扰 实体类
        if (TextUtils.isEmpty(chatId)) {
            return null;
        }
        return getDaoInstance().getGroupSetEntityDao().queryBuilder().where(GroupSetEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupSetEntityDao.Properties.ChatId.eq(chatId)).unique();
    }

    public static boolean queryShowNickNameGroupSet(String chatId) {
        // 群设置-显示群成员昵称
        if (TextUtils.isEmpty(chatId)) {
            return false;
        }
        GroupSetEntity showNickEntity = getDaoInstance().getGroupSetEntityDao().queryBuilder().where(GroupSetEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupSetEntityDao.Properties.ChatType.in(2), GroupSetEntityDao.Properties.ChatId.eq(chatId), GroupSetEntityDao.Properties.SettingKey.eq("show-member-nickname")).unique();
        if (showNickEntity != null) {
            String showValue = showNickEntity.getValue();
            if ("1".equals(showValue)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean queryOnlyNoticeGroupSet(String chatId) {
        // 群设置-开启仅群主和管理员可管理公告开关
        if (TextUtils.isEmpty(chatId)) {
            return false;
        }
        GroupSetEntity onlyEntity = getDaoInstance().getGroupSetEntityDao().queryBuilder().where(GroupSetEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupSetEntityDao.Properties.ChatType.in(2), GroupSetEntityDao.Properties.ChatId.eq(chatId), GroupSetEntityDao.Properties.SettingKey.eq("only-admin-can-manage")).unique();
        if (onlyEntity != null) {
            String onlyValue = onlyEntity.getValue();
            if ("1".equals(onlyValue)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static GroupSetEntity queryOnlyNoticeGroupSetEntity(String chatId) {
        // 群设置-开启仅群主和管理员可管理公告开关
        if (TextUtils.isEmpty(chatId)) {
            return null;
        }
        return getDaoInstance().getGroupSetEntityDao().queryBuilder().where(GroupSetEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupSetEntityDao.Properties.ChatType.in(2), GroupSetEntityDao.Properties.ChatId.eq(chatId), GroupSetEntityDao.Properties.SettingKey.eq("only-admin-can-manage")).unique();
    }

    public static boolean queryJoinCheckGroupSet(String chatId) {
        // 群设置-入群验证开关
        if (TextUtils.isEmpty(chatId)) {
            return false;
        }
        GroupSetEntity joinCheckEntity = getDaoInstance().getGroupSetEntityDao().queryBuilder().where(GroupSetEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupSetEntityDao.Properties.ChatType.in(2), GroupSetEntityDao.Properties.ChatId.eq(chatId), GroupSetEntityDao.Properties.SettingKey.eq("joinCheck")).unique();
        if (joinCheckEntity != null) {
            String joinCheckValue = joinCheckEntity.getValue();
            if ("1".equals(joinCheckValue)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean queryOnlyRemindGroupSet(String chatId) {
        if (TextUtils.isEmpty(chatId)) {
            return false;
        }
        GroupSetEntity onlyRemindEntity = getDaoInstance().getGroupSetEntityDao().queryBuilder().where(GroupSetEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), GroupSetEntityDao.Properties.ChatType.in(2), GroupSetEntityDao.Properties.ChatId.eq(chatId), GroupSetEntityDao.Properties.SettingKey.eq("onlyAdminRemind")).unique();
        // 群设置-仅群主和群管理员可@所有人开关
        if (onlyRemindEntity != null) {
            String onlyRemindValue = onlyRemindEntity.getValue();
            if ("1".equals(onlyRemindValue)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    //-----------------聊天背景数据库----------------------//

    public static List<ChatBgEntity> queryChatBgEntityList() {
        //获取通讯录 实体集合类
        return getDaoInstance().getChatBgEntityDao().queryBuilder().where(ChatBgEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey())).list();
    }

    public static ChatBgEntity queryChatBgEntity(String chatId) {
        //获取通讯录 用户 实体类
        if (TextUtils.isEmpty(chatId)) {
            return null;
        }
        return getDaoInstance().getChatBgEntityDao().queryBuilder().where(ChatBgEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), ChatBgEntityDao.Properties.ChatId.eq(chatId)).unique();
    }

    //----------------------------------------------end-----------------------------------------------//


    /**
     * insert() 插入数据
     */
    public static void insertDbBean(Object bean) {
        try {
            getDaoInstance().insert(bean);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("插入本地数据失败：" + e.getMessage());
        }

    }


    /**
     * insertOrReplace()数据存在则替换，数据不存在则插入
     */
    public static void insertOrReplaceDbBean(Object bean) {
        try {
            getDaoInstance().insertOrReplace(bean);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("插入或替换本地数据失败：" + e.getMessage());
        }

    }


//    /**
//     * delete()删除单个数据
//     */
//    public static void deleteDbBean(DbBean bean) {
//        try {
//            getDaoInstance().delete(bean);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            LogUtil.e("删除本地数据失败：" + e.getMessage());
//        }
//
//    }


    /**
     * deleteAll()删除所有数据
     */
    public static void deleteAllDbBean(Object bean) {
        try {
//            getDaoInstance().deleteAll(bean.getClass());
            if (bean instanceof ImTextBeanEntity) {
                getDaoInstance().getImTextBeanEntityDao().deleteAll();
            } else if (bean instanceof ChatBgEntity) {
                getDaoInstance().getChatBgEntityDao().deleteAll();
            } else if (bean instanceof GroupEntity) {
                getDaoInstance().getGroupEntityDao().deleteAll();
            } else if (bean instanceof GroupSetEntity) {
                getDaoInstance().getGroupSetEntityDao().deleteAll();
            } else if (bean instanceof OrganizeEntity) {
                getDaoInstance().getOrganizeEntityDao().deleteAll();
            } else if (bean instanceof UploadBean) {
                getDaoInstance().getUploadBeanDao().deleteAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("删除本地所有数据失败：" + e.getMessage());
        }

    }


    /**
     * update()修改本地数据
     */
    public static void updateDbBean(Object bean) {
        try {
            getDaoInstance().update(bean);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("修改本地所有数据失败：" + e.getMessage());
        }

    }

    /**
     * 根据
     */


    /**
     * 根据条件查询本地所有数据
     * 调用时传值方法whereConditions
     * List<WhereCondition> whereConditions = new ArrayList<>();
     * whereConditions.add(StudentDao.Properties.Name.eq("小明"));
     * whereConditions.add(StudentDao.Properties.Age.eq(22));
     */
//    public static List<? extends DbBean> queryConditionAll(DbBean bean, List<WhereCondition> whereConditions) throws ClassCastException {
//        List<DbBean> beanList = null;
//        try {
//
//            QueryBuilder queryBuilder = getDaoInstance().queryBuilder(bean.getClass());
//            //把条件循环加入
//            if (null != whereConditions) {
//                for (WhereCondition whereCondition : whereConditions) {
//                    queryBuilder.where(whereCondition);
//                }
//
//            }
//            beanList = queryBuilder.build().list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d("LUO", "按条件查询本地数据失败：" + e.getMessage());
//        }
//
//        return beanList;
//    }


    /**
     * 根据原始 SQL 数据查询
     * 手输写 SQL 语句sqlConditions
     */
//    public static List<? extends DbBean> querySqlAll(DbBean bean, String sqlConditions) throws ClassCastException {
//        List<DbBean> beanList = null;
//        try {
//            //查询条件
//            WhereCondition.StringCondition stringCondition = new WhereCondition.StringCondition(sqlConditions);
//            //查询QueryBuilder
//            QueryBuilder<DbBean> queryBuilder = (QueryBuilder<DbBean>) getDaoInstance().queryBuilder(bean.getClass());
//            //添加查询条件
//            queryBuilder.where(stringCondition);
//
//            beanList = queryBuilder.build().list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d("LUO", "sql按条件查询本地数据失败：" + e.getMessage());
//        }
//
//        return beanList;
//    }

}

