package com.unis.common_module.helper;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.unis.common_module.base.UnisApplication;
import com.unis.common_module.bean.SchoolOrganizeListBean;
import com.unis.common_module.daoentity.DaoSession;
import com.unis.common_module.daoentity.OrganizeEntity;
import com.unis.common_module.net.SpAPI;

import java.util.List;

public class OrganizeEntityHelper {

    public static void insertOrganizeList(JsonArray jsonArray) {
        //存储数据
        DaoSession daoSession = UnisApplication.instance().getDaoSession();
        //清空数据库 再写入
        daoSession.getOrganizeEntityDao().deleteAll();
        Gson gson = new Gson();
        List<SchoolOrganizeListBean> organizeListBeanList = gson.fromJson(jsonArray, new TypeToken<List<SchoolOrganizeListBean>>() {
        }.getType());
        SchoolOrganizeListBean schoolOrganizeListBean = organizeListBeanList.get(0);
        //插入数据库
        OrganizeEntity oe = getOe(schoolOrganizeListBean);
        daoSession.getOrganizeEntityDao().insertOrReplace(oe);
        traverseList(schoolOrganizeListBean.getChildren());
    }

    public static OrganizeEntity getOe(SchoolOrganizeListBean schoolOrganizeListBean) {
        OrganizeEntity organizeEntity = new OrganizeEntity();
        organizeEntity.setKeyId(SpAPI.THIS.getDbKey());
        organizeEntity.setId(schoolOrganizeListBean.getId());
        organizeEntity.setCreateTime(schoolOrganizeListBean.getCreateTime());
        organizeEntity.setCreator(schoolOrganizeListBean.getCreator());
        organizeEntity.setUpdateTime(schoolOrganizeListBean.getUpdateTime());
        organizeEntity.setModificator(schoolOrganizeListBean.getModificator());
        organizeEntity.setLabel(schoolOrganizeListBean.getLabel());
        organizeEntity.setParentId(schoolOrganizeListBean.getParentId());
        organizeEntity.setOrderno(schoolOrganizeListBean.getOrderno());
        organizeEntity.setChecked(schoolOrganizeListBean.getExtra().isChecked());
        organizeEntity.setNodeType(schoolOrganizeListBean.getExtra().getNodeType());
        organizeEntity.setUserPhoto(schoolOrganizeListBean.getExtra().getUserPhoto());
        organizeEntity.setUserId(schoolOrganizeListBean.getExtra().getUserId());
        return organizeEntity;
    }

    //递归遍历插入数据库
    public static void traverseList(List<SchoolOrganizeListBean> listBeans) {
        if (listBeans != null && listBeans.size() > 0) {
            for (int i = 0; i < listBeans.size(); i++) {
                OrganizeEntity oe = getOe(listBeans.get(i));
                UnisApplication.instance().getDaoSession().getOrganizeEntityDao().insertOrReplace(oe);
                if (listBeans.get(i).getExtra().getNodeType().equals("department")) {
                    traverseList(listBeans.get(i).getChildren());
                }
            }
        } else {
            return;
        }
    }

}
