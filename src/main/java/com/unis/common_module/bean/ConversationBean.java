package com.unis.common_module.bean;

import java.util.List;

public class ConversationBean {
    private int total;
    private int size;
    private int current;
    private int pages;
    private List<RecordsBean> records;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class RecordsBean {
        private String id;
        private String conversationId;
        private String toName;
        private int chatType;
        private String from;
        private String fromSchoolId;
        private String to;
        private String toSchoolId;
        private String msgId;
        private String content;
        private String createTime;
        private String msgType;
        private String chatBackground;
        private String delTime;
        private String clearTime;
        private int topped;
        private String lastReadMsgId;
        private String lastMsgId;
        private String userPhoto;
        private String msgTime;
        private int unreadCount;
        private boolean isNotDisturb;
        private String lastReportMsgTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getConversationId() {
            return conversationId;
        }

        public void setConversationId(String conversationId) {
            this.conversationId = conversationId;
        }

        public String getToName() {
            return toName;
        }

        public void setToName(String toName) {
            this.toName = toName;
        }

        public int getChatType() {
            return chatType;
        }

        public void setChatType(int chatType) {
            this.chatType = chatType;
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

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        public String getChatBackground() {
            return chatBackground;
        }

        public void setChatBackground(String chatBackground) {
            this.chatBackground = chatBackground;
        }

        public String getDelTime() {
            return delTime;
        }

        public void setDelTime(String delTime) {
            this.delTime = delTime;
        }

        public String getClearTime() {
            return clearTime;
        }

        public void setClearTime(String clearTime) {
            this.clearTime = clearTime;
        }

        public int getTopped() {
            return topped;
        }

        public void setTopped(int topped) {
            this.topped = topped;
        }

        public String getLastReadMsgId() {
            return lastReadMsgId;
        }

        public void setLastReadMsgId(String lastReadMsgId) {
            this.lastReadMsgId = lastReadMsgId;
        }

        public String getLastMsgId() {
            return lastMsgId;
        }

        public void setLastMsgId(String lastMsgId) {
            this.lastMsgId = lastMsgId;
        }

        public String getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            this.userPhoto = userPhoto;
        }

        public String getMsgTime() {
            return msgTime;
        }

        public void setMsgTime(String msgTime) {
            this.msgTime = msgTime;
        }

        public int getUnreadCount() {
            return unreadCount;
        }

        public void setUnreadCount(int unreadCount) {
            this.unreadCount = unreadCount;
        }

        public boolean isNotDisturb() {
            return isNotDisturb;
        }

        public void setNotDisturb(boolean notDisturb) {
            isNotDisturb = notDisturb;
        }

        public String getLastReportMsgTime() {
            return lastReportMsgTime;
        }

        public void setLastReportMsgTime(String lastReportMsgTime) {
            this.lastReportMsgTime = lastReportMsgTime;
        }
    }
}
