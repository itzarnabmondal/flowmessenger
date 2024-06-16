package com.example.flowmessenger.models;

public class Message {

    private Long id;
    private long conversationId;
    private String senderUsername;
    private String textContent;
    private boolean hasAttachment;
    private long unixTimestamp;

    public Message() {}

    public Message(long conversationId,
                   String senderUsername,
                   String textContent,
                   boolean hasAttachment) {
        this.conversationId = conversationId;
        this.senderUsername = senderUsername;
        this.textContent = textContent;
        this.hasAttachment = hasAttachment;
        unixTimestamp = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public long getConversationId() {
        return conversationId;
    }
    public void setConversationId(long conversationId) {
        this.conversationId = conversationId;
    }

    public String getSenderUsername() {
        return senderUsername;
    }
    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public String getTextContent() {
        return textContent;
    }
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public boolean isHasAttachment() {
        return hasAttachment;
    }
    public void setHasAttachment(boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    public long getUnixTimestamp() {
        return unixTimestamp;
    }
    public void setUnixTimestamp(long unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

}