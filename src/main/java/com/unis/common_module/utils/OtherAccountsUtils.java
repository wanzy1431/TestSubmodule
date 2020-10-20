package com.unis.common_module.utils;

//import com.unis.teacher.bean.LoginBean;

import com.unis.common_module.bean.LoginBean;

import java.util.ArrayList;
import java.util.List;

public class OtherAccountsUtils {
    public static List<LoginBean.OtherAccountsBean> getAccountBeanList(LoginBean loginBean) {
        List<LoginBean.OtherAccountsBean> otherAccountsBeanList = new ArrayList<>();
        LoginBean.OtherAccountsBean accountsBean = new LoginBean.OtherAccountsBean();
        accountsBean.setId(loginBean.getId());
        accountsBean.setAccount(loginBean.getAccount());
        accountsBean.setUserName(loginBean.getUserName());
        accountsBean.setMobile(loginBean.getMobile());
        accountsBean.setEmail(loginBean.getEmail());
        accountsBean.setAccountId(loginBean.getAccountId());
        accountsBean.setUserPhoto(loginBean.getUserPhoto());
        accountsBean.setAccountType(loginBean.getAccountType());
        accountsBean.setAccountTypeDesc(loginBean.getAccountTypeDesc());
        accountsBean.setSchoolName(loginBean.getSchoolName());
        accountsBean.setToken(loginBean.getToken());
        accountsBean.setResetCode(loginBean.getResetCode());
        accountsBean.setClassName(loginBean.getClassName());
        accountsBean.setSchoolNo(loginBean.getSchoolNo());
        accountsBean.setAccountStations(loginBean.getAccountStations());
        accountsBean.setAccountAppClassifies(loginBean.getAccountAppClassifies());
        accountsBean.setStationName(loginBean.getStationName());
        otherAccountsBeanList.add(accountsBean);
        if (loginBean.getOtherAccounts() != null && loginBean.getOtherAccounts().size() > 0) {
            otherAccountsBeanList.addAll(loginBean.getOtherAccounts());
        }
        return otherAccountsBeanList;
    }
}
