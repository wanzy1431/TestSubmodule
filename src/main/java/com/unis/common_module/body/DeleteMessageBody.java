package com.unis.common_module.body;

import java.util.List;

public class DeleteMessageBody {

    public String conversationId;

    public List<String> msgIds;
    public int chatType;
    public String lastMsgId;
    public boolean empty;
}
