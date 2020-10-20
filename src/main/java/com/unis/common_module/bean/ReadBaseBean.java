package com.unis.common_module.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ReadBaseBean implements Parcelable {

    /**
     * userId : 1000000000003138003
     * schoolId : 1000000000000587269
     * schoolName : null
     * userName : IM教师1
     * nickName : IM教师1
     * userPhoto : http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138003/photo?pictureType=origin
     * userStatus : null
     * mobile : null
     * email : null
     * block : null
     * gender : null
     * account : null
     * departments : null
     * jobs : null
     */

    private String userId;
    private String schoolId;
    private Object schoolName;
    private String userName;
    private String nickName;
    private String userPhoto;
    private Object userStatus;
    private Object mobile;
    private Object email;
    private Object block;
    private Object gender;
    private Object account;
    private Object departments;
    private Object jobs;

    protected ReadBaseBean(Parcel in) {
        userId = in.readString();
        schoolId = in.readString();
        userName = in.readString();
        nickName = in.readString();
        userPhoto = in.readString();
    }

    public static final Creator<ReadBaseBean> CREATOR = new Creator<ReadBaseBean>() {
        @Override
        public ReadBaseBean createFromParcel(Parcel in) {
            return new ReadBaseBean(in);
        }

        @Override
        public ReadBaseBean[] newArray(int size) {
            return new ReadBaseBean[size];
        }
    };

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public Object getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(Object schoolName) {
        this.schoolName = schoolName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Object getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Object userStatus) {
        this.userStatus = userStatus;
    }

    public Object getMobile() {
        return mobile;
    }

    public void setMobile(Object mobile) {
        this.mobile = mobile;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getBlock() {
        return block;
    }

    public void setBlock(Object block) {
        this.block = block;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public Object getDepartments() {
        return departments;
    }

    public void setDepartments(Object departments) {
        this.departments = departments;
    }

    public Object getJobs() {
        return jobs;
    }

    public void setJobs(Object jobs) {
        this.jobs = jobs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userId);
        parcel.writeString(schoolId);
        parcel.writeString(userName);
        parcel.writeString(nickName);
        parcel.writeString(userPhoto);
    }
}
