package com.unis.common_module.bean;

import java.util.ArrayList;

public class MessageDetailBean {

    private ArrayList<ReadBaseBean> readUsers;
    private ArrayList<ReadBaseBean> unreadUsers;

    public ArrayList<ReadBaseBean> getReadUsers() {
        return readUsers;
    }

    public void setReadUsers(ArrayList<ReadBaseBean> readUsers) {
        this.readUsers = readUsers;
    }

    public ArrayList<ReadBaseBean> getUnreadUsers() {
        return unreadUsers;
    }

    public void setUnreadUsers(ArrayList<ReadBaseBean> unreadUsers) {
        this.unreadUsers = unreadUsers;
    }


}
