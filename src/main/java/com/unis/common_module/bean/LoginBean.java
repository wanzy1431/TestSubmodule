package com.unis.common_module.bean;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class LoginBean implements Parcelable {

    /**
     * code : password_error
     * msg : 用户名或密码错误
     * success : false
     * id : 1000000000000290001
     * account : teacher1
     * userName : 二教师1
     * mobile : 18911551700
     * email : null
     * accountId : 1000000000000290002
     * userPhoto : https://gitee.com/ma_chundi/typora-plugins-win-img/raw/master/images/dinotocat.png
     * accountType : teacher
     * accountTypeDesc : 普通教职工
     * schoolName : 北京大学
     * stationName : 学校管理员
     * token : eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxMDAwMDAwMDAwMDAwMjkwMDAxIiwibG9naW5Vc2VybmFtZSI6InRlYWNoZXIxIiwiYWNjb3VudElkIjoxMDAwMDAwMDAwMDAwMjkwMDAyLCJuYW1lIjoi5LqM5pWZ5biIMSIsInNjaG9vbElkIjoxMDAwMDAwMDAsInN0YXRpb25JZCI6InNjaG9vbEFkbWluIiwiZXhwIjoxNTkyNDY4NjM5fQ.fyq8G0kmwKDIj_p-D9GavEhnMTinx4Xn4ObTu-ACvxx1KpVIdNrbzWpCWM3XImZ02ljd3IFR4-Lg88mHSK-_LT6ImginfPRJsKFC3JG3t9CP8frYY8m5WYG89PjvCay9h32WYFV_5jZDSuXLR3l3-2oF_FwQUPxbdshRlkSR6D4
     * otherAccounts : [{"id":"1000000000000290001","account":"teacher1","userName":"二教师1","mobile":"18911551700","email":null,"accountId":"1000000000000290002","userPhoto":"https://gitee.com/ma_chundi/typora-plugins-win-img/raw/master/images/dinotocat.png","accountType":"teacher","accountTypeDesc":"普通教职工","schoolName":"北京大学","stationName":"教师（改）","token":"eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxMDAwMDAwMDAwMDAwMjkwMDAxIiwibG9naW5Vc2VybmFtZSI6InRlYWNoZXIxIiwiYWNjb3VudElkIjoxMDAwMDAwMDAwMDAwMjkwMDAyLCJuYW1lIjoi5LqM5pWZ5biIMSIsInNjaG9vbElkIjoxMDAwMDAwMDAsInN0YXRpb25JZCI6InRlYWNoZXIiLCJleHAiOjE1OTI0Njg2Mzl9.lmM2bPiajwFQBDzOVyBbEvkVq9clxbGCEAq6_0AHuc1IoBpDCCFipqHam_eerOuWU82HLKpTuPuAOF0IpIhW3TP6EO2sp2c9mNfvwzFcbXQcLLOKk30llqn3vxCxfHd6WFboN4SXpxfPgutZNOljkpnQQfYNEz5Rr9Fg23-VZ2c","otherAccounts":null,"className":null,"schoolNo":null,"accountStations":null,"accountAppClassifies":null}]
     * className : null
     * schoolNo : null
     * accountStations : null
     * accountAppClassifies : null
     */

    private String code;
    private String msg;
    private boolean success;
    private String id;
    private String account;
    private String userName;
    private String mobile;
    private String email;
    private String accountId;
    private String userPhoto;
    private String accountType;
    private String accountTypeDesc;
    private String schoolName;
    private String stationName;
    private String token;
    private String resetCode;
    private String className;
    private String schoolNo;
    private String accountStations;

    protected LoginBean(Parcel in) {
        code = in.readString();
        msg = in.readString();
        success = in.readByte() != 0;
        id = in.readString();
        account = in.readString();
        userName = in.readString();
        mobile = in.readString();
        email = in.readString();
        accountId = in.readString();
        userPhoto = in.readString();
        accountType = in.readString();
        accountTypeDesc = in.readString();
        schoolName = in.readString();
        stationName = in.readString();
        token = in.readString();
        resetCode = in.readString();
        className = in.readString();
        schoolNo = in.readString();
        accountStations = in.readString();
        schoolId = in.readString();
        accountAppClassifies = in.readString();
        otherAccounts = in.createTypedArrayList(OtherAccountsBean.CREATOR);
        isCheck = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(msg);
        dest.writeByte((byte) (success ? 1 : 0));
        dest.writeString(id);
        dest.writeString(account);
        dest.writeString(userName);
        dest.writeString(mobile);
        dest.writeString(email);
        dest.writeString(accountId);
        dest.writeString(userPhoto);
        dest.writeString(accountType);
        dest.writeString(accountTypeDesc);
        dest.writeString(schoolName);
        dest.writeString(stationName);
        dest.writeString(token);
        dest.writeString(resetCode);
        dest.writeString(className);
        dest.writeString(schoolNo);
        dest.writeString(accountStations);
        dest.writeString(schoolId);
        dest.writeString(accountAppClassifies);
        dest.writeTypedList(otherAccounts);
        dest.writeByte((byte) (isCheck ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LoginBean> CREATOR = new Creator<LoginBean>() {
        @Override
        public LoginBean createFromParcel(Parcel in) {
            return new LoginBean(in);
        }

        @Override
        public LoginBean[] newArray(int size) {
            return new LoginBean[size];
        }
    };

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    private String schoolId;
    private String accountAppClassifies;
    private List<OtherAccountsBean> otherAccounts;
    public boolean isCheck; //

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResetCode() {
        return resetCode;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeDesc() {
        return accountTypeDesc;
    }

    public void setAccountTypeDesc(String accountTypeDesc) {
        this.accountTypeDesc = accountTypeDesc;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchoolNo() {
        return schoolNo;
    }

    public void setSchoolNo(String schoolNo) {
        this.schoolNo = schoolNo;
    }

    public String getAccountStations() {
        return accountStations;
    }

    public void setAccountStations(String accountStations) {
        this.accountStations = accountStations;
    }

    public String getAccountAppClassifies() {
        return accountAppClassifies;
    }

    public void setAccountAppClassifies(String accountAppClassifies) {
        this.accountAppClassifies = accountAppClassifies;
    }

    public List<OtherAccountsBean> getOtherAccounts() {
        return otherAccounts;
    }

    public void setOtherAccounts(List<OtherAccountsBean> otherAccounts) {
        this.otherAccounts = otherAccounts;
    }

    public static class OtherAccountsBean implements Parcelable {
        /**
         * id : 1000000000000290001
         * account : teacher1
         * userName : 二教师1
         * mobile : 18911551700
         * email : null
         * accountId : 1000000000000290002
         * userPhoto : https://gitee.com/ma_chundi/typora-plugins-win-img/raw/master/images/dinotocat.png
         * accountType : teacher
         * accountTypeDesc : 普通教职工
         * schoolName : 北京大学
         * stationName : 教师（改）
         * token : eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxMDAwMDAwMDAwMDAwMjkwMDAxIiwibG9naW5Vc2VybmFtZSI6InRlYWNoZXIxIiwiYWNjb3VudElkIjoxMDAwMDAwMDAwMDAwMjkwMDAyLCJuYW1lIjoi5LqM5pWZ5biIMSIsInNjaG9vbElkIjoxMDAwMDAwMDAsInN0YXRpb25JZCI6InRlYWNoZXIiLCJleHAiOjE1OTI0Njg2Mzl9.lmM2bPiajwFQBDzOVyBbEvkVq9clxbGCEAq6_0AHuc1IoBpDCCFipqHam_eerOuWU82HLKpTuPuAOF0IpIhW3TP6EO2sp2c9mNfvwzFcbXQcLLOKk30llqn3vxCxfHd6WFboN4SXpxfPgutZNOljkpnQQfYNEz5Rr9Fg23-VZ2c
         * otherAccounts : null
         * className : null
         * schoolNo : null
         * accountStations : null
         * accountAppClassifies : null
         */

        private String id;
        private String account;
        private String userName;
        private String mobile;
        private String email;
        private String accountId;
        private String userPhoto;
        private String accountType;
        private String accountTypeDesc;
        private String schoolName;
        private String stationName;
        private String token;
        private String resetCode;
        private String otherAccounts;
        private String className;
        private String schoolNo;
        private String accountStations;
        private String accountAppClassifies;
        private String schoolId;
        private boolean checked;

        protected OtherAccountsBean(Parcel in) {
            id = in.readString();
            account = in.readString();
            userName = in.readString();
            mobile = in.readString();
            email = in.readString();
            accountId = in.readString();
            userPhoto = in.readString();
            accountType = in.readString();
            accountTypeDesc = in.readString();
            schoolName = in.readString();
            stationName = in.readString();
            token = in.readString();
            resetCode = in.readString();
            otherAccounts = in.readString();
            className = in.readString();
            schoolNo = in.readString();
            accountStations = in.readString();
            accountAppClassifies = in.readString();
            schoolId = in.readString();
            checked = in.readByte() != 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(account);
            dest.writeString(userName);
            dest.writeString(mobile);
            dest.writeString(email);
            dest.writeString(accountId);
            dest.writeString(userPhoto);
            dest.writeString(accountType);
            dest.writeString(accountTypeDesc);
            dest.writeString(schoolName);
            dest.writeString(stationName);
            dest.writeString(token);
            dest.writeString(resetCode);
            dest.writeString(otherAccounts);
            dest.writeString(className);
            dest.writeString(schoolNo);
            dest.writeString(accountStations);
            dest.writeString(accountAppClassifies);
            dest.writeString(schoolId);
            dest.writeByte((byte) (checked ? 1 : 0));
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<OtherAccountsBean> CREATOR = new Creator<OtherAccountsBean>() {
            @Override
            public OtherAccountsBean createFromParcel(Parcel in) {
                return new OtherAccountsBean(in);
            }

            @Override
            public OtherAccountsBean[] newArray(int size) {
                return new OtherAccountsBean[size];
            }
        };

        public boolean getChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }


        public OtherAccountsBean() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            this.userPhoto = userPhoto;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public String getAccountTypeDesc() {
            return accountTypeDesc;
        }

        public void setAccountTypeDesc(String accountTypeDesc) {
            this.accountTypeDesc = accountTypeDesc;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getResetCode() {
            return resetCode;
        }

        public void setResetCode(String resetCode) {
            this.resetCode = resetCode;
        }

        public String getOtherAccounts() {
            return otherAccounts;
        }

        public void setOtherAccounts(String otherAccounts) {
            this.otherAccounts = otherAccounts;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getSchoolNo() {
            return schoolNo;
        }

        public void setSchoolNo(String schoolNo) {
            this.schoolNo = schoolNo;
        }

        public String getAccountStations() {
            return accountStations;
        }

        public void setAccountStations(String accountStations) {
            this.accountStations = accountStations;
        }

        public String getAccountAppClassifies() {
            return accountAppClassifies;
        }

        public void setAccountAppClassifies(String accountAppClassifies) {
            this.accountAppClassifies = accountAppClassifies;
        }

        public String getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(String schoolId) {
            this.schoolId = schoolId;
        }
    }
}
