package com.unis.common_module.bean;

import java.util.List;

public class GroupDetailBean {

    /**
     * group : {"id":1000100000000655163,"createTime":"2020-07-22 09:26:28","creator":"1000000000003138012","updateTime":"2020-07-22 09:26:28","modificator":"0","groupName":"IM教师4、IM教师2、IM...","pinyin":"IMJIAOSHI4、IMJIAOSHI2、IM...","groupTypeCode":"selfBuild","schoolId":1000000000000587269,"avatarUrl":null,"sourceId":null,"memberCount":10,"qrCode":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAAEsCAIAAAD2HxkiAAAFVUlEQVR42u3awZHDQAwDwc0/aTuHqysaBHsCsCVhWy+9j6Sf9jwCCUIJQkkQShBKglCCUBKEEoSSIJQglAShBKEkCCUIJUEoQSgJQglCSRBKEEqCUIJQUjDCd7jRwcLuy+4QQgghhMaA0O4QQgghhMaA0O4QQgghhMaA0O4QQgghhMaA0O4QQgghhMaA0O4QQgghhAmHNe2+NsKwO4QQQgghhBDaHUIIIYQQQgjtDiGEEEJoDAjtDiGEEEJoDAjtDiGEEEJoDAjtDiGEEEK45bBuPGQb78vuEEIIIYTGgNDuEEIIIYTGgNDuEEIIIYTGgNDuEEIIIYTGgNDuEEIIIYTGgNDuEEIIIYTGyH+GdofQGBDaHUII7Q6hMSC0O4QQ2h1CY0Bod2NAaHcIjQEhhMaA0O4QGgNCCI0Bod0hNIZrhtAYHTA23heEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEENr9JsK04LE7hBBCCCGEENodQgghhNAYENodQgghhNAYENodQgghhNAYENodQgghhNAYENodQgghhPBvF93aZTx2hxBCCCE0BoR2hxBCCCE0BoR2hxBCCCE0BoR2hxBCCCE0BoR2hxBCCCE0BoR2hxBCCG8iVM6HxWmHTBBCCCGEglAQQgghhIJQEEIIIYSCUBBCCCGEglAQQgghhIJQEEIIYR9CHzr3PcO0l8vG/4IQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQwlaErYP91/Vcfil4SUEIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEII4U2EaYe1Fc/GA926O4QQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQXkaYdlg3/tdGzK1QIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYTwMsK0MQx/86UAIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQziBUH+Y0YG+w0fvCA0IIIYQQQggFIYQQQgghhIIQQgghhBBCQQghhBBCCKEghBBCCCGEUBBCuBDhO9xGqK3XDCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEOYg/Cxs432lvYBafwdCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCHM+QC39cPijR+dp+0V9wwhhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBDCOoRpzzkNYdoZG32GEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIYR1CmHc958nnAyGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGElxGmNTrG4Mtl4zXXnjEIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIISxF2NrGA9T6wbQPuCGE0O9ACCGEEEIIod+BEEJ4IIQQQr8DIYTwQAghhH4HQgjhgRBCCCGEEEJ4IIQQQghnEEqCUIJQEoQShJIglCCUBKEEoSQIJQglQShBKAlCCUJJEEoQSoJQglAShBKEkiCUIJQEoRTTF70FSUXlSuViAAAAAElFTkSuQmCC","notice":null}
     * nickName : IM教师1
     * groupMembers : [{"id":1000100000000655164,"createTime":null,"creator":null,"updateTime":null,"modificator":null,"groupId":1000100000000655163,"groupName":"IM教师4、IM教师2、IM...","userId":1000000000003138012,"userName":"IM教师4","pinyin":"IMJIAOSHI4","nickName":"IM教师4","memberType":"master","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138012/photo?pictureType=origin"},{"id":1000100000000655167,"createTime":null,"creator":null,"updateTime":null,"modificator":null,"groupId":1000100000000655163,"groupName":"IM教师4、IM教师2、IM...","userId":1000000000003138003,"userName":"IM教师1","pinyin":"IMJIAOSHI1","nickName":"IM教师1","memberType":"member","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138003/photo?pictureType=origin"},{"id":1000100000000655165,"createTime":null,"creator":null,"updateTime":null,"modificator":null,"groupId":1000100000000655163,"groupName":"IM教师4、IM教师2、IM...","userId":1000000000003138006,"userName":"IM教师2","pinyin":"IMJIAOSHI2","nickName":"IM教师2","memberType":"member","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin"},{"id":1000100000000655166,"createTime":null,"creator":null,"updateTime":null,"modificator":null,"groupId":1000100000000655163,"groupName":"IM教师4、IM教师2、IM...","userId":1000000000003138009,"userName":"IM教师3","pinyin":"IMJIAOSHI3","nickName":"IM教师3","memberType":"member","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138009/photo?pictureType=origin"},{"id":1000100000000655168,"createTime":null,"creator":null,"updateTime":null,"modificator":null,"groupId":1000100000000655163,"groupName":"IM教师4、IM教师2、IM...","userId":1000000000003138015,"userName":"IM教师5","pinyin":"IMJIAOSHI5","nickName":"IM教师5","memberType":"member","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138015/photo?pictureType=origin"},{"id":1000100000000655169,"createTime":null,"creator":null,"updateTime":null,"modificator":null,"groupId":1000100000000655163,"groupName":"IM教师4、IM教师2、IM...","userId":1000000000003138018,"userName":"IM教师6","pinyin":"IMJIAOSHI6","nickName":"IM教师6","memberType":"member","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138018/photo?pictureType=origin"},{"id":1000100000000655170,"createTime":null,"creator":null,"updateTime":null,"modificator":null,"groupId":1000100000000655163,"groupName":"IM教师4、IM教师2、IM...","userId":1000000000003138021,"userName":"IM教师7","pinyin":"IMJIAOSHI7","nickName":"IM教师7","memberType":"member","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138021/photo?pictureType=origin"},{"id":1000100000000655171,"createTime":null,"creator":null,"updateTime":null,"modificator":null,"groupId":1000100000000655163,"groupName":"IM教师4、IM教师2、IM...","userId":1000000000003138024,"userName":"IM教师8","pinyin":"IMJIAOSHI8","nickName":"IM教师8","memberType":"member","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138024/photo?pictureType=origin"},{"id":1000100000000655172,"createTime":null,"creator":null,"updateTime":null,"modificator":null,"groupId":1000100000000655163,"groupName":"IM教师4、IM教师2、IM...","userId":1000000000003138027,"userName":"IM教师9","pinyin":"IMJIAOSHI9","nickName":"IM教师9","memberType":"member","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138027/photo?pictureType=origin"},{"id":1000100000000655173,"createTime":null,"creator":null,"updateTime":null,"modificator":null,"groupId":1000100000000655163,"groupName":"IM教师4、IM教师2、IM...","userId":1000000000000646001,"userName":"IM小学管理员","pinyin":"IMXIAOXUEGUANLIYUAN","nickName":"IM小学管理员","memberType":"member","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000000646001/photo?pictureType=origin"}]
     */

    private GroupBean group;
    private String nickName;
    private boolean isNotDisturb;
    private List<GroupMembersBean> groupMembers;

    public GroupBean getGroup() {
        return group;
    }

    public void setGroup(GroupBean group) {
        this.group = group;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isNotDisturb() {
        return isNotDisturb;
    }

    public void setNotDisturb(boolean notDisturb) {
        isNotDisturb = notDisturb;
    }

    public List<GroupMembersBean> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<GroupMembersBean> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public static class GroupBean {
        /**
         * id : 1000100000000655163
         * createTime : 2020-07-22 09:26:28
         * creator : 1000000000003138012
         * updateTime : 2020-07-22 09:26:28
         * modificator : 0
         * groupName : IM教师4、IM教师2、IM...
         * pinyin : IMJIAOSHI4、IMJIAOSHI2、IM...
         * groupTypeCode : selfBuild
         * schoolId : 1000000000000587269
         * avatarUrl : null
         * sourceId : null
         * memberCount : 10
         * qrCode : data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAAEsCAIAAAD2HxkiAAAFVUlEQVR42u3awZHDQAwDwc0/aTuHqysaBHsCsCVhWy+9j6Sf9jwCCUIJQkkQShBKglCCUBKEEoSSIJQglAShBKEkCCUIJUEoQSgJQglCSRBKEEqCUIJQUjDCd7jRwcLuy+4QQgghhMaA0O4QQgghhMaA0O4QQgghhMaA0O4QQgghhMaA0O4QQgghhMaA0O4QQgghhAmHNe2+NsKwO4QQQgghhBDaHUIIIYQQQgjtDiGEEEJoDAjtDiGEEEJoDAjtDiGEEEJoDAjtDiGEEEK45bBuPGQb78vuEEIIIYTGgNDuEEIIIYTGgNDuEEIIIYTGgNDuEEIIIYTGgNDuEEIIIYTGgNDuEEIIIYTGyH+GdofQGBDaHUII7Q6hMSC0O4QQ2h1CY0Bod2NAaHcIjQEhhMaA0O4QGgNCCI0Bod0hNIZrhtAYHTA23heEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEENr9JsK04LE7hBBCCCGEENodQgghhNAYENodQgghhNAYENodQgghhNAYENodQgghhNAYENodQgghhPBvF93aZTx2hxBCCCE0BoR2hxBCCCE0BoR2hxBCCCE0BoR2hxBCCCE0BoR2hxBCCCE0BoR2hxBCCG8iVM6HxWmHTBBCCCGEglAQQgghhIJQEEIIIYSCUBBCCCGEglAQQgghhIJQEEIIYR9CHzr3PcO0l8vG/4IQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQwlaErYP91/Vcfil4SUEIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEII4U2EaYe1Fc/GA926O4QQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQXkaYdlg3/tdGzK1QIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYTwMsK0MQx/86UAIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQziBUH+Y0YG+w0fvCA0IIIYQQQggFIYQQQgghhIIQQgghhBBCQQghhBBCCKEghBBCCCGEUBBCuBDhO9xGqK3XDCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEOYg/Cxs432lvYBafwdCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCHM+QC39cPijR+dp+0V9wwhhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBDCOoRpzzkNYdoZG32GEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIYR1CmHc958nnAyGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGElxGmNTrG4Mtl4zXXnjEIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIISxF2NrGA9T6wbQPuCGE0O9ACCGEEEIIod+BEEJ4IIQQQr8DIYTwQAghhH4HQgjhgRBCCCGEEEJ4IIQQQghnEEqCUIJQEoQShJIglCCUBKEEoSQIJQglQShBKAlCCUJJEEoQSoJQglAShBKEkiCUIJQEoRTTF70FSUXlSuViAAAAAElFTkSuQmCC
         * notice : null
         */

        private long id;
        private String createTime;
        private String creator;
        private String updateTime;
        private String modificator;
        private String groupName;
        private String pinyin;
        private String groupTypeCode;
        private long schoolId;
        private String avatarUrl;
        private String sourceId;
        private int memberCount;
        private String qrCode;
        private String notice;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getModificator() {
            return modificator;
        }

        public void setModificator(String modificator) {
            this.modificator = modificator;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getGroupTypeCode() {
            return groupTypeCode;
        }

        public void setGroupTypeCode(String groupTypeCode) {
            this.groupTypeCode = groupTypeCode;
        }

        public long getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(long schoolId) {
            this.schoolId = schoolId;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getSourceId() {
            return sourceId;
        }

        public void setSourceId(String sourceId) {
            this.sourceId = sourceId;
        }

        public int getMemberCount() {
            return memberCount;
        }

        public void setMemberCount(int memberCount) {
            this.memberCount = memberCount;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

    }

    public static class GroupMembersBean {
        /**
         * id : 1000100000000655164
         * createTime : null
         * creator : null
         * updateTime : null
         * modificator : null
         * groupId : 1000100000000655163
         * groupName : IM教师4、IM教师2、IM...
         * userId : 1000000000003138012
         * userName : IM教师4
         * pinyin : IMJIAOSHI4
         * nickName : IM教师4
         * memberType : master
         * userPhoto : http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138012/photo?pictureType=origin
         */

        private long id;
        private String createTime;
        private String creator;
        private String updateTime;
        private String modificator;
        private long groupId;
        private String groupName;
        private long userId;
        private String userName;
        private String pinyin;
        private String nickName;
        private String memberType;
        private String userPhoto;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getModificator() {
            return modificator;
        }

        public void setModificator(String modificator) {
            this.modificator = modificator;
        }

        public long getGroupId() {
            return groupId;
        }

        public void setGroupId(long groupId) {
            this.groupId = groupId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getMemberType() {
            return memberType;
        }

        public void setMemberType(String memberType) {
            this.memberType = memberType;
        }

        public String getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            this.userPhoto = userPhoto;
        }
    }
}
