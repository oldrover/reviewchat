package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
    private Integer messageId;
    private String username;
    private String messagetext;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return messagetext;
    }

    public void setMessage(String messagetext) {
        this.messagetext = messagetext;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }
}
