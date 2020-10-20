package com.unis.common_module.bean;

import java.util.List;

public class ChatHistorySearchBean {

    /**
     * records : [{"id":"1000100000000920008","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597650214000","chatType":"1","msgType":"text","content":"文艺","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"e2dbaa0fcaed4e2e8220b90d76afc874","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000911155","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597481709000","chatType":"1","msgType":"text","content":"bbb","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"e2d93812b8804ba3a87b0faba636e841","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872092","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597389354000","chatType":"1","msgType":"text","content":"bbb","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"6f26d62617d8497885fd81cada55a92e","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872090","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597389351000","chatType":"1","msgType":"text","content":"piu","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"0867386504624529a54c810feafcde25","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872088","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597389043000","chatType":"1","msgType":"text","content":"pkjh","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"87788403e5d849c1b1b6b4dc52a02b35","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872086","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597388971000","chatType":"1","msgType":"text","content":"ljhh","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"2a2606c8e5f34b2f9f8a6a746f1cf911","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872084","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597388930000","chatType":"1","msgType":"text","content":"ijj","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"1b9c43c5768d4aacb7194d034f93d0ed","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872082","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597388620000","chatType":"1","msgType":"text","content":"b","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"0d70cfe37d6746f0b92ea8eb4948eb75","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872080","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597388497000","chatType":"1","msgType":"text","content":"lnj","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"fb11a8e78a71479981c63a3bcbd15fef","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872078","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597388461000","chatType":"1","msgType":"text","content":"iijj","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"4f6475f394f748c4a8840fc7de7008aa","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872076","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597388392000","chatType":"1","msgType":"text","content":"BB","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"ae0bb4a2806342e08d384a394bacd842","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872074","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597388331000","chatType":"1","msgType":"text","content":"uhh","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"e05b10c64fc94e7094dd7b82ca9cb904","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872072","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597388003000","chatType":"1","msgType":"text","content":"gfg","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"47aecf86d28048fe842a73fd48e02700","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872068","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597387743000","chatType":"1","msgType":"text","content":"h","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"b198ba35008440a09c9d9d39a7e6ef78","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000872066","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1597387581000","chatType":"1","msgType":"text","content":"bbbb","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"71ad05e503304e76b7fc702d99cfb46c","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000835061","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1596867700000","chatType":"1","msgType":"text","content":"iijj","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"49ad748ce0af4f1db58c2bb00519e8a0","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000835053","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1596857823000","chatType":"1","msgType":"text","content":"gg","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"7f8bc8caa1be4347b3fe7288041a0c64","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000835047","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1596857633000","chatType":"1","msgType":"text","content":"hhh","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"bbc2471d1235481ca4aa60c67b5e8fda","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000835045","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1596857443000","chatType":"1","msgType":"text","content":"fg","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"0448cdd3224847b28c69d3da653e8fc3","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0},{"id":"1000100000000835013","from":"1000000000003138006","fromSchoolId":"1000000000000587269","to":"1000000000003138021","toSchoolId":"1000000000000587269","createTime":"1596856673000","chatType":"1","msgType":"text","content":"ippvgg","conversationId":"3be9e44f4fe37625ab382dad85348993","msgId":"190bcd4bfdf6435382adb1aadc7ad7b0","userPhoto":"http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138006/photo?pictureType=origin","readStatus":0}]
     * total : 21
     * size : 20
     * current : 1
     * pages : 2
     */

    private String total;
    private String size;
    private String current;
    private String pages;
    private List<RecordsBean> records;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class RecordsBean {
        /**
         * id : 5f44ad4a88150c7cb48925f0
         * from : 1000000000003138009
         * fromSchoolId : 1000000000000587269
         * to : 1000000000003138003
         * toSchoolId : 1000000000000587269
         * conversationId : 780e9e9e0ca7eb0dd0788ca8b0fb96e5
         * content : 33
         * extra : null
         * msgKey : 262_17128977_1598336331
         * msgType : text
         * msgSeq : null
         * msgTime : 2020-08-25 14:18:51
         * chatType : 1
         * createTime : 1598336331000
         * isAllRead : 0
         * msgId : f58b30aa39fe4f9b88b4f78505c8f2a0
         * serverMsgId : 1000100000001084073
         * readStatuses : null
         * deleteUserIds : null
         * storageTime : 2020-08-25 14:18:50
         * fromName : IM教师3
         * toName : IM教师1
         * cmd : null
         * userPhoto : http://dev.api.ckmooc.com/api/ecp.user.backend/user/1000000000003138009/photo?pictureType=origin
         * readCount : null
         */
        private String id;
        private String from;
        private String fromSchoolId;
        private String to;
        private String toSchoolId;
        private String conversationId;
        private Object content;
        private Object extra;
        private String msgKey;
        private String msgType;
        private Object msgSeq;
        private String msgTime;
        private int chatType;//0 系统消息
        private String createTime;
        private String isAllRead;
        private String msgId;
        private String serverMsgId;
        private Object readStatuses;
        private Object deleteUserIds;
        private String storageTime;
        private String fromName;
        private String toName;
        private String cmd;//message-withdraw 撤回消息
        private String userPhoto;
        private String readCount;
        private ReferenceBean reference;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getFromSchoolId() {
            return fromSchoolId;
        }

        public void setFromSchoolId(String fromSchoolId) {
            this.fromSchoolId = fromSchoolId;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getToSchoolId() {
            return toSchoolId;
        }

        public void setToSchoolId(String toSchoolId) {
            this.toSchoolId = toSchoolId;
        }

        public String getConversationId() {
            return conversationId;
        }

        public void setConversationId(String conversationId) {
            this.conversationId = conversationId;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Object getExtra() {
            return extra;
        }

        public void setExtra(Object extra) {
            this.extra = extra;
        }

        public String getMsgKey() {
            return msgKey;
        }

        public void setMsgKey(String msgKey) {
            this.msgKey = msgKey;
        }

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        public Object getMsgSeq() {
            return msgSeq;
        }

        public void setMsgSeq(Object msgSeq) {
            this.msgSeq = msgSeq;
        }

        public String getMsgTime() {
            return msgTime;
        }

        public void setMsgTime(String msgTime) {
            this.msgTime = msgTime;
        }

        public int getChatType() {
            return chatType;
        }

        public void setChatType(int chatType) {
            this.chatType = chatType;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getIsAllRead() {
            return isAllRead;
        }

        public void setIsAllRead(String isAllRead) {
            this.isAllRead = isAllRead;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public String getServerMsgId() {
            return serverMsgId;
        }

        public void setServerMsgId(String serverMsgId) {
            this.serverMsgId = serverMsgId;
        }

        public Object getReadStatuses() {
            return readStatuses;
        }

        public void setReadStatuses(Object readStatuses) {
            this.readStatuses = readStatuses;
        }

        public Object getDeleteUserIds() {
            return deleteUserIds;
        }

        public void setDeleteUserIds(Object deleteUserIds) {
            this.deleteUserIds = deleteUserIds;
        }

        public String getStorageTime() {
            return storageTime;
        }

        public void setStorageTime(String storageTime) {
            this.storageTime = storageTime;
        }

        public String getFromName() {
            return fromName;
        }

        public void setFromName(String fromName) {
            this.fromName = fromName;
        }

        public String getToName() {
            return toName;
        }

        public void setToName(String toName) {
            this.toName = toName;
        }

        public String getCmd() {
            return cmd;
        }

        public void setCmd(String cmd) {
            this.cmd = cmd;
        }

        public String getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            this.userPhoto = userPhoto;
        }

        public String getReadCount() {
            return readCount;
        }

        public void setReadCount(String readCount) {
            this.readCount = readCount;
        }

        public ReferenceBean getReference() {
            return reference;
        }

        public void setReference(ReferenceBean reference) {
            this.reference = reference;
        }
    }
}
