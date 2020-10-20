package com.unis.common_module.body;

public
class ConversationListBody {
    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ConversationModel getModel() {
        return model;
    }

    public void setModel(ConversationModel model) {
        this.model = model;
    }

    private int current;
    private int size;
    private ConversationModel model;

}
