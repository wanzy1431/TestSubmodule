package com.unis.common_module.config;

public class CommonSelectionConfig {

    public static final int INTENT_FROM_MAIN = 1;//发起群聊
    public static final int INTENT_FROM_MANANGER = 2;//群管理添加成员
    public static final int INTENT_FROM_AUTHORITY_MANAGEMENT = 3;//云盘
    public static final int INTENT_FROM_WEB_CALENDAR = 6;//日程选人

    public static final int INTENT_FROM_SELECT_SESSION = 4;//会话控件
    public static final int INTENT_FROM_PERSON_MANAGE = 5;//个人管理添加成员


    public static final int CODE_SELECT_RESULT = 2233;
    public static final int CODE_REQUESTCODE_CALENDAR = 1111; // 日程

    public static final String CALENDAR_H5_TYPE = "CALENDAR_h5";

    public static final String CONTACTITEMBEANLIST_KEY = "contactItemBeanList";

    public static String INTENT_PARAM_IDS = "INTENT_PARAM_IDS";

    //数据库查询的标准写法
    //                if (b) {
//                    for (int i = 0; i < list.size(); i++) {
//                        list.get(i).setSelect(true);
//                        runOnThreeThread(() -> {
//                            OrganizeEntityDao organizeEntityDao = daoSession.getOrganizeEntityDao();
//                            List<OrganizeEntity> teachers = organizeEntityDao.queryBuilder().where(OrganizeEntityDao.Properties.NodeType.eq("teacher")).list();
//                            count = teachers.size();
//                            runOnUiThread(() -> {
//                                tvSure.setText("确定 (" + count + ")");
//                                tvPersonCount.setText("已选： " + count + "人");
//                            });
//                        });
//
//                    }
//                } else {
//                    for (int i = 0; i < list.size(); i++) {
//                        list.get(i).setSelect(false);
//                    }
//                    count = 0;
//                    tvSure.setText("确定 (" + count + ")");
//                    tvPersonCount.setText("已选： " + count + "人");
//                }
}
