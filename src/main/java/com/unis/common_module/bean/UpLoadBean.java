package com.unis.common_module.bean;

public class UpLoadBean {


    /**
     * code : 1
     * msg : null
     * data : https://uniedudev.oss-cn-north-2.unicloudsrv.com/2020/09/02/b96ea254d2db41d462fab7dbd172c93b.jpeg
     * path : null
     * success : true
     */

    private String code;
    private Object msg;
    private String data;
    private Object path;
    private boolean success;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Object getPath() {
        return path;
    }

    public void setPath(Object path) {
        this.path = path;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
