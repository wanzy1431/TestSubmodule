package com.unis.common_module.utils;

import com.google.gson.Gson;
import com.unis.common_module.bean.LoginBean;
import com.unis.common_module.bean.MoxinAccount;
import com.unis.common_module.net.SpAPI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//import com.unis.teacher.bean.LoginBean;
//import com.unis.teacher.bean.MoxinAccount;
//import com.unis.teacher.net.SpAPI;

public class AccountUtils {
    public static MoxinAccount getSelectAccount() {
        Set<String> accounts = SpAPI.THIS.getAccounts();
        MoxinAccount selectMoxinAccount = null;
        Gson gson = new Gson();
        Iterator<String> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            MoxinAccount moxinAccount = gson.fromJson(next, MoxinAccount.class);
            if (moxinAccount.getIsSelect()) {
                selectMoxinAccount = moxinAccount;
                break;
            }
        }
        return selectMoxinAccount;
    }

    public static void setSelectAccount(String accountId) {
        Set<String> accounts = SpAPI.THIS.getAccounts();
        Set<String> accounts2 = new HashSet<>();
        Gson gson = new Gson();
        Iterator<String> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            MoxinAccount moxinAccount = gson.fromJson(next, MoxinAccount.class);
            if (moxinAccount.getAccountId().equals(accountId)) {
                moxinAccount.setIsSelect(true);
            } else {
                moxinAccount.setIsSelect(false);
            }
            accounts2.add(gson.toJson(moxinAccount));
        }
        SpAPI.THIS.setAccount(accounts2);
    }

    public static List<LoginBean.OtherAccountsBean> getAccountList() {
        Set<String> accounts = SpAPI.THIS.getAccounts();
        Iterator<String> iterator = accounts.iterator();
        MoxinAccount selectAccount = getSelectAccount();
        List<LoginBean.OtherAccountsBean> otherAccountsBeanList = new ArrayList<>();
        Gson gson = new Gson();
        while (iterator.hasNext()) {
            LoginBean.OtherAccountsBean otherAccountsBean = (LoginBean.OtherAccountsBean) gson.fromJson(iterator.next(), LoginBean.OtherAccountsBean.class);
            if (otherAccountsBean.getAccountId().equals(selectAccount.getAccountId())) {
                otherAccountsBean.setChecked(true);
            }
            otherAccountsBeanList.add(otherAccountsBean);
        }
        return otherAccountsBeanList;
    }

    //更新头像
    public static void updatePhoto(String accountId, String photo) {
        Set<String> accounts = SpAPI.THIS.getAccounts();
        Set<String> accounts2 = new HashSet<>();
        Gson gson = new Gson();
        Iterator<String> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            MoxinAccount moxinAccount = gson.fromJson(next, MoxinAccount.class);
            if (moxinAccount.getAccountId().equals(accountId)) {
                moxinAccount.setUserPhoto(photo);
            }
            accounts2.add(gson.toJson(moxinAccount));
        }
        SpAPI.THIS.setAccount(accounts2);
    }

    //更新手机号
    public static void updateMobile(String accountId, String mobile) {
        Set<String> accounts = SpAPI.THIS.getAccounts();
        Set<String> accounts2 = new HashSet<>();
        Gson gson = new Gson();
        Iterator<String> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            MoxinAccount moxinAccount = gson.fromJson(next, MoxinAccount.class);
            if (moxinAccount.getAccountId().equals(accountId)) {
                moxinAccount.setMobile(mobile);
            }
            accounts2.add(gson.toJson(moxinAccount));
        }
        SpAPI.THIS.setAccount(accounts2);
    }
}
